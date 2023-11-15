package ch.informatik.m322.view.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * The Panel for a dialog window.
 */
public class DialogPanel extends JPanel {
    private DialogMainView mainView;
    private DialogBottomView bottomView;

    /**
     * Constructs a DialogPanel with specified action string.
     *
     * @param actionString the action string for the dialog
     */
    public DialogPanel(String actionString) {
        super(new BorderLayout());
        mainView = new DialogMainView();
        bottomView = new DialogBottomView(actionString);


        this.add(mainView, BorderLayout.CENTER);
        this.add(bottomView, BorderLayout.SOUTH);
    }

    /**
     * Creates an error message dialog with the given error message.
     *
     * @param errorMessage the error message to be displayed
     */
    public void createErrorMessage(String errorMessage){
        JTextArea textArea = new JTextArea(6, 30);
        textArea.setText(errorMessage);
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea));
    }

    /**
     * Gets the main view of the dialog.
     * @return the main view of the dialog
     */
    public DialogMainView getMainView() {
        return mainView;
    }

    /**
     * Gets the bottom view of the dialog.
     * @return the bottom view of the dialog
     */
    public DialogBottomView getBottomView() {
        return bottomView;
    }
}
