/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;


public class LibraryImpl implements Library {
    private final String name;
    private int max_bpu;
    private Map<String, Integer> user_ID_map = new HashMap<String, Integer>();
    private int next_available_id = 0;
    private Map<String, List<Book>> books_names_map = new HashMap<String, List<Book>>();

    public LibraryImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID(String name) {
        if (user_ID_map.containsKey(name))
            return user_ID_map.get(name);
        
        user_ID_map.put(name, next_available_id);
        return next_available_id++;
    }

    @Override
    public int getMaxBooksPerUser() {
        return max_bpu;
    }

    @Override
    public void addBook(String title, String author) {
        Book book = new BookImpl(title, author);
        
        if (!books_names_map.containsKey(title)) {
            List<Book> lst = new LinkedList<Book>();
            books_names_map.put(title, lst);
            lst.add(book);
        } else {
            books_names_map.get(title).add(book);
        }
    }

    @Override
    public Book takeBook(String title) {
        List<Book> books_with_given_title = books_names_map.get(title);
        if (books_with_given_title == null)
            return null;
        
        ListIterator<Book> itr = books_with_given_title.listIterator();
        Book test_book;
        
        while(itr.hasNext()) {
            test_book = itr.next();
            if (!test_book.isTaken()) {
                test_book.setTaken(true);
                return test_book;
            }
        }
        
        return null;
    }

    @Override
    public void returnBook(Book book) {
        List<Book> books_sharing_title = books_names_map.get(book.getTitle());
        
        // If library doesn't have the book, it will take it (as a donation)
        if (books_sharing_title == null) {
            books_sharing_title = new LinkedList<Book>();
            books_sharing_title.add(book);
            books_names_map.put(book.getTitle(), books_sharing_title);
        } else {
            ListIterator<Book> itr = books_sharing_title.listIterator();
            Book test_book;

            while(itr.hasNext()) {
                test_book = itr.next();
                if (test_book == book) {
                    book.setTaken(false);
                    return;
                }
            }
            
            books_sharing_title.add(book);
        }
    }

    @Override
    public int getReaderCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getBookCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getBookBorrowedCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
