package ch.informatik.m322.view.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableView extends JPanel {
    private JTable personenTabelle;


    String[] columns = {"ID", "surname", "firstname", "gender", "birthdate", "AHV-number", "region", "children"};

    private DefaultTableModel model;
    public TableView() {
        model = new DefaultTableModel(null, columns);
        personenTabelle = new JTable(model);
        JScrollPane test = new JScrollPane(personenTabelle);
        this.add(test);
    }


    public DefaultTableModel getModel() {
        return model;
    }

    public JTable getPersonenTabelle() {
        return personenTabelle;
    }
}
