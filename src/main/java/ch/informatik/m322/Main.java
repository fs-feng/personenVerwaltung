package ch.informatik.m322;

import ch.informatik.m322.controller.MainController;
import ch.informatik.m322.database.Connector;
import ch.informatik.m322.view.main.MainWindow;

import javax.swing.*;

/**
 * Entry point for the application. Initializes the main window, controller, and sets the
 * look and feel. Additionally, establishes a database connection.
 *
 * The applications GUI is executed on startup.
 */
public class Main {
    /**
     * Main entry point for the application.
     * Creates main window as gui and main controller as well as add the main window
     * to the main controller.
     *
     * The look and feel is set to windows to clean up the GUI.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  // This line gives Windows Theme

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            MainWindow mainWindow = new MainWindow();
            MainController mainController = new MainController(mainWindow);
        });

        Connector connector = Connector.getInstance();

    }
}