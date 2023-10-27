package ch.informatik.m322.view.main;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private BottomView bottomPanel;
    private MainView mainPanel;

    public MainPanel() {
        super(new BorderLayout());

        mainPanel = new MainView();
        this.add(mainPanel, BorderLayout.CENTER);

        bottomPanel = new BottomView();
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    public BottomView getBottomPanel() {
        return bottomPanel;
    }

    public MainView getMainPanel() {
        return mainPanel;
    }
}
