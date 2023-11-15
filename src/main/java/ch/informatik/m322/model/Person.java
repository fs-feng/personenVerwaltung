package ch.informatik.m322.model;

import ch.informatik.m322.database.Connector;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * The `Person` class represents an individual with personal information, including their identification,
 * name, gender, birthdate, ahv number, region, and number of children. It provides methods
 * to access and modify the attributes of a person.
 *
 * Instances of this class can be created either with an ID or without an ID. If an ID is provided, it is assumed
 * that the person already exists in the database.
 *
 * When creating a person without an ID, it is assumed to be a new person, and the ID will be generated when the
 * person is added to the database.
 */
public class Person {
    private int id;
    private String surName;
    private String firstName;
    private Gender gender;
    private LocalDate birthDate; //int year, int month, int date
    private String ahvNumber;
    private Region region;
    private int children;

    /**
     * Constructs a new Person with the specified ID and personal information.
     * The person has to exist in the database.
     *
     * @param id        The identification number of the person.
     * @param surName   The surname of the person.
     * @param firstName The first name of the person.
     * @param gender    The gender of the person.
     * @param birthDate The birthdate of the person.
     * @param ahvNumber The AHV number of the person.
     * @param region    The region of the person.
     * @param children  The number of children the person has.
     */
    public Person(int id, String surName, String firstName, Gender gender, LocalDate birthDate, String ahvNumber, Region region, int children) {
        this.id = id;
        this.surName = surName;
        this.firstName = firstName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.ahvNumber = ahvNumber;
        this.region = region;
        this.children = children;
    }

    /**
     * Constructs a new Person without an ID with the specified personal information.
     * The person will receive an id when added into the sql database.
     *
     * @param surName   The surname of the person.
     * @param firstName The first name of the person.
     * @param gender    The gender of the person.
     * @param birthDate The birthdate of the person.
     * @param ahvNumber The AHV number of the person.
     * @param region    The region of the person.
     * @param children  The number of children the person has.
     */
    public Person(String surName, String firstName, Gender gender, Date birthDate, String ahvNumber, Region region, int children) {
        this.surName = surName;
        this.firstName = firstName;
        this.gender = gender;
        this.birthDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.ahvNumber = ahvNumber;
        this.region = region;
        this.children = children;
    }

    /**
     * Gets the id number of the person.
     *
     * @return The id number.
     */
    public int getId() {
        return id;
    }


    /**
     * Gets the surname of the person.
     *
     * @return The surname.
     */
    public String getSurName() {
        return surName;
    }

    /**
     * Gets the first name of the person.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the gender of the person.
     *
     * @return The gender.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Gets the birthdate of the person.
     *
     * @return The birthdate.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Gets the AHV number of the person.
     *
     * @return The AHV number.
     */
    public String getAhvNumber() {
        return ahvNumber;
    }

    /**
     * Gets the region of the person.
     *
     * @return The region.
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Gets the number of children the person has.
     *
     * @return The number of children.
     */
    public int getChildren() {
        return children;
    }

    /**
     * Sets the surname of the person.
     *
     * @param surName The new surname to set.
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * Sets the first name of the person.
     *
     * @param firstName The new first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the gender of the person.
     *
     * @param gender The new gender to set.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Sets the birthdate of the person.
     *
     * @param birthDate The new birthdate to set.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Sets the AHV number of the person.
     *
     * @param ahvNumber The new AHV number to set.
     */
    public void setAhvNumber(String ahvNumber) {
        this.ahvNumber = ahvNumber;
    }

    /**
     * Sets the region of the person.
     *
     * @param region The new region to set.
     */
    public void setRegion(Region region) {
        this.region = region;
    }

    /**
     * Sets the number of children the person has.
     *
     * @param children The new number of children to set.
     */
    public void setChildren(int children) {
        this.children = children;
    }
}
