/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;

import java.util.List;


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
    
    
    /**
     * Takes a book from the registered library.
     * 
     * @param title The title of the book to take.
     */
    void takeBook(String title);
    
    /**
     * Returns the list of books the user has taken.
     * 
     * @return list of books borrowed.
     */
    List<Book> getTakenBooks();

}
