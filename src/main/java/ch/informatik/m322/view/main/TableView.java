package ch.informatik.m322.view.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableView extends JPanel {
    private JTable personenTabelle;

    Object[][] data = {
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            {"1", "Max", "Mustermann", "male", "1980-05-15", "123456789", "Zürich", 2},
            {"2", "Anna", "Meier", "female", "1990-02-20", "987654321", "Bern", 0},
            // Füge hier deine Datensätze aus der Datenbank ein
    };
    String[] columns = {"ID", "Vorname", "Nachname", "Geschlecht", "Geburtsdatum", "AHV-Nummer", "Region", "Kinder"};

    private DefaultTableModel model;
    public TableView() {
        model = new DefaultTableModel(data, columns);
        personenTabelle = new JTable(model);
        JScrollPane test = new JScrollPane(personenTabelle);
        this.add(test);


    }
}
