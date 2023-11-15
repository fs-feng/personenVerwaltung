package ch.informatik.m322.view.main;

import ch.informatik.m322.model.Gender;
import ch.informatik.m322.model.Region;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Represents a panel displaying information about a person.
 */
public class InfoView extends JPanel {
    private JLabel labelId;
    private JLabel labelSurName;
    private JLabel labelFirstName;
    private JLabel labelGender;
    private JLabel labelBirthDate;
    private JLabel labelAhvNumber;
    private JLabel labelRegion;
    private JLabel labelChildren;

    private JLabel labelIdValue;
    private JLabel labelSurNameValue;
    private JLabel labelFirstNameValue;
    private JLabel labelGenderValue;
    private JLabel labelBirthDateValue;
    private JLabel labelAhvNumberValue;
    private JLabel labelRegionValue;
    private JLabel labelChildrenValue;

    private JPanel labelHolder;
    private JPanel labelValueHolder;

    /**
     * Constructs an InfoView panel for displaying person information.
     */
    public InfoView() {
        super(new BorderLayout());

        labelId = new JLabel("ID:");
        labelIdValue = new JLabel();
        labelSurName = new JLabel("surname:");
        labelSurNameValue = new JLabel();
        labelFirstName = new JLabel("firstname:");
        labelFirstNameValue = new JLabel();
        labelGender = new JLabel("gender:");
        labelGenderValue = new JLabel();
        labelBirthDate = new JLabel("birthdate:");
        labelBirthDateValue = new JLabel();
        labelAhvNumber = new JLabel("AHV-number:");
        labelAhvNumberValue = new JLabel();
        labelRegion = new JLabel("region:");
        labelRegionValue = new JLabel();
        labelChildren = new JLabel("children:");
        labelChildrenValue = new JLabel();

        labelHolder = new JPanel(new GridLayout(0,1));
        labelValueHolder = new JPanel(new GridLayout(0,1));

        labelHolder.add(labelId);
        labelHolder.add(labelSurName);
        labelHolder.add(labelFirstName);
        labelHolder.add(labelGender);
        labelHolder.add(labelBirthDate);
        labelHolder.add(labelAhvNumber);
        labelHolder.add(labelRegion);
        labelHolder.add(labelChildren);

        labelValueHolder.add(labelIdValue);
        labelValueHolder.add(labelSurNameValue);
        labelValueHolder.add(labelFirstNameValue);
        labelValueHolder.add(labelGenderValue);
        labelValueHolder.add(labelBirthDateValue);
        labelValueHolder.add(labelAhvNumberValue);
        labelValueHolder.add(labelRegionValue);
        labelValueHolder.add(labelChildrenValue);

        this.add(labelHolder, BorderLayout.WEST);
        this.add(labelValueHolder, BorderLayout.CENTER);
    }

    /**
     * Inserts information about a person into the view.
     * @param id the ID of the person
     * @param surName the surname of the person
     * @param firstName the first name of the person
     * @param gender the gender of the person
     * @param birthDate the birth date of the person
     * @param ahvNumber the AHV number of the person
     * @param region the region of the person
     * @param children the number of children the person has
     */
    public void insertInfo(int id, String surName, String firstName, Gender gender, LocalDate birthDate, String ahvNumber, Region region, int children) {
        labelIdValue.setText(Integer.toString(id));
        labelSurNameValue.setText(surName);
        labelFirstNameValue.setText(firstName);
        labelGenderValue.setText(gender.toString());
        labelBirthDateValue.setText(birthDate.toString());
        labelAhvNumberValue.setText(ahvNumber);
        labelRegionValue.setText(region.toString());
        labelChildrenValue.setText(Integer.toString(children));
    }


}
