package ch.informatik.m322.view.dialog;

import javax.swing.*;

/**
 * @TODO
 */
public class DialogWindow extends JDialog {
    private DialogPanel dialogPanel;

    /**
     * @TODO
     * @param actionString
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
     * @TODO
     * @return
     */
    public DialogPanel getDialogPanel() {
        return dialogPanel;
    }
}
