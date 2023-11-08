package ch.informatik.m322.view.main;

import ch.informatik.m322.Main;

import javax.swing.*;

/**
 * @TODO
 */
public class MainWindow extends JFrame {
    private MainPanel mainPanel;

    /**
     * @TODO
     */
    public MainWindow() {
        super("Personen Verwaltung");
        mainPanel = new MainPanel();

        this.add(mainPanel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }

    /**
     * @TODO
     * @return
     */
    public MainPanel getMainPanel() {
        return mainPanel;
    }
}
