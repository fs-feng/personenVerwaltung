package ch.informatik.m322.view.dialog;

import ch.informatik.m322.model.Region;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the main dialog view in the application.
 * It extends JPanel and contains various input fields and labels to collect user data.
 */
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


    private JDateChooser datePicker;
    private FormattedField ahvField;

    private JComboBox combobox;
    private JSpinner childSpinner;



    private JPanel labelHolder;
    private JPanel inputHolder;
    private JPanel genderHolder;

    /**
     * Constructor for the DialogMainView class.
     * It initializes all the components and adds them to the panel.
     */
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
            ahvField = new FormattedField("###.####.####.##");
        } catch (Exception e) {
            System.out.println(e);
        }

        datePicker = new JDateChooser();

        combobox = new JComboBox(Region.values());
        childSpinner = new JSpinner();

        radioWomen = new JRadioButton("woman");
        radioMen = new JRadioButton("men");
        radioOther = new JRadioButton("other");


        radioMen = new JRadioButton("male");
        radioOther = new JRadioButton("other");
        radioWomen = new JRadioButton("female");
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
        inputHolder.add(datePicker);
        inputHolder.add(ahvField);
        inputHolder.add(combobox);
        inputHolder.add(childSpinner);



        this.add(labelHolder, BorderLayout.WEST);
        this.add(inputHolder, BorderLayout.CENTER);
    }

    /**
     * Gets the JTextField representing the first name of the user.
     * @return the JTextField representing the first name of the user
     */
    public JTextField getFirstNameText() {
        return firstNameText;
    }

    /**
     * Sets the JTextField representing the first name of the user.
     *
     * @param firstNameText the JTextField representing the first name of the user
     */
    public void setFirstNameText(JTextField firstNameText) {
        this.firstNameText = firstNameText;
    }

    /**
     * Gets the JTextField representing the surname of the user.
     * @return the JTextField representing the surname of the user
     */
    public JTextField getSurNameText() {
        return surNameText;
    }

    /**
     * Sets the JTextField representing the surname of the user.
     *
     * @param surNameText the JTextField representing the surname of the user
     */
    public void setSurNameText(JTextField surNameText) {
        this.surNameText = surNameText;
    }

    /**
     * Gets the JRadioButton representing female gender.
     * @return the JRadioButton representing female gender
     */
    public JRadioButton getRadioWomen() {
        return radioWomen;
    }

    /**
     * Sets the JRadioButton representing female gender.
     *
     * @param radioWomen the JRadioButton representing female gender
     */
    public void setRadioWomen(JRadioButton radioWomen) {
        this.radioWomen = radioWomen;
    }

    /**
     * Gets the JRadioButton representing male gender.
     * @return the JRadioButton representing male gender
     */
    public JRadioButton getRadioMen() {
        return radioMen;
    }

    /**
     * Sets the JRadioButton representing male gender.
     *
     * @param radioMen the JRadioButton representing male gender
     */
    public void setRadioMen(JRadioButton radioMen) {
        this.radioMen = radioMen;
    }

    /**
     * Gets the JRadioButton representing other gender.
     * @return the JRadioButton representing other gender
     */
    public JRadioButton getRadioOther() {
        return radioOther;
    }

    /**
     * Sets the JRadioButton representing other gender.
     *
     * @param radioOther the JRadioButton representing other gender
     */
    public void setRadioOther(JRadioButton radioOther) {
        this.radioOther = radioOther;
    }

    /**
     * Gets the ButtonGroup for gender selection.
     * @return the ButtonGroup for gender selection
     */
    public ButtonGroup getGenderGroup() {
        return genderGroup;
    }

    /**
     * Sets the ButtonGroup for gender selection.
     *
     * @param genderGroup the ButtonGroup for gender selection
     */
    public void setGenderGroup(ButtonGroup genderGroup) {
        this.genderGroup = genderGroup;
    }

    /**
     * Gets the JDateChooser for date selection.
     * @return the JDateChooser for date selection
     */
    public JDateChooser getDatePicker() {
        return datePicker;
    }

    /**
     * Sets the JDateChooser for date selection.
     *
     * @param datePicker the JDateChooser for date selection
     */
    public void setDatePicker(JDateChooser datePicker) {
        this.datePicker = datePicker;
    }

    /**
     * Gets the FormattedField for AHV information.
     * @return the FormattedField for AHV information
     */
    public FormattedField getAhvField() {
        return ahvField;
    }

    /**
     * Sets the FormattedField for AHV information.
     *
     * @param ahvField the FormattedField for AHV information
     */
    public void setAhvField(FormattedField ahvField) {
        this.ahvField = ahvField;
    }

    /**
     * Gets the JSpinner for child information.
     * @return the JSpinner for child information
     */
    public JSpinner getChildSpinner() {
        return childSpinner;
    }

    /**
     * Sets the JSpinner for child information.
     *
     * @param childSpinner the JSpinner for child information
     */
    public void setChildSpinner(JSpinner childSpinner) {
        this.childSpinner = childSpinner;
    }

    /**
     * Sets the JComboBox for additional selection.
     *
     * @param combobox the JComboBox for additional selection
     */
    public void setCombobox(JComboBox combobox) {
        this.combobox = combobox;
    }

    /**
     * Gets the JComboBox for additional selection.
     * @return the JComboBox for additional selection
     */
    public JComboBox getCombobox() {
        return combobox;
    }
}
