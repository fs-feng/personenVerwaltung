package ch.informatik.m322.view.main;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the main view panel containing tables and information panels.
 */
public class MainView extends JPanel {
    private TableView personenTable;
    private InfoView infoPanel;

    /**
     * Constructs the MainView panel containing tables and information panels.
     */
    public MainView() {
        super(new BorderLayout());

        personenTable = new TableView();
        this.add(personenTable, BorderLayout.EAST);

        infoPanel = new InfoView();
        this.add(infoPanel, BorderLayout.WEST);
    }

    /**
     * Gets the table view of persons.
     * @return the table view of persons
     */
    public TableView getPersonenTable() {
        return personenTable;
    }

    /**
     * Gets the information panel.
     * @return the information panel
     */
    public InfoView getInfoPanel() {
        return infoPanel;
    }
}
