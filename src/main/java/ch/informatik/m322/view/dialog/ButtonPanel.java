package ch.informatik.m322.view.dialog;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    public ButtonPanel(){

        JButton save = new JButton();
        JButton cancel = new JButton();

        this.add(save);
        this.add(cancel);
        save.setPreferredSize(new Dimension(100,30));
        cancel.setPreferredSize(new Dimension(100,30));
        this.setLayout(new FlowLayout());
    }
}
