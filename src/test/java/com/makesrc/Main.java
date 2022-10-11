package com.makesrc;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("What is the name of the file youd like to write to?");
        String name = s.next();
        File file = new File(name.concat(".txt"));
        FileDayTimer fdt = new FileDayTimer(file);


        fdt.Contacts = fdt.open(file);

        System.out.println("Adding a contact");
        fdt.Contacts.add(new Contact("NewPerson", "Person", "email","phone"));
        System.out.println(fdt.Contacts);

        System.out.println("Remove first contact email dearnie@gmail.com");
        fdt.remove("dearnie@gmail.com");
        System.out.println(fdt.Contacts);

        System.out.println("Clear out all the contacts lol ");
        fdt.empty();
        System.out.println(fdt.Contacts);

        System.out.println("Add three Contacts Back");
        fdt.Contacts.add(new Contact("Dylan", "Earnest", "dearnie@gmail.com", "2053121514"));
        fdt.Contacts.add(new Contact("Andy", "Kilgore", "kilgoreandy@icloud.com", "2053030173"));
        fdt.Contacts.add(new Contact("Charlie", "Zander", "c@icloud.com", "456789123"));

        System.out.println("Find Contacts with last name Kilgore");
        System.out.println(fdt.find("Kilgore"));

        System.out.println("Find Contacts with email address");
        fdt.findByEmail("dearnie@gmail.com");

        System.out.println("Get all contacts");
        System.out.println((fdt.getAll()));

        System.out.println("Get all contacts with last name sorted");
        System.out.println(fdt.getSortedListByLastName());

        System.out.println("Get all contacts with first name sorted");
        System.out.println(fdt.getSortedListByFirstName());

        System.out.println("Size of contacts");
        System.out.println(fdt.size());

        System.out.println("Author of program");
        System.out.println(fdt.getAuthor());


        System.out.println("Add three more contacts and save them back to the file");
        fdt.Contacts.add(new Contact("Rimmie", "Earnest", "rimiee@gmail.com", "564984564"));
        fdt.Contacts.add(new Contact("aunte", "Kilgore", "aunite@icloud.com", "456789123"));
        fdt.Contacts.add(new Contact("cuz", "blaster", "cuz@icloud.com", "789456123"));

        System.out.println(fdt.size());

        fdt.save(file, fdt.Contacts);


        System.out.println("Adding one more contact just for giggles and saving. ");
        fdt.Contacts.add(new Contact("last", "one", "lme@email.com","3030172"));
        fdt.save(file, fdt.Contacts);



    }
}
