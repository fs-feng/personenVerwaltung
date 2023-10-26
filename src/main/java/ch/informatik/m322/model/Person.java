package ch.informatik.m322.model;

import ch.informatik.m322.database.Connector;

import java.util.Date;

public class Person {
    private int id;
    private String surName;
    private String firstName;
    private Gender gender;
    private Date birthDate; //int year, int month, int date
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
    public Person(int id, String surName, String firstName, Gender gender, Date birthDate, String ahvNumber, Region region, int children) {
        this.id = id;
        this.surName = surName;
        this.firstName = firstName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.ahvNumber = ahvNumber;
        this.region = region;
        this.children = children;
    }


    //getter setter
    public int getId() {
        return id;
    }

    public String getSurName() {
        return surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getAhvNumber() {
        return ahvNumber;
    }

    public Region getRegion() {
        return region;
    }

    public int getChildren() {
        return children;
    }

    public void test() {
        Connector hjubhjih = Connector.getInstance();
    }

}