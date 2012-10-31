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
    
    /**
     * Adds a book to the library.
     * 
     * @param title The title of the new book.
     * @param author The author of the new book.
     */
    void addBook(String title, String author);
    
    /**
     * Takes the book if available, returns null if not.
     * 
     * @param title The title of the book to be taken.
     * @return The book, unless it's not available (returns null instead).
     */
    Book takeBook(String title);
    
    /**
     * Gives the book back to the library.
     * 
     * @param book The book to return to the library.
     */
    void returnBook(Book book);
    
    /**
     * Gets the total number of users registered with the library
     * 
     * @return Total number of users
     */
    int getReaderCount();
    
    /**
     * Gets the total number of books in the library (taken or not).
     * 
     * @return Total number of books
     */
    int getBookCount();
    
    /**
     * Gets the total number of books in the library that have been
     * taken out and not yet returned.
     * 
     * @return Number of books borrowed.
     */
    int getBookBorrowedCount();
}
