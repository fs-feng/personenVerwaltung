package ch.informatik.m322.view.dialog;
import ch.informatik.m322.model.Region;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class DialogPanel extends JPanel {

    GridLayout gridMain = new GridLayout(7, 3);

    JLabel frname = new JLabel("Vorname");
    JLabel lsname = new JLabel("Nachname");

    JRadioButton men = new JRadioButton("Mann");
    JRadioButton woman = new JRadioButton("Frau");
    JRadioButton other = new JRadioButton("Andere");
    ButtonGroup genderGroup = new ButtonGroup();
    JPanel genderPanel = new JPanel();
    FormattedField birthdateField = new FormattedField("##/##/####"); // # not working
    FormattedField ahvField = new FormattedField("###.####.####.##"); // # not working
    SpinnerModel regionSpinnerModel = new SpinnerListModel(Region.values());
    JSpinner regionSpinner = new JSpinner(regionSpinnerModel);
    JSpinner child = new JSpinner();

    public DialogPanel() {
        setLayout(gridMain);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(men);
        genderGroup.add(woman);
        genderGroup.add(other);
        genderPanel.add(men);
        genderPanel.add(woman);
        genderPanel.add(other);


        add(frname);
        add(new JTextField());
        add(lsname);
        add(new JTextField());
        add(new JLabel("Geschlecht"));
        add(genderPanel);
        add(new JLabel("Geburtsdatum"));
        add(birthdateField);
        add(new JLabel("AHV-Nummer"));
        add(ahvField);
        add(new JLabel("Region"));
        add(regionSpinner);
        add(new JLabel("Kinder"));
        add(child);

        this.setVisible(true);
        this.setOpaque(true);

    }

}
