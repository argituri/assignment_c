package main.java;

/**
 * Class representing a Persons address.
 * Has public getters for all attributes (Street name, street number, apartment letter and number).
 */

public class Address {
    private String stName;
    private int stNo;
    private String aptLtr;
    private int aptNo;

    public Address(String stName, int stNo, String aptLtr, int aptNo) {
        this.stName = stName;
        this.stNo = stNo;
        this.aptLtr = aptLtr;
        this.aptNo = aptNo;
    }

    public String getStName() {
        return stName;
    }


    public int getStNo() {
        return stNo;
    }


    public String getAptLtr() {
        return aptLtr;
    }


    public int getAptNo() {
        return aptNo;
    }

}
