package ch.informatik.m322.view.dialog;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class DialogWindow extends JDialog {
    private DialogPanel dialogPanel; // "Alle Daten & Eingaben"
    private ButtonPanel buttonPanel; // "speichern" & "abbrechen"
    private JPanel topPanel;
    private JPanel bottomPanel;

    public DialogWindow() {
        this.setTitle("Person erfassen");
        this.setLayout(new BorderLayout(10,10));

        dialogPanel = new DialogPanel();
        buttonPanel = new ButtonPanel();

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 2));
        topPanel.add(dialogPanel, BorderLayout.WEST);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2));
        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);

        this.setVisible(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(720, 480);









        // topPanel



        // mainGrid



        // bottomPanel



        this.setVisible(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(720, 480);
    }




    public static void main(String[] args) { // testing GUI
        new DialogWindow();
    }
}

/*

        JLabel topLabel = new JLabel("Person erfassen");
        JTextField textField = new JTextField(20);
        JFormattedTextField formattedTextField = new JFormattedTextField();
        JSpinner spinner = new JSpinner();





        dialogPanel = new DialogPanel();
        buttonPanel = new ButtonPanel();

        this.add(dialogPanel);
        this.add(topLabel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setSize(600,400);
        this.setModal(true);
        this.setVisible(true);


        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
 */
/*
* this.setTitle("Person erfassen");
        this.setLayout(new BorderLayout());

        topPanel = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Person erfassen");
        topPanel.setBorder(titledBorder);
        topPanel.setLayout(new GridLayout(6,2));

        topPanel.add(new JLabel("Vorname:"));
        vorname = new JTextField();
        topPanel.add(vorname);

        topPanel.add(new JLabel("Nachname:"));
        nachname = new JTextField();
        topPanel.add(nachname);

        // genderpanel here

        topPanel.add(new JLabel("Geburtsdatum:"));
        gebDatum = new JFormattedTextField();
        topPanel.add(gebDatum);

        topPanel.add(new JLabel("AHV-Nummer:"));
        ahvNum = new JFormattedTextField();
        topPanel.add(ahvNum);

        topPanel.add(new JLabel("Region:"));
        region = new JSpinner();
        topPanel.add(region);

        topPanel.add(new JLabel("Kinder:"));
        kinder = new JSpinner();
        topPanel.add(kinder);

        this.add(topPanel, BorderLayout.NORTH);

        dialogPanel = new DialogPanel();
        buttonPanel = new ButtonPanel();

        this.add(dialogPanel);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setSize(600,400);
        this.setModal(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
* */