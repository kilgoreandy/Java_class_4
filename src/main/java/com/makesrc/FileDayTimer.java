package com.makesrc;

import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create FileDay timer which extends from the already made Daytimer and implements both interfaces
 */
public class FileDayTimer extends DayTimer implements Organizer, WhoDoneIt {
    public FileDayTimer(File fileName) throws IOException {
        try {
            //If the file exists use it if not create it
            if (fileName.createNewFile()) {
                System.out.println("File created: " + fileName.getName());
            } else {
                System.out.println("File already exists.");
            }
            //see if error happened
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    //Logic for opening the file
    public static List<Contact> open(File file) throws IOException {
        Scanner input = new Scanner(file);
        input.useDelimiter(",");
        List<Contact> contacts = new ArrayList<Contact>();
        Pattern pat = Pattern.compile(".*'([^']*)'.*");
        String temp;
        while (input.hasNext()) {
            temp = input.next();
            Matcher m = pat.matcher(temp);
            m.matches();
            String firstName = m.group(1);
            temp = input.next();
            m = pat.matcher(temp);
            m.matches();
            String lastName = m.group(1);
            temp = input.next();
            m = pat.matcher(temp);
            m.matches()                ;
            String email = m.group(1);
            temp = input.next();
            m = pat.matcher(temp);
            m.matches();
            String phone = m.group(1);
            Contact p = new Contact(firstName, lastName, email, phone);
            contacts.add(p);
            input.nextLine();
            }
        return contacts;
        }

        // logic for saving the list to the text file specified
        public static void save(File file, List<Contact> contact) throws IOException {

            try (PrintWriter pw = new PrintWriter(file)) {
                for (Contact i: contact){
                    pw.println(i.toString());
                }
            }
        }

}






//        If all else fails
//        dir = dir.concat("/src/main/java/com/makesrc/");
//        Path path = Paths.get(dir + fileName);
//        boolean exists =Files.exists(path);
//        if (exists) {
//            System.out.println("File already exists with name, pulling back " + fileName);
//        }
//        else{
//
//        }