package ch.informatik.m322.controller;

import ch.informatik.m322.database.Connector;
import ch.informatik.m322.model.Gender;
import ch.informatik.m322.model.Person;
import ch.informatik.m322.model.Region;
import ch.informatik.m322.view.main.MainWindow;
import ch.informatik.m322.view.main.TableView;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

/**
 * Controller handling actions and data flow for the main application view.
 */
public class MainController {
    private Connector connector;
    private MainListeners mainActionListeners;
    private MainWindow view;
    private Person person;
    private int index;
    private DialogController dialogController;

    /**
     * Constructs the MainController for managing the main application view.
     *
     * @param mainWindow the main window of the application
     */
    public MainController(MainWindow mainWindow) {
        connector = Connector.getInstance();
        dialogController = new DialogController(this);

        this.mainActionListeners = new MainListeners(
                this,
                mainWindow.getMainPanel().getBottomPanel().getBtnSwitchLeft(),
                mainWindow.getMainPanel().getBottomPanel().getBtnSwitchRight(),
                mainWindow.getMainPanel().getBottomPanel().getBtnCreatePerson(),
                mainWindow.getMainPanel().getBottomPanel().getBtnDeletePerson(),
                mainWindow.getMainPanel().getBottomPanel().getBtnEditPerson(),
                mainWindow.getMainPanel().getMainPanel().getPersonenTable().getPersonenTabelle(),
                mainWindow.getMainPanel().getMainPanel().getPersonenTable().getModel(),
                mainWindow);
        this.view = mainWindow;
        index = 1;
        try {
            updateTable();
            updateInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the table view with data from the database.
     *
     * @throws SQLException if a SQL exception occurs
     */
    public void updateTable() throws SQLException {
        DefaultTableModel tableModel = view.getMainPanel().getMainPanel().getPersonenTable().getModel();
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();

        connector.setSqlQuery("SELECT * FROM personen");
        connector.setStatement(connector.getConnection().createStatement());
        connector.setResultSet(connector.getStatement().executeQuery(connector.getSqlQuery()));

        while (connector.getResultSet().next()) {
            tableModel.addRow(new Object[] {
                    connector.getResultSet().getInt("id"),
                    connector.getResultSet().getString("name"),
                    connector.getResultSet().getString("vorname"),
                    connector.getResultSet().getString("geschlecht"),
                    connector.getResultSet().getDate("geburtsdatum"),
                    connector.getResultSet().getString("ahvnummer"),
                    connector.getResultSet().getString("region"),
                    connector.getResultSet().getInt("kinder")
            });

        }
    }

    /**
     * Sets the index to the last element of the data vector.
     */
    public void setIndexMax() {
        DefaultTableModel personenTableModel = view.getMainPanel().getMainPanel().getPersonenTable().getModel();
        index = (int) personenTableModel.getDataVector().elementAt(personenTableModel.getRowCount()-1).elementAt(0);
    }

    /**
     * Initializes information view with data from the database.
     *
     * @throws SQLException if a SQL exception occurs
     */
    public void initInfo() throws SQLException {
        connector.setSqlQuery("SELECT * FROM personen WHERE id=" + index);
        connector.setStatement(connector.getConnection().createStatement());
        connector.setResultSet(connector.getStatement().executeQuery(connector.getSqlQuery()));

        if (connector.getResultSet().next()) {
            getPersonInfo();
            view.pack();
        } else {
            index++;
            initInfo();
        }
    }

    /**
     * Updates information view with data from the database based on the current index.
     *
     * @throws SQLException if a SQL exception occurs
     */
    public void updateInfo() throws SQLException {

        connector.setSqlQuery("SELECT * FROM personen WHERE id=" + index);
        connector.setStatement(connector.getConnection().createStatement());
        connector.setResultSet(connector.getStatement().executeQuery(connector.getSqlQuery()));


        if (connector.getResultSet().next()) {
            getPersonInfo();
        }
    }

    /**
     * Retrieves person information from the database and updates the information view.
     *
     * @throws SQLException if a SQL exception occurs
     */
    private void getPersonInfo() throws SQLException {
        person = new Person(connector.getResultSet().getInt("id"),
                connector.getResultSet().getString("name"),
                connector.getResultSet().getString("vorname"),
                Gender.valueOf(connector.getResultSet().getString("geschlecht")),
                connector.getResultSet().getDate("geburtsdatum").toLocalDate(),
                connector.getResultSet().getString("ahvnummer"),
                Region.valueOf(connector.getResultSet().getString("region")),
                connector.getResultSet().getInt("kinder"));

        view.getMainPanel().getMainPanel().getInfoPanel().insertInfo(
                person.getId(),
                person.getSurName(),
                person.getFirstName(),
                person.getGender(),
                person.getBirthDate(),
                person.getAhvNumber(),
                person.getRegion(),
                person.getChildren()
        );
    }

    /**
     * Deletes a person from the database.
     *
     * @throws SQLException if a SQL exception occurs
     */
    public void deletePerson() throws SQLException {
        connector.setSqlQuery("DELETE FROM personen WHERE id = ?");
        connector.setPreparedStatement(connector.getConnection().prepareStatement(connector.getSqlQuery()));
        connector.getPreparedStatement().setInt(1, person.getId());
        connector.getPreparedStatement().executeUpdate();
    }

    /**
     * Gets the dialog controller associated with this MainController.
     * @return the dialog controller
     */
    public DialogController getDialogController() {
        return dialogController;
    }

    /**
     * Gets the currently selected person.
     * @return the currently selected person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Gets the current index value.
     * @return the current index value
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets the current index value.
     *
     * @param index the new index value to set
     */
    public void setIndex(int index) {
        this.index = index;
    }
}
