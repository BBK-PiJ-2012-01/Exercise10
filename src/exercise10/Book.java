/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public interface Book {
    /**
     * @return The book's Author.
     */
    String getAuthor();
    
    /**
     * @return The book's title
     */
    String getTitle();
    
    /**
     * Sets who the book is taken by.
     * 
     * @param user 
     */
    void setTakenBy(User user);
    
    /**
     * Returns the user who took the book.
     * 
     * @return user
     */
    User getTakenBy();
    
    /**
     * Sets the book as returned to the library.
     */
    void setReturned();
    
    /**
     * Returns whether the book has been takes
     * 
     * @return taken status
     */
    boolean isTaken();
}
