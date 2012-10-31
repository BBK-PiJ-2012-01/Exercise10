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
     * Sets whether the book has been taken.
     * 
     * @param taken 
     */
    void setTaken(boolean taken);
    
    /**
     * Returns whether the book has been takes
     * 
     * @return taken status
     */
    boolean isTaken();
}
