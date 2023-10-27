package ch.informatik.m322.controller;

import ch.informatik.m322.view.dialog.DialogWindow;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainListeners {
    private JButton btnSwitchLeft;
    private JButton btnSwitchRight;
    private JButton btnCreatePerson;
    private JButton btnDeletePerson;
    private JButton btnEditPerson;
    private JTable personenTable;
    private DefaultTableModel personenTableModel;

    public MainListeners(JButton btnSwitchLeft, JButton btnSwitchRight, JButton btnCreatePerson, JButton btnDeletePerson, JButton btnEditPerson, JTable personenTable, DefaultTableModel personenTableModel) {
        this.btnSwitchLeft = btnSwitchLeft;
        this.btnSwitchRight = btnSwitchRight;
        this.btnCreatePerson = btnCreatePerson;
        this.btnDeletePerson = btnDeletePerson;
        this.btnEditPerson = btnEditPerson;
        this.personenTable = personenTable;
        this.personenTableModel = personenTableModel;

        setupSwitchLeft();
        setupSwitchRight();
        setupCreatePerson();
        setupDeletePerson();
        setupEditPerson();
        setupTableSelectionListener();
    }

    private void setupSwitchLeft() {
        btnSwitchLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("left");
            }
        });
    }

    private void setupSwitchRight() {
        btnSwitchRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("right");
            }
        });
    }

    private void setupCreatePerson() {
        btnCreatePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("create");
            }
        });
    }

    private void setupDeletePerson() {
        btnDeletePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("delete");
            }
        });
    }

    private void setupEditPerson() {
        btnEditPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogWindow window = new DialogWindow();
            }
        });
    }

    private void setupTableSelectionListener() {
        personenTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Reagiere auf die Auswahl des Datensatzes
                    int selectedRow = personenTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        // Hier kannst du den ausgewählten Datensatz verwenden
                        Object selectedData = personenTableModel.getDataVector().elementAt(selectedRow);
                        System.out.println("Ausgewählter Datensatz: " + selectedData);
                    }
                }
            }
        });
    }
    /**
    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                // Reagiere auf die Auswahl des Datensatzes
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    // Hier kannst du den ausgewählten Datensatz verwenden
                    Object selectedData = model.getDataVector().elementAt(selectedRow);
                    System.out.println("Ausgewählter Datensatz: " + selectedData);
                }
            }
        }
    });**/
}
