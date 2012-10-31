/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public interface User {
    /**
     * Sets the user's ID.
     * 
     * @param The user's new ID.
     */
    void setID(int ID);
    
    /**
     * @return The user's ID (or -1 if no ID has been set).
     */
    int getID();
    
    /**
     * @return The user's name.
     */
    String getName();
    
}
