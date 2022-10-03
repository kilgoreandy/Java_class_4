package com.makesrc;

/**
 * Hello world!
 *
 */
public class App 
{

    /**
     * Create 2 contact objects with the same information, are they equal in value? What about in hash?
     * @param args
     */
    public static void main( String[] args )
    {
        Contact Contact1 = new Contact("Andy", "Kilgore", "email@test.com","205-303-0173");
        Contact Contact2 = new Contact("Andy", "Kilgore", "email@test.com","205-303-0173");
        System.out.println(Contact1);
        System.out.println("Are these two objects equal in values? " + Contact1.equals(Contact2));
        System.out.println("Hashes are the same? : " +  (Contact1.hashCode() == Contact2.hashCode()));
    }
}
