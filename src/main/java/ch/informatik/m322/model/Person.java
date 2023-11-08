package ch.informatik.m322.model;

import ch.informatik.m322.database.Connector;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @TODO
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
     *
     * @param id
     * @param surName
     * @param firstName
     * @param gender
     * @param birthDate
     * @param ahvNumber
     * @param region
     * @param children
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
     * @TODO
     * @param surName
     * @param firstName
     * @param gender
     * @param birthDate
     * @param ahvNumber
     * @param region
     * @param children
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
     * @TODO
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @TODO
     * @return
     */
    public String getSurName() {
        return surName;
    }

    /**
     * @TODO
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @TODO
     * @return
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @TODO
     * @return
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * @TODO
     * @return
     */
    public String getAhvNumber() {
        return ahvNumber;
    }

    /**
     * @TODO
     * @return
     */
    public Region getRegion() {
        return region;
    }

    /**
     * @TODO
     * @return
     */
    public int getChildren() {
        return children;
    }

    /**
     * @TODO
     * @param surName
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * @TODO
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @TODO
     * @param gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @TODO
     * @param birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @TODO
     * @param ahvNumber
     */
    public void setAhvNumber(String ahvNumber) {
        this.ahvNumber = ahvNumber;
    }

    /**
     * @TODO
     * @param region
     */
    public void setRegion(Region region) {
        this.region = region;
    }

    /**
     * @TODO
     * @param children
     */
    public void setChildren(int children) {
        this.children = children;
    }
}
