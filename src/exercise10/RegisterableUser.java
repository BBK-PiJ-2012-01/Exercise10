/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;


public interface RegisterableUser extends User {
    /**
     * Sets this user as a user of the given library.
     * 
     * @param library 
     */
    void register(Library library);
    
    /**
     * @return The name of the library the user is registered to.
     */
    String getLibrary();

}
