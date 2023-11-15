package ch.informatik.m322.view.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * A panel representing the bottom section of a dialog box.
 * called from DialogMainView.
 */
public class DialogBottomView extends JPanel {
    private JButton actionButton;
    private JButton cancelButton;

    /**
     * Constructs a DialogBottomView with an action button.
     *
     * @param actionString the text to display on the action button
     */
    public DialogBottomView(String actionString) {
        super(new FlowLayout(FlowLayout.RIGHT));
        actionButton = new JButton(actionString);
        cancelButton = new JButton("cancel");

        this.add(actionButton);
        this.add(cancelButton);
    }

    /**
     * Gets the action button.
     * @return the action button
     */
    public JButton getActionButton() {
        return actionButton;
    }

    /**
     * Gets the cancel button.
     * @return the cancel button
     */
    public JButton getCancelButton() {
        return cancelButton;
    }
}
