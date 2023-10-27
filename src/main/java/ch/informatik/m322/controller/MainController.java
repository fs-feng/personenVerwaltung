package ch.informatik.m322.controller;

import ch.informatik.m322.Main;
import ch.informatik.m322.database.Connector;
import ch.informatik.m322.view.main.MainWindow;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class MainController {
    private Connector connector;
    private MainActionListeners mainActionListeners;
    private MainWindow view;


    public MainController(MainWindow mainWindow) {
        connector = Connector.getInstance();

        this.mainActionListeners = new MainActionListeners(
                mainWindow.getMainPanel().getBottomPanel().getBtnSwitchLeft(),
                mainWindow.getMainPanel().getBottomPanel().getBtnSwitchRight(),
                mainWindow.getMainPanel().getBottomPanel().getBtnCreatePerson(),
                mainWindow.getMainPanel().getBottomPanel().getBtnDeletePerson(),
                mainWindow.getMainPanel().getBottomPanel().getBtnEditPerson());
        this.view = mainWindow;
        try {
            updateTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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


}
