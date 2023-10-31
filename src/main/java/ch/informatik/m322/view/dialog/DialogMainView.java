package ch.informatik.m322.view.dialog;

import ch.informatik.m322.model.Region;

import javax.swing.*;
import java.awt.*;

public class DialogMainView extends JPanel {
    private JLabel labelId;
    private JLabel labelSurName;
    private JLabel labelFirstName;
    private JLabel labelGender;
    private JLabel labelBirthDate;
    private JLabel labelAhvNumber;
    private JLabel labelRegion;
    private JLabel labelChildren;


    private JTextField firstNameText;
    private JTextField surNameText;

    private JRadioButton radioWomen;
    private JRadioButton radioMen;
    private JRadioButton radioOther;
    private ButtonGroup genderGroup;

    private FormattedField birthDateField;
    private FormattedField ahvField;

    private JSpinner regionSpinner;
    private JSpinner childSpinner;



    private JPanel labelHolder;
    private JPanel inputHolder;
    private JPanel genderHolder;

    public DialogMainView() {
        super(new BorderLayout());

        labelId = new JLabel("ID:");
        labelSurName = new JLabel("surname:");
        labelFirstName = new JLabel("firstname:");
        labelGender = new JLabel("gender:");
        labelBirthDate = new JLabel("birthdate:");
        labelAhvNumber = new JLabel("AHV-number:");
        labelRegion = new JLabel("region:");
        labelChildren = new JLabel("children:");

        labelHolder = new JPanel(new GridLayout(0,1));
        inputHolder = new JPanel(new GridLayout(0,1));

        labelHolder.add(labelSurName);
        labelHolder.add(labelFirstName);
        labelHolder.add(labelGender);
        labelHolder.add(labelBirthDate);
        labelHolder.add(labelAhvNumber);
        labelHolder.add(labelRegion);
        labelHolder.add(labelChildren);


        firstNameText = new JTextField();
        surNameText = new JTextField();

        try {
            birthDateField = new FormattedField("##-##-####");
            ahvField = new FormattedField("###.####.####.##");
        } catch (Exception e) {
            System.out.println(e);
        }

        regionSpinner = new JSpinner(new SpinnerListModel(Region.values()));
        childSpinner = new JSpinner();

        radioWomen = new JRadioButton("woman");
        radioMen = new JRadioButton("men");
        radioOther = new JRadioButton("other");


        radioMen = new JRadioButton("men");
        radioOther = new JRadioButton("woman");
        radioWomen = new JRadioButton("other");
        genderHolder = new JPanel(new FlowLayout(FlowLayout.CENTER));

        genderGroup = new ButtonGroup();
        genderGroup.add(radioWomen);
        genderGroup.add(radioMen);
        genderGroup.add(radioOther);
        genderHolder.add(radioWomen);
        genderHolder.add(radioMen);
        genderHolder.add(radioOther);



        inputHolder.add(surNameText);
        inputHolder.add(firstNameText);
        inputHolder.add(genderHolder);
        inputHolder.add(birthDateField);
        inputHolder.add(ahvField);
        inputHolder.add(regionSpinner);
        inputHolder.add(childSpinner);



        this.add(labelHolder, BorderLayout.WEST);
        this.add(inputHolder, BorderLayout.CENTER);
    }


    public JTextField getFirstNameText() {
        return firstNameText;
    }

    public JTextField getSurNameText() {
        return surNameText;
    }

    public ButtonGroup getGenderGroup() {
        return genderGroup;
    }

    public FormattedField getBirthDateField() {
        return birthDateField;
    }

    public FormattedField getAhvField() {
        return ahvField;
    }

    public JSpinner getRegionSpinner() {
        return regionSpinner;
    }

    public JSpinner getChildSpinner() {
        return childSpinner;
    }
}
