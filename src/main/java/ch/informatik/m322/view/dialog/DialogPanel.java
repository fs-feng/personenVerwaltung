package ch.informatik.m322.view.dialog;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class DialogPanel extends JPanel{

    public DialogPanel(){

        JPanel labelPanel = new JPanel();
        JPanel inputPanel = new JPanel();



        ButtonGroup radioGroup = new ButtonGroup();
        JRadioButton male = new JRadioButton("male", false);
        JRadioButton female = new JRadioButton("female", true);
        JRadioButton others = new JRadioButton("others", false);
        radioGroup.add(male);
        radioGroup.add(female);
        radioGroup.add(others);

        inputPanel.add(male);
        inputPanel.add(female);
        inputPanel.add(others);


        this.add(labelPanel, BorderLayout.WEST);
        this.add(inputPanel, BorderLayout.CENTER);
    }
}
