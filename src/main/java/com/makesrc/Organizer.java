package com.makesrc;

import java.util.List;
/***************************************************************************
 * Organizer.java - This is the interface that you must provide with a
 * concrete implementation. It represents a in memory manager/organizer for
 * Contact Objects.
 *
 * @author Kent Yang
 **************************************************************************/

public interface Organizer {

    /**
     * Add a Contact to the organizer.
     *
     * @param p A Contact object.
     */
    public void add(Contact p);

    /**
     * Remove a Contact from the organizer.
     *
     * @param email The email of the contact to be removed.
     */
    public void remove(String email);

    /**
     * Remove all Contacts from the organizer.
     *
     */
    public void empty();

    /**
     * Find all Contacts stored in the organizer with the same last name.
     * Note, there can be multiple contacts with the same last name.
     *
     * @param lastName The last name of the contacts your are looking for.
     *
     */
    public List<Contact> find(String lastName);

/**
 * Find the contact stored in the organizer with the email address.
 * Note, each Contact will have a unique email address.
 *
 * @param email the contact email address you are looking for.
 *
 */
    public Contact findByEmail(String email);

    /**
     * Return all the contact from the organizer.
     .
     *
     * @return A list of all Contact objects.
     *
     */
    public List<Contact> getAll();

    /**
     * Return all the contact from the organizer in
     * an array sorted by last name.
     *
     * @return A list of Contact objects.
     *
     */
    public List<Contact> getSortedListByLastName();

    /**
     * Return all the contact from the organizer in
     * an array sorted by first name.
     *
     * @return A list of Contact objects.
     *
     */
    public List<Contact> getSortedListByFirstName ();

    /**
     * Gets the size of the Organizer
     */
    public default int size() {
        return 0;
    }

    /**
     * Perform clean up or save state when application is about to close.
     *
     */
    public default void close() {};

}