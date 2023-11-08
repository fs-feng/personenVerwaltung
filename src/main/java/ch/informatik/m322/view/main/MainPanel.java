package ch.informatik.m322.view.main;

import javax.swing.*;
import java.awt.*;

/**
 * @TODO
 */
public class MainPanel extends JPanel {

    private BottomView bottomPanel;
    private MainView mainPanel;

    /**
     * @TODO
     */
    public MainPanel() {
        super(new BorderLayout());

        mainPanel = new MainView();
        this.add(mainPanel, BorderLayout.CENTER);

        bottomPanel = new BottomView();
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * @TODO
     * @return
     */
    public BottomView getBottomPanel() {
        return bottomPanel;
    }

    /**
     * @TODO
     * @return
     */
    public MainView getMainPanel() {
        return mainPanel;
    }
}
