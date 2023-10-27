package ch.informatik.m322.view.dialog;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    public ButtonPanel(){

        JButton button1 = new JButton();
        JButton button2 = new JButton();

        this.add(button1);
        this.add(button2);
        button1.setPreferredSize(new Dimension(100,100));
        button2.setPreferredSize(new Dimension(100,100));
        this.setLayout(new FlowLayout());
    }
}
