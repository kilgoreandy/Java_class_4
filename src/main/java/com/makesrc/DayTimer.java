package com.makesrc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DayTimer implements WhoDoneIt, Organizer {
    /**Create a new list named Contacts
     *
     */
     List<Contact> Contacts = new ArrayList<>();


    /**
     * Attempts to add a contact (p). Throws IllegalArgumentException if contact already exists.
     * @param p A Contact object.
     */
    @Override
    public void add(Contact p) {
        try{
            if (p == null) {
                throw new NullPointerException();
            }

            else if(Contacts.toString().contains(p.firstName) && Contacts.toString().contains(p.lastName) && Contacts.toString().contains(p.email) && (Contacts.toString().contains(p.phone))){
                throw new IllegalArgumentException("Contact already exists");
            }

            else{
                Contacts.add(p);
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Duplicate contact detected. Contact not added. ");
        }
        catch (NullPointerException e){
            System.out.println("Blank contact detected. Contact not added");
        }

    }

    /**
     * Remove a contact (p).
     * @param email The email of the contact to be removed.
     */
    @Override
    public void remove(String email) {
        Contacts.removeIf(contact -> contact.getEmail().equals(email));
    }


    /**
     * Empties the contact list
     */
    @Override
    public void empty() {
        Contacts.clear();
    }


    /**
     * Finds contact using last Name
     * @param lastName The last name of the contacts you are looking for.
     * @return LIST of Contact objects that fit criteria
     */
    @Override
    public List<Contact> find(String lastName) {
        List<Contact> find = new ArrayList<>();
        for (Contact contact : Contacts) {
            if (contact.getLastName().equals(lastName)) {
                find.add(contact);
                System.out.println(contact);
            }
        }
        return find;
    }


    /**
     *
     * @param email the contact email address you are looking for.
     * @return nothing, prints to console the contacts found.
     */
    @Override
    public Contact findByEmail(String email) {
        for (Contact contact : Contacts) {
            if (contact.getEmail().equals(email)) {
                System.out.println(contact);
            }
        }
        return null;
    }

    /**
     * Gets all the contacts in List Contacts
     * @return List of all contacts in the List Contacts
     */
    @Override
    public List<Contact> getAll() {
        return Contacts;
    }


    /**
     * Method sorts Contacts list and creates new list by last name
     * @return List of contacts by sorted Name
     */
    @Override
    public List<Contact> getSortedListByLastName() {
        List<Contact> sortedLastName = new ArrayList<>(Contacts);
        sortedLastName.sort(Comparator.comparing(Contact::getLastName));
        return sortedLastName;
    }


    /**
     * Method sorts Contacts list and creates new list by first name
     * @return List of contacts by sorted Name
     */
    @Override
    public List<Contact> getSortedListByFirstName() {
        List<Contact> sortedFirstName = new ArrayList<>(Contacts);
        sortedFirstName.sort(Comparator.comparing(Contact::getFirstName));
        return sortedFirstName;
    }


    /**
     * Gets the size of
     * @return size of Interface
     */
    @Override
    public int size() {
        return Contacts.size();
    }


    /**
     * gets the static author of this program
     * @return a new contact of author
     */
    @Override
    public Contact getAuthor() {
        return new Contact("Andy", "Kilgore", "Kilgoreandy@icloud.com", "205-303-0173");
    }
}
