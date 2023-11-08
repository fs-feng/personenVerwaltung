package ch.informatik.m322.view.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @TODO
 */
public class TableView extends JPanel {
    private JTable personenTabelle;


    String[] columns = {"ID", "surname", "firstname", "gender", "birthdate", "AHV-number", "region", "children"};

    private DefaultTableModel model;

    /**
     * @TODO
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
     * @TODO
     * @return
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * @TODO
     * @return
     */
    public JTable getPersonenTabelle() {
        return personenTabelle;
    }
}
