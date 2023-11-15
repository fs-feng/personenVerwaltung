package ch.informatik.m322.controller;

import ch.informatik.m322.database.Connector;
import ch.informatik.m322.view.dialog.DialogWindow;
import ch.informatik.m322.view.main.MainWindow;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

/**
 * Class with ActionListeners for necessary components in the MainWindow
 */
public class MainListeners {
    private JButton btnSwitchLeft;
    private JButton btnSwitchRight;
    private JButton btnCreatePerson;
    private JButton btnDeletePerson;
    private JButton btnEditPerson;
    private JTable personenTable;
    private DefaultTableModel personenTableModel;
    private  MainController mainController;
    private MainWindow window;
    private Connector connector;

    /**
     * constructor to initialise the ActionListeners
     * @param mainController
     * @param btnSwitchLeft
     * @param btnSwitchRight
     * @param btnCreatePerson
     * @param btnDeletePerson
     * @param btnEditPerson
     * @param personenTable
     * @param personenTableModel
     * @param window
     */
    public MainListeners(MainController mainController, JButton btnSwitchLeft, JButton btnSwitchRight, JButton btnCreatePerson, JButton btnDeletePerson, JButton btnEditPerson, JTable personenTable, DefaultTableModel personenTableModel, MainWindow window) {
        this.mainController = mainController;
        this.btnSwitchLeft = btnSwitchLeft;
        this.btnSwitchRight = btnSwitchRight;
        this.btnCreatePerson = btnCreatePerson;
        this.btnDeletePerson = btnDeletePerson;
        this.btnEditPerson = btnEditPerson;
        this.personenTable = personenTable;
        this.personenTableModel = personenTableModel;
        this.window = window;

        this.connector = Connector.getInstance();

        setupSwitchLeft();
        setupSwitchRight();
        setupCreatePerson();
        setupDeletePerson();
        setupEditPerson();
        setupTableSelectionListener();
        setupWindowCloseListener();
    }

    /**
     * setup ActionListener for the switchLeft button in MainWindow
     * if actionPerformed, index will be set accordingly with setIndex() and updateInfo() aswell as updateTable() is executed.
     * Errors are handled with try-catch
     */
    private void setupSwitchLeft() {
        btnSwitchLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getIndex() > (int) personenTableModel.getDataVector().firstElement().elementAt(0) ) {
                    try {
                        mainController.setIndex(mainController.getIndex() - 1);
                        mainController.updateInfo();
                        mainController.updateTable();
                        while (mainController.getPerson().getId() != mainController.getIndex()) {
                            mainController.setIndex(mainController.getIndex() - 1);
                            mainController.updateInfo();
                            mainController.updateTable();
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

    /**
     * setup ActionListener for the switchRight button in MainWindow
     * if actionPerformed, index will be set accordingly with setIndex() and updateInfo() aswell as updateTable() is executed.
     * Errors are handled with try-catch
     */
    private void setupSwitchRight() {
        btnSwitchRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainController.getIndex() < (int) personenTableModel.getDataVector().elementAt(personenTableModel.getRowCount()-1).elementAt(0) - 1) {
                    try {
                        mainController.setIndex(mainController.getIndex() + 1);
                        mainController.updateInfo();
                        mainController.updateTable();
                        while (mainController.getPerson().getId() != mainController.getIndex()) {
                            mainController.setIndex(mainController.getIndex() + 1);
                            mainController.updateInfo();
                            mainController.updateTable();
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });
    }

    /**
     * setup ActionListener for the create-button in MainWindow
     * when the button is clicked, setupCreateDialog() is executed
     */
    private void setupCreatePerson() {
        btnCreatePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.getDialogController().setupCreateDialog();
            }
        });
    }

    /**
     * setup ActionListener for the edit-button in MainWindow
     * when the button is clicked, setupEditDialog() is executed with selected Person as parameter
     */
    private void setupEditPerson() {
        btnEditPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.getDialogController().setupEditDialog(mainController.getPerson());
            }
        });
    }

    /**
     * setup ActionListener for the delete-button in MainWindow
     * when the button is clicked, setupCreateDialog() is executed
     */
    private void setupDeletePerson() {
        btnDeletePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedPerson = mainController.getPerson().getId() + 1;
                try {
                    mainController.deletePerson();
                    mainController.updateInfo();
                    mainController.updateTable();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    /**
     * Sets up the selection listeners for the person table.
     * In order for them to be clickable and return the selected index to access the
     * right person.
     */
    private void setupTableSelectionListener() {
        personenTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = personenTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        mainController.setIndex((int) personenTableModel.getDataVector().elementAt(selectedRow).elementAt(0));
                        try {
                            mainController.updateInfo();
                            mainController.updateTable();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                }
            }
        });
    }

    /**
     * setup ActionListener for the MainWindow
     * if MainWindow is closing, close connection to database
     * Errors are handled with try-catch
     */
    private void setupWindowCloseListener() {
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                try {
                    mainController.initInfo();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    connector.closeConnection();
                    System.out.println("Window closed!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
