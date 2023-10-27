package ch.informatik.m322.view.main;

import ch.informatik.m322.Main;

import javax.swing.*;
import java.awt.*;

public class MainView extends JPanel {
    private TableView personenTable;
    private InfoView infoPanel;

    public MainView() {
        super(new BorderLayout());

        personenTable = new TableView();
        this.add(personenTable, BorderLayout.EAST);

        infoPanel = new InfoView();
        this.add(infoPanel, BorderLayout.WEST);
    }

    public TableView getPersonenTable() {
        return personenTable;
    }
}
