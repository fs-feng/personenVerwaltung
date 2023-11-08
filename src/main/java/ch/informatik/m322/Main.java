package ch.informatik.m322;

import ch.informatik.m322.controller.MainController;
import ch.informatik.m322.database.Connector;
import ch.informatik.m322.view.main.MainWindow;

import javax.swing.*;

/**
 * @TODO
 */
public class Main {
    /**
     * @TODO
     * @param args
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