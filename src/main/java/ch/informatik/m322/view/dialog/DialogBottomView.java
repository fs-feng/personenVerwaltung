package ch.informatik.m322.view.dialog;

import javax.swing.*;
import java.awt.*;

public class DialogBottomView extends JPanel {
    private JButton actionButton;
    private JButton cancelButton;

    public DialogBottomView(String actionString) {
        super(new FlowLayout(FlowLayout.RIGHT));
        actionButton = new JButton(actionString);
        cancelButton = new JButton("cancel");

        this.add(actionButton);
        this.add(cancelButton);
    }


    public JButton getActionButton() {
        return actionButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
