package ch.informatik.m322.view.dialog;

import javax.swing.*;
import java.awt.*;

public class DialogWindow extends JDialog {
    private DialogPanel dialogPanel;
    private ButtonPanel buttonPanel;

    public DialogWindow() {

        JLabel topLabel = new JLabel("Person erfassen");
        dialogPanel = new DialogPanel();
        buttonPanel = new ButtonPanel();

        this.add(dialogPanel);
        this.add(topLabel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setSize(600,400);
        this.setModal(true);
        this.setVisible(true);
    }
}
