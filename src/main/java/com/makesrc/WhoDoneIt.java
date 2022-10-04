package com.makesrc;

/***************************************************************************
 * WhoDoneIt.java - Implementing this interface will help me figure out
 *                  who wrote the code.
 *
 * @author Kent Yang

 ***************************************************************************/

public interface WhoDoneIt {

    /**
     * This method will return a Contact Object identifying
     * a contact.  Initialize the Contact to yourself.
     *
     * @return Contact a Contact Object identifying yourself as the
     *  Contact who wrote the code.
     */
    public Contact getAuthor ();
}