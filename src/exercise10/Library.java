/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public interface Library {
    /**
     * @return The name of the library.
     */
    String getName();
    
    /**
     * Gets the user's unique ID.
     * If the user is not registered, a new ID is returned.
     * If the user is registered, the user's ID is returned.
     * 
     * @param username
     * @return The user's ID.
     */
    int getID(String username);
    
    /**
     * Gets the maximum number of books any one person can have
     * from the library at any time.
     * 
     * @return Maximum books per user
     */
    int getMaxBooksPerUser();
}
