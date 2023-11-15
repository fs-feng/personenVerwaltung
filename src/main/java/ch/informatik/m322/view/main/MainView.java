package ch.informatik.m322.view.main;

import javax.swing.*;
import java.awt.*;

/**
 * @TODO
 */
public class MainView extends JPanel {
    private TableView personenTable;
    private InfoView infoPanel;

    /**
     * @TODO
     */
    public MainView() {
        super(new BorderLayout());

        personenTable = new TableView();
        this.add(personenTable, BorderLayout.EAST);

        infoPanel = new InfoView();
        this.add(infoPanel, BorderLayout.WEST);
    }

    /**
     * @TODO
     * @return
     */
    public TableView getPersonenTable() {
        return personenTable;
    }

    /**
     * @TODO
     * @return
     */
    public InfoView getInfoPanel() {
        return infoPanel;
    }
}
