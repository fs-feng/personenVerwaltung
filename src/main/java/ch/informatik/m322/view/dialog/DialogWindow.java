package ch.informatik.m322.view.dialog;

import javax.swing.*;

/**
 * Represents a custom dialog window.
 */
public class DialogWindow extends JDialog {
    private DialogPanel dialogPanel;

    /**
     * Constructs a DialogWindow with specified action string and title.
     *
     * @param actionString the action string for the dialog
     * @param title the title of the dialog window
     */
    public DialogWindow(String actionString, String title) {
        this.setTitle(title);
        dialogPanel = new DialogPanel(actionString);
        this.add(dialogPanel);

        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    }

    /**
     * Gets the dialog panel contained within this DialogWindow.
     * @return the dialog panel
     */
    public DialogPanel getDialogPanel() {
        return dialogPanel;
    }
}
