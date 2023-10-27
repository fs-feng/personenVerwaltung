package ch.informatik.m322.view.main;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private TableView personenTable;
    private InfoView infoPanel;
    private BottomView bottomPanel;

    public MainPanel() {
        super(new BorderLayout());


        infoPanel = new InfoView();
        this.add(infoPanel, BorderLayout.WEST);

        bottomPanel = new BottomView();
        this.add(bottomPanel, BorderLayout.SOUTH);

        personenTable = new TableView();
        this.add(personenTable, BorderLayout.CENTER);




    }
}
