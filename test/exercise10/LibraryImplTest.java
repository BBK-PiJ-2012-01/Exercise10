/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class LibraryImplTest {
    String library_name = "Library name";
    Library library;
    
    @Before
    public void setUp() {
        library = new LibraryImpl(library_name);
    }

    /**
     * Test of getName method, of class LibraryImpl.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals(library_name, library.getName());
    }

    /**
     * Test of getID method, of class LibraryImpl.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        
        int id1 = library.getID("User 1");
        int id2 = library.getID("User 2");
        
        assertEquals(id1, library.getID("User 1"));
        assertEquals(id2, library.getID("User 2"));
        assertFalse(id1 == id2);
    }
    
    /**
     * Tests addBook and takeBook methods, of class LibraryImpl
     */
    @Test
    public void testAddBook() {
        library.addBook("Book Title1", "Book Author1");
        library.addBook("Book Title2", "Book Author2");
        library.addBook("Book Title3", "Book Author3");
        Book book = library.takeBook("Book Title2");
        assertEquals("Book Title2", book.getTitle());
        assertEquals("Book Author2", book.getAuthor());
    }
    
    /**
     * Tests taking an unavailable book
     */
    @Test
    public void testTakingUnavailableBook() {
        library.addBook("Book Title", "Book Author");
        RegisterableUser alice = new RegisterableUserImpl("Alice");
        alice.register(library);
        alice.takeBook("Book Title");
        assertNull(library.takeBook("Book Title"));
    }
    
    /**
     * Tests taking a book not in the library
     */
    @Test
    public void testTakingNonexistantBook() {
        assertNull(library.takeBook("Book Title"));
    }
    
    /**
     * Tests taking the last of duplicate books
     */
    @Test
    public void testTakingOneOfDuplicateBooks() {
        for (int i=0; i<3; ++i) {
            library.addBook("Book Title", "Book Author");
        }
        
        RegisterableUser alice = new RegisterableUserImpl("Alice");
        alice.register(library);
        
        for (int i=0; i<3; ++i) {
            assertNotNull(library.takeBook("Book Title"));
            alice.takeBook("Book Title");
        }
        
        assertNull(library.takeBook("Book Title"));
    }
    
    /**
     * Tests returning a book
     */
    @Test
    public void testReturnBook() {
        library.addBook("Book Title", "Book Author");
        Book book = library.takeBook("Book Title");
        library.returnBook(book);
        assertNotNull(library.takeBook("Book Title"));
    }
    
    
    /**
     * Tests getReaderCount
     */
    @Test
    public void testGetReaderCount() {
        library.getID("User 1");
        library.getID("User 1");
        library.getID("User 2");
        
        assertEquals(2, library.getReaderCount());
    }
    
    /**
     * Tests getBookCountCount
     */
    @Test
    public void testGetBookCount() {
        library.addBook("Title 1", "Author 1");
        library.addBook("Title 1", "Author 1");
        library.addBook("Title 2", "Author 2");
        
        assertEquals(3, library.getBookCount());
    }
    
    /**
     * Tests getBookBorrowedCount
     */
    @Test
    public void testGetBookBorrowedCount() {
        library.addBook("Title 1", "Author 1");
        library.addBook("Title 1", "Author 1");
        library.addBook("Title 2", "Author 2");
        assertEquals(0, library.getBookBorrowedCount());
        
        RegisterableUser alice = new RegisterableUserImpl("Alice");
        alice.register(library);
        
        alice.takeBook("Title 1");
        assertEquals(1, library.getBookBorrowedCount());
        
        alice.takeBook("Title 1");
        assertEquals(2, library.getBookBorrowedCount());
        
        alice.takeBook("Title 2");
        assertEquals(3, library.getBookBorrowedCount());
    }
    
    /**
     * Tests getBorrowingUsers
     */
    @Test
    public void testGetBorrowingUserNames() {
        library.addBook("Title", "Author");
        library.addBook("Title", "Author");
        
        Set<String> expected_users = new HashSet<String>();
        Set<String> got_users;
        
        RegisterableUser alice = new RegisterableUserImpl("Alice");
        alice.register(library);
        
        RegisterableUser bob = new RegisterableUserImpl("Bob");
        bob.register(library);
        
        RegisterableUser charlie = new RegisterableUserImpl("Charlie");
        charlie.register(library);
        
        assertTrue(library.getBorrowingUserNames().isEmpty());
        
        alice.takeBook("Title");
        expected_users.add("Alice");
        got_users = new HashSet<String>(library.getBorrowingUserNames());
        assertEquals(expected_users, got_users);
        
        bob.takeBook("Title");
        expected_users.add("Bob");
        got_users = new HashSet<String>(library.getBorrowingUserNames());
        assertEquals(expected_users, got_users);
        
        charlie.takeBook("Title");
        got_users = new HashSet<String>(library.getBorrowingUserNames());
        assertEquals(expected_users, got_users);
    }
    
    /**
     * Tests getAllUserNames
     */
    @Test
    public void testGetAllUserNames() {
        library.addBook("Title 1", "Author 1");
        library.addBook("Title 2", "Author 2");
        library.addBook("Title 3", "Author 3");
        
        Set<String> expected_users = new HashSet<String>();
        Set<String> got_users = new HashSet<String>(library.getAllUserNames());
        
        assertEquals(expected_users, got_users);
        
        RegisterableUser alice = new RegisterableUserImpl("Alice");
        alice.register(library);
        expected_users.add("Alice");
        got_users = new HashSet<String>(library.getAllUserNames());
        assertEquals(expected_users, got_users);
        
        RegisterableUser bob = new RegisterableUserImpl("Bob");
        bob.register(library);
        expected_users.add("Bob");
        got_users = new HashSet<String>(library.getAllUserNames());
        assertEquals(expected_users, got_users);
        
        RegisterableUser charlie = new RegisterableUserImpl("Charlie");
        charlie.register(library);
        expected_users.add("Charlie");
        got_users = new HashSet<String>(library.getAllUserNames());
        assertEquals(expected_users, got_users);
    }
    
    /**
     * Tests getUserNameBorrowingBook
     */
    @Test
    public void testGetUserNameBorrowingBook() {
        Book book = new BookImpl("Title 1", "Author 1");
        library.returnBook(book);
        
        RegisterableUser bob = new RegisterableUserImpl("Bob");
        bob.register(library);
        
        bob.takeBook("Title 1");
        assertEquals("Bob", library.getUserNameBorrowingBook(book));
    }
    
    
    /**
     * Tests getBooksBorrowedByUser
     */
    @Test
    public void testGetBooksBorrowedByUser() {
        library.addBook("Title 1", "Author 1");
        library.addBook("Title 2", "Author 2");
        library.addBook("Title 3", "Author 3");
        
        Set<String> expected_book_titles = new HashSet<String>();
        Set<String> got_book_titles = new HashSet<String>();
        
        RegisterableUser alice = new RegisterableUserImpl("Alice");
        alice.register(library);
        got_book_titles = booksToBookTitles(library.getBooksBorrowedByUser(alice));
        assertEquals(expected_book_titles, got_book_titles);
        
        alice.takeBook("Title 1");
        expected_book_titles.add("Title 1");
        got_book_titles = booksToBookTitles(library.getBooksBorrowedByUser(alice));
        assertEquals(expected_book_titles, got_book_titles);
        
        alice.takeBook("Title 2");
        expected_book_titles.add("Title 2");
        got_book_titles = booksToBookTitles(library.getBooksBorrowedByUser(alice));
        assertEquals(expected_book_titles, got_book_titles);
        
        alice.takeBook("Title 3");
        expected_book_titles.add("Title 3");
        got_book_titles = booksToBookTitles(library.getBooksBorrowedByUser(alice));
        assertEquals(expected_book_titles, got_book_titles);
    }
    
    /**
     * Tests setMaxBookPolicy
     */
    @Test
    public void testSetMaxBookPolicy() {
        library.addBook("Title 1", "Author 1");
        library.addBook("Title 2", "Author 2");
        
        Set<String> expected_users = new HashSet<String>();
        Set<String> got_users;
        
        RegisterableUser alice = new RegisterableUserImpl("Alice");
        alice.register(library);
        alice.takeBook("Title 1");
        alice.takeBook("Title 2");
        got_users = new HashSet<String>(library.setMaxBookPolicy(2));
        assertEquals(expected_users, got_users);
        
        expected_users.add("Alice");
        got_users = new HashSet<String>(library.setMaxBookPolicy(1));
        assertEquals(expected_users, got_users);
        
        got_users = new HashSet<String>(library.setMaxBookPolicy(0));
        assertEquals(expected_users, got_users);
    }
    
    private Set<String> booksToBookTitles(List<Book> book_lst) {
        Set<String> titles_lst = new HashSet<String>();
        
        for (Book book : book_lst) {
            titles_lst.add(book.getTitle());
        }
        
        return titles_lst;
    }
    
    @Test
    public void testMaxBookPolicy() {
        library.addBook("Title 1", "Author 1");
        library.addBook("Title 2", "Author 2");
        library.setMaxBookPolicy(1);
        
        RegisterableUser alice = new RegisterableUserImpl("Alice");
        alice.register(library);
        
        alice.takeBook("Title 1");
        assertEquals(1, alice.getTakenBookTitles().size());
        
        alice.takeBook("Title 2");
        assertEquals(1, alice.getTakenBookTitles().size());
        
        alice.returnBook("Title 1");
        assertEquals(0, alice.getTakenBookTitles().size());
        
        alice.takeBook("Title 2");
        assertEquals(1, alice.getTakenBookTitles().size());
        
    }
}
