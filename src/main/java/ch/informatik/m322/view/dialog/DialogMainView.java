package ch.informatik.m322.view.dialog;

import ch.informatik.m322.model.Region;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

/**
 * @TODO
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
     * @TODO
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
     * @TODO
     * @return
     */
    public JTextField getFirstNameText() {
        return firstNameText;
    }

    /**
     * @TODO
     * @param firstNameText
     */
    public void setFirstNameText(JTextField firstNameText) {
        this.firstNameText = firstNameText;
    }

    /**
     * @TODO
     * @return
     */
    public JTextField getSurNameText() {
        return surNameText;
    }

    /**
     * @TODO
     * @param surNameText
     */
    public void setSurNameText(JTextField surNameText) {
        this.surNameText = surNameText;
    }

    /**
     * @TODO
     * @return
     */
    public JRadioButton getRadioWomen() {
        return radioWomen;
    }

    /**
     * @TODO
     * @param radioWomen
     */
    public void setRadioWomen(JRadioButton radioWomen) {
        this.radioWomen = radioWomen;
    }

    /**
     * @TODO
     * @return
     */
    public JRadioButton getRadioMen() {
        return radioMen;
    }

    /**
     * @TODO
     * @param radioMen
     */
    public void setRadioMen(JRadioButton radioMen) {
        this.radioMen = radioMen;
    }

    /**
     * @TODO
     * @return
     */
    public JRadioButton getRadioOther() {
        return radioOther;
    }

    /**
     * @TODO
     * @param radioOther
     */
    public void setRadioOther(JRadioButton radioOther) {
        this.radioOther = radioOther;
    }

    /**
     * @TODO
     * @return
     */
    public ButtonGroup getGenderGroup() {
        return genderGroup;
    }

    /**
     * @TODO
     * @param genderGroup
     */
    public void setGenderGroup(ButtonGroup genderGroup) {
        this.genderGroup = genderGroup;
    }

    /**
     * @TODO
     * @return
     */
    public JDateChooser getDatePicker() {
        return datePicker;
    }

    /**
     * @TODO
     * @param datePicker
     */
    public void setDatePicker(JDateChooser datePicker) {
        this.datePicker = datePicker;
    }

    /**
     * @TODO
     * @return
     */
    public FormattedField getAhvField() {
        return ahvField;
    }

    /**
     * @TODO
     * @param ahvField
     */
    public void setAhvField(FormattedField ahvField) {
        this.ahvField = ahvField;
    }

    /**
     * @TODO
     * @return
     */
    public JSpinner getChildSpinner() {
        return childSpinner;
    }

    /**
     * @TODO
     * @param childSpinner
     */
    public void setChildSpinner(JSpinner childSpinner) {
        this.childSpinner = childSpinner;
    }

    /**
     * @TODO
     * @param combobox
     */
    public void setCombobox(JComboBox combobox) {
        this.combobox = combobox;
    }

    /**
     * @TODO
     * @return
     */
    public JComboBox getCombobox() {
        return combobox;
    }
}
