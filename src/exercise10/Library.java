/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

import java.util.List;
import java.util.Set;

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
    
    /**
     * Gets the users who are currently borrowing at least one book.
     * 
     * @return list of borrowing users.
     */
    Set<String> getBorrowingUserNames();
    
    /**
     * Gets a list of all users registered with the library.
     * 
     * @return list of users.
     */
    Set<String> getAllUserNames();
    
    /**
     * Gets the user who is borrowing the specified book.
     * @param book
     * @return User borrowing the book
     */
    String getUserNameBorrowingBook(Book book);
    
    /**
     * Gets all the book titles borrowed by a user.
     * Book titles are strings in a list, so duplicate
     * titles will show multiple times.
     * 
     * @param user The user to inspect
     * @return The books borrowed by user.
     */
    List<Book> getBooksBorrowedByUser(User user);
    
    /**
     * Sets the maximum number of books any one person
     * can have at any one time, and returns the names
     * of the users who now violate this.
     * 
     * @param max_bpu Max books per user.
     * @return List of names of users who violate policy.
     */
    List<String> setMaxBookPolicy(int max_bpu);
    
    /**
     * Returns true if the user can take out another book,
     * false if the user can't.
     * 
     * @return If user can take out more books.
     */
    boolean canUserTakeMoreBooks(User user);
    
    /**
     * Gets the list of users who are borrowing the given title.
     * 
     * @param title The title of the book
     * @return The usernames of users borrowing this title.
     */
    Set<String> getBorrowersOfTitle(String title);
    
}
