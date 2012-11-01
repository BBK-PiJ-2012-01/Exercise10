/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


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
        
        for(Book test_book : books_with_given_title) {
            if (!test_book.isTaken()) {
                return test_book;
            }
        }
        
        return null;
    }

    @Override
    public void returnBook(Book book) {
        List<Book> books_sharing_title = books_names_map.get(book.getTitle());
        book.setReturned();
        
        // If library doesn't have the book, it will take it (as a donation)
        if (books_sharing_title == null) {
            books_sharing_title = new LinkedList<Book>();
            books_sharing_title.add(book);
            books_names_map.put(book.getTitle(), books_sharing_title);
        } else {
            for(Book test_book : books_sharing_title) {
                if (test_book == book) {
                    return;
                }
            }
            
            books_sharing_title.add(book);
        }
    }

    @Override
    public int getReaderCount() {
        return user_ID_map.size();
    }

    @Override
    public int getBookCount() {
        int subtotal = 0;
        
        for (List<Book> book_lst : books_names_map.values()) {
            subtotal += book_lst.size();
        }
        
        return subtotal;
    }

    @Override
    public int getBookBorrowedCount() {
        int subtotal = 0;
        
        for (List<Book> book_lst : books_names_map.values()) {
            for (Book book : book_lst) {
                if (book.isTaken())
                    ++subtotal;
            }
        }
        return subtotal;
    }

    @Override
    public Set<String> getBorrowingUserNames() {
        Set<String> borrowing_users = new HashSet<String>();
        
        for (List<Book> book_lst : books_names_map.values()) {
            for (Book book : book_lst) {
                if (book.isTaken())
                    borrowing_users.add(book.getTakenBy().getName());
            }
            
        }
        
        return borrowing_users;
    }

    @Override
    public Set<String> getAllUserNames() {
        return user_ID_map.keySet();
    }

    @Override
    public String getUserNameBorrowingBook(Book book) {
        if (book.isTaken())
            return book.getTakenBy().getName();
        
        return null;
    }

    @Override
    public List<String> getBooksBorrowedByUser(User user) {
        List<String> book_names = new ArrayList<String>();
        
        for (List<Book> book_lst : books_names_map.values()) {
            for (Book book : book_lst) {
                if (book.getTakenBy() == user)
                    book_names.add(book.getTitle());
            }
            
        }
        
        return book_names;
    }
    
    


}
