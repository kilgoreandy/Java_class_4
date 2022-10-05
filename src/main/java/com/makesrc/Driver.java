package com.makesrc;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        //Create a new DayTimer object
        DayTimer DriverTimer = new DayTimer();

        //Add a few contacts to the Driver Timer
        DriverTimer.add(new Contact("Dylan", "Earnest", "dearnie@gmail.com", "2053121514"));
        DriverTimer.add(new Contact("Andy", "Kilgore", "kilgoreandy@icloud.com", "2053030173"));
        DriverTimer.add(new Contact());

        //Printing out both contacts
        for (Contact contact : DriverTimer.getAll()) {
            System.out.println(contact);
        }

        //Remove one contact then print all
        DriverTimer.remove("kilgoreandy@icloud.com");
        for (Contact contact: DriverTimer.getAll()){
            System.out.println(contact);
        }

        //Add a duplicate contact
        DriverTimer.add(new Contact("Dylan", "Earnest", "dearnie@gmail.com", "2053121514"));

        //Add contact back
        DriverTimer.add(new Contact("Andy", "Kilgore", "kilgoreandy@icloud.com", "2053030173"));
        for (Contact contact: DriverTimer.getAll()){
            System.out.println(contact);
        }

        //Empty
        DriverTimer.empty();
        System.out.println("emptying");
        for (Contact contact: DriverTimer.getAll()){
            System.out.println(contact);
        }

        //add records back
        DriverTimer.add(new Contact("Dylan", "Earnest", "dearnie@gmail.com", "2053121514"));
        DriverTimer.add(new Contact("Andy", "Kilgore", "kilgoreandy@icloud.com", "2053030173"));
        DriverTimer.add(new Contact("Charlie", "Zander", "c@icloud.com", "456789123"));

        //Sorting by firstname
        System.out.println("Sort by firstname");
        List<Contact> sorted =  DriverTimer.getSortedListByFirstName();
        for (Contact contact: sorted){
            System.out.println(contact);
        }

        //Sorting by lastname
        System.out.println("Sort by lastname");
        List<Contact> lnamesorted = DriverTimer.getSortedListByLastName();
        for (Contact contact: lnamesorted){
            System.out.println(contact);
        }

        //size of contact book?

        System.out.println(DriverTimer.size());
    }

}