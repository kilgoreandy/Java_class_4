package com.makesrc;

import java.util.Objects;

/**
 * Contact.java
 * @author Andy Kilgore
 * @version 1.0
 */

/**
 * Starting the Contact class, requires 4 String Params
 */
public class Contact {
    String firstName;
    String lastName;
    String email;
    String phone;

    public Contact(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
    //Default constructor
    public Contact() {
    }

    /**
     * Establish getters and setters
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    /**
     * Override tostring, equals, and hashCode
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Contact contact = (Contact) obj;
        return Objects.equals(firstName, contact.firstName) &&
                Objects.equals(lastName, contact.lastName) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(phone, contact.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, email, phone);
    }

    @Override
    public String toString() {
        return "Contact Info: Contact(firstName-'" + this.firstName + "', lastName-'" + this.lastName + "', email-'" + this.email + "', phone-'" + this.phone + "',)";
    }
}