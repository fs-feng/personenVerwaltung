package ch.informatik.m322.view.dialog;

import javax.swing.*;

public class DialogWindow extends JDialog {
    private DialogPanel dialogPanel;

    public DialogWindow(String actionString) {
        dialogPanel = new DialogPanel(actionString);
        this.add(dialogPanel);

        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    }

    public DialogPanel getDialogPanel() {
        return dialogPanel;
    }
}
