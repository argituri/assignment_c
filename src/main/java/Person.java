package main.java;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import main.java.Address;
import main.java.Relationship;
import main.java.Workplace;
/**
 * Class representing a person.
 * Contains basic information required in a civil registry.
 * Persons age is calculated from bDate and current Date.
 *
 */

public class Person implements Serializable {
    private String id;
    private Date bDate;
    private Date dDate;
    private String fName;
    private String lName;
    private String nativeLanguage;
    private Address livingAddress;
    private HashMap<String, Relationship> relativeIds;
    private main.java.Workplace workplace;

    public Person(String id, Date bDate, String fName, String lName, String nativeLanguage, Address livingAddress, HashMap<String, Relationship> relativeIds) {
        this.id = id;
        this.bDate = bDate;
        this.fName = fName;
        this.lName = lName;
        this.nativeLanguage = nativeLanguage;
        this.livingAddress = livingAddress;
        this.relativeIds = relativeIds;
    }

    // Alternative constructor taking all arguments except relativeIds as strings.
    public Person(String id, String bDate, String fName, String lName, String nativeLanguage, String stName, int stNo, String aptLtr, int aptNo, HashMap<String, main.java.Relationship> relativeIds) throws ParseException {
        this.id = id;
        SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/yyyy");
        this.bDate = dateForm.parse(bDate);
        this.fName = fName;
        this.lName = lName;
        this.nativeLanguage = nativeLanguage;
        this.livingAddress = new Address(stName, stNo, aptLtr, aptNo);
        this.relativeIds = relativeIds;
        // Database connection JDBC etc not implemented../ Person information does not persist
    }

    // Getters and setters
    public Workplace getWorkplace() {
        if (this.workplace != null){
            return workplace;
        }
        else{
            return null;
        }
    }

    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
        workplace.addWorker(this.id);
    }

    public HashMap<String, Relationship> getRelativeIds() {
        return relativeIds;
    }

    public void setRelativeIds(HashMap<String, Relationship> relativeIds) {
        this.relativeIds = relativeIds;
    }

    public void addRelatives(String relativeId, Relationship relationship){
        this.relativeIds.put(relativeId, relationship);
    }

    public String getId() {
        return id;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public Address getLivingAddress() {
        return livingAddress;
    }

    public void setLivingAddress(Address livingAddress) {
        this.livingAddress = livingAddress;
    }

    public int getAge(){
        Date now = new Date();
        long msDiff = Math.abs(this.bDate.getTime() - now.getTime());
        long days = TimeUnit.MILLISECONDS.toDays(msDiff);
        return (int) days/365;
    }

    // Utility methods

    // Method to add a relative. NOT IMPLEMENTED
    public void addRelative(String id, Relationship rel){
        System.out.println("Not Implemented!");/*
        if (!this.relativeIds.containsKey(id)){
            this.relativeIds.put(id, rel);
        }

        Relationship othersRelationship;
        switch (rel){
            case CHILD:
                othersRelationship = Relationship.GUARDIAN;
            case SPOUSE:
                othersRelationship = Relationship.SPOUSE;
            case GUARDIAN:
                othersRelationship = Relationship.CHILD;
        }*/
    }



    // Print information about this person
    public String getDescription(){
        return "Name: " + this.fName + " " + this.lName + ", \n" +
                "Age: " + this.getAge() + " years, " +
                "Works at: " + this.getWorkplace().getName() + ", " +
                "Has " + this.relativeIds.size() + " relatives.";
    }


}
