package ch.informatik.m322.view.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * @TODO
 */
public class DialogBottomView extends JPanel {
    private JButton actionButton;
    private JButton cancelButton;

    /**
     * @TODO
     * @param actionString
     */
    public DialogBottomView(String actionString) {
        super(new FlowLayout(FlowLayout.RIGHT));
        actionButton = new JButton(actionString);
        cancelButton = new JButton("cancel");

        this.add(actionButton);
        this.add(cancelButton);
    }

    /**
     * @TODO
     * @return
     */
    public JButton getActionButton() {
        return actionButton;
    }

    /**
     * @TODO
     * @return
     */
    public JButton getCancelButton() {
        return cancelButton;
    }
}
