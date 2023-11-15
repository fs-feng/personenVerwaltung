package ch.informatik.m322.view.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Represents a panel displaying a table view.
 */
public class TableView extends JPanel {
    private JTable personenTabelle;
    private DefaultTableModel model;
    String[] columns = {"ID", "surname", "firstname", "gender", "birthdate", "AHV-number", "region", "children"};

    /**
     * Constructs a TableView panel displaying a table with specified columns.
     */
    public TableView() {
        model = new DefaultTableModel(null, columns) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        personenTabelle = new JTable(model);
        JScrollPane test = new JScrollPane(personenTabelle);
        this.add(test);
    }

    /**
     * Gets the model associated with the table.
     * @return the table model
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * Gets the table displaying person information.
     * @return the table displaying person information
     */
    public JTable getPersonenTabelle() {
        return personenTabelle;
    }
}
