package ch.informatik.m322.view.main;

import javax.swing.*;

/**
 * The main window of the application, representing the graphical user interface for
 * managing persons. It extends the JFrame class and contains a MainPanel for displaying
 * the main content.
 */
public class MainWindow extends JFrame {
    private MainPanel mainPanel;

    /**
     * Constructs a new MainWindow with the title "Personen Verwaltung". Initializes the
     * MainPanel, sets default window behaviors, and displays the window.
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
     * Gets the MainPanel associated with this MainWindow.
     *
     * @return The MainPanel instance.
     */
    public MainPanel getMainPanel() {
        return mainPanel;
    }
}
