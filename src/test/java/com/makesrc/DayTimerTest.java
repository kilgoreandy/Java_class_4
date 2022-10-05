package com.makesrc;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DayTimerTest{


    // Create a new DayTimer object for testing
    DayTimer Timer1 = new DayTimer();

    //Setup test each time to attempt to add duplicates.
    @Before
    public void setUp() {
        try {
            Contact one = new Contact("Andy", "Kilgore", "test@test.com", "2053030173");
            Contact two = new Contact("Drew", "Kilgore", "tesg@test.com", "2057541578");
            Contact three = new Contact("Tanya", "Kilgore", "tkilgore@test.com", "468456454");
            Contact four = new Contact("Rodney", "Kilgore", "rkilgore@test.com", "5641354561");
            Contact duplicate = new Contact("Drew", "Kilgore", "test@test.com", "2057541578");
            Timer1.add(one);
            Timer1.add(two);
            Timer1.add(three);
            Timer1.add(four);
            Timer1.add(duplicate);
        }

        //Whatever errors we get, Print them to the console
        catch (Exception e) {
            System.out.println("Error Detected in Setup test: " + e);
        }
    }

    //Let us test the size function, without adding duplicates the size should be 4
    @Test
    public void size() {
        Contact one = new Contact("Andy", "Kilgore", "test@test.com", "2053030173");
        Contact two = new Contact("Drew", "Kilgore", "tesg@test.com", "2057541578");
        Contact three = new Contact("Tanya", "Kilgore", "tkilgore@test.com", "468456454");
        Contact four = new Contact("Rodney", "Kilgore", "rkilgore@test.com", "5641354561");
        Contact duplicate = new Contact("Drew", "Kilgore", "test@test.com", "2057541578");
        Timer1.add(one);
        Timer1.add(two);
        Timer1.add(three);
        Timer1.add(four);
        if (Timer1.Contacts.size() != 4) {
            fail("The size of the timer should be 4. It is currently: " + Timer1.size() + " Check to make sure no duplicates are being added.");
        }
    }

    //See if the new list contains the contact we added
    @Test
    public void add() {
        Contact added = new Contact("Added", "NewPerson", "added@test.com", "12053030173");
        Timer1.add(added);
        boolean result = Timer1.Contacts.contains(added);
        if (!result) {
            fail("The timer should contain the new object *added*. Be sure the object is being added correctly.");
        }

    }

    // See if the new list contains the contact we removed via email
    @Test
    public void remove() {
        Timer1.remove("test@test.com");
        for (Contact contact : Timer1.getAll()) {
            if (Timer1.Contacts.contains("test@test.com")) {
                fail("The timer should not contain the contact *contact*. Be sure the contact is being removed correctly.");
            }
        }
    }


    //See if emptying the list actually worked
    @Test
    public void empty() {
        Timer1.empty();
        if (Timer1.size() != 0) {
            fail("The size of the timer should be 0. Check to make you are removing all objects.");
        }
    }

    //See if the results are equal to what we queried for
    @Test
    public void find() {
        List<Contact> results = Timer1.find("Kilgore");

        for (Contact contact : results) {
            if (contact.lastName.contains("Kilgore")) {
            }
            else {
                fail("The contact(s) found did not contain the last name 'Kilgore'.");
            }
        }

    }

    //With no duplicates, the amount of contacts should be 4 if we get all records
    @Test
    public void getAll() {
        List<Contact> allresults = Timer1.getAll();
        if (allresults.size() != 4){
            fail("The size of the list should be " + allresults.size() + " but was " + Timer1.size() + ".");
        }

    }

    // If we sort by last name, the contacts would be in specified test order
    @Test
    public void getSortedListByLastName() {
        List<Contact> lastsort = Timer1.getSortedListByLastName();
        if (lastsort.get(0) == Timer1.Contacts.get(0)) {
        }
        else if (lastsort.get(1) == Timer1.Contacts.get(1)) {
        }
        else if (lastsort.get(2) == Timer1.Contacts.get(3)) {
        }
        else if (lastsort.get(3) == Timer1.Contacts.get(2)){
        }
        else{
            fail("The contact(s) was not in the right order");
        }
    }


    //If we sort by first name, contacts woulld be in specified test order
    @Test
    public void getSortedListByFirstName() {
        List<Contact> firstsort = Timer1.getSortedListByFirstName();
        if (firstsort.get(0) == Timer1.Contacts.get(0)) {
        } else if (firstsort.get(1) == Timer1.Contacts.get(1)) {
        } else if (firstsort.get(2) == Timer1.Contacts.get(3)) {
        } else if (firstsort.get(3) == Timer1.Contacts.get(2)) {
        } else {
            fail("The contact(s) was not in the right order");
        }
    }

    //let us make sure that we are actually setting the size instead of allowing it to default.
    @Test
    public void testSize() {
        if (Timer1.Contacts.size() != 0) {
        }
        else{
            fail("The list was defaulted to 0");
        }
    }


    //if we get the author, is it set? or is it null?
    @Test
    public void getAuthor() {
        if (Timer1.getAuthor() == null) {
            fail("The author has not been set");
        }
    }
}
