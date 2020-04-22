package test.java;

import main.java.Person;
import main.java.Relationship;
import main.java.Workplace;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Running tests")
public class PersonTest {

    static Workplace wp = new Workplace("Koodikerho Oy", "Verkahovinkatu", 3, "A", 1, new ArrayList<String>(), "123123-1");

    // Test personal info
    String id = "123456-A";
    String fName = "Teppo";
    String lName = "Testi";
    String bDate = "5/5/1990";
    String nativeLang = "finnish";

    // Test address info
    String stName = "Linnankatu";
    int stNo = 5;
    String aptLtr = "B";
    int aptNo = 2;

    // Test relative info
    HashMap<String, Relationship> relativeIds = new HashMap<String, Relationship>();

    // Test person
    static Person testPerson;

    {
        try {
            testPerson = new Person(id, bDate, fName, lName, nativeLang, stName, stNo, aptLtr, aptNo, relativeIds);
        } catch (ParseException e) {
            e.printStackTrace();
            fail(e);
        }
    }




    @Test
    @Order(1)
    void test1() {
            testPerson.setWorkplace(wp);
            assertEquals(testPerson.getDescription(), "Name: " + fName + " " + lName + ", \n" +
                    "Age: " + 29 + " years, " +
                    "Works at: " + wp.getName() + ", " +
                    "Has " + testPerson.getRelativeIds().size() + " relatives.");
    }

    @Test
    @Order(2)
    void test2(){
        assertTrue(wp.getWorkerIds().size()>0);
    }

}
