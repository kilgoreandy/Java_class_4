package com.makesrc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DayTimer implements WhoDoneIt, Organizer {
    /**Create a new list named Contacts
     *
     * @param p A Contact object.
     */
     List<Contact> Organizer = new ArrayList<Contact>();




    @Override
    public void add(Contact p) {
        try{
            if(Organizer.toString().contains(p.firstName) && Organizer.toString().contains(p.lastName) && Organizer.toString().contains(p.email) && (Organizer.toString().contains(p.phone))){
                throw new IllegalArgumentException("Contact already exists");
            }
            else{
                Organizer.add(p);
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Duplicate contact detected. Contact not added. ");
        }

    }

    @Override
    public void remove(String email) {
        Organizer.removeIf(contact -> contact.getEmail().equals(email));
    }

    @Override
    public void empty() {
        Organizer.clear();
    }

    @Override
    public List<Contact> find(String lastName) {
        List<Contact> find = new ArrayList<Contact>();
        for (Contact contact : Organizer) {
            if (contact.getLastName().equals(lastName)) {
                find.add(contact);
                System.out.println(contact);
            }
        }
        return find;
    }

    @Override
    public Contact findByEmail(String email) {
        for (Contact contact : Organizer) {
            if (contact.getEmail().equals(email)) {
                System.out.println(contact);
            }
        }
        return null;
    }

    @Override
    public List<Contact> getAll() {
        return Organizer;
    }

    @Override
    public List<Contact> getSortedListByLastName() {
        List<Contact> sortedLastName = new ArrayList<>(Organizer);
        sortedLastName.sort(Comparator.comparing(Contact::getLastName));
        return sortedLastName;
    }

    @Override
    public List<Contact> getSortedListByFirstName() {
        List<Contact> sortedFirstName = new ArrayList<>(Organizer);
        sortedFirstName.sort(Comparator.comparing(Contact::getFirstName));
        return sortedFirstName;
    }

    @Override
    public int size() {
        return Organizer.super.size();
    }

    @Override
    public Contact getAuthor() {
        return new Contact("Andy", "Kilgore", "Kilgoreandy@icloud.com", "205-303-0173");
    }
}
