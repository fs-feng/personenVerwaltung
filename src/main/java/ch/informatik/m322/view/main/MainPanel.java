package ch.informatik.m322.view.main;

import javax.swing.*;
import java.awt.*;

/**
 * The main panel of the application's graphical user interface. This JPanel
 * contains a MainView at the center and a BottomView at the bottom. It uses a
 * BorderLayout to organize the components.
 */
public class MainPanel extends JPanel {

    private BottomView bottomPanel;
    private MainView mainPanel;

    /**
     * Constructs a new MainPanel with BorderLayout. Initializes and adds the MainView
     * to the center and the BottomView to the south.
     */
    public MainPanel() {
        super(new BorderLayout());

        mainPanel = new MainView();
        this.add(mainPanel, BorderLayout.CENTER);

        bottomPanel = new BottomView();
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Gets the BottomView associated with this MainPanel.
     *
     * @return The BottomView instance.
     */
    public BottomView getBottomPanel() {
        return bottomPanel;
    }

    /**
     * Gets the MainView associated with this MainPanel.
     *
     * @return The MainView instance.
     */
    public MainView getMainPanel() {
        return mainPanel;
    }
}
