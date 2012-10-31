/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

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
     * Test of getMaxBooksPerUser method, of class LibraryImpl.
     */
    @Test
    public void testGetMaxBooksPerUser() {
        System.out.println("getMaxBooksPerUser");
        assertTrue(library.getMaxBooksPerUser() >= 0);
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
        Book book = library.takeBook("Book Title");
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
        
        for (int i=0; i<3; ++i) {
            Book book = library.takeBook("Book Title");
            assertNotNull(book);
            assertEquals("Book Title", book.getTitle());
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
        
        library.takeBook("Title 1");
        assertEquals(1, library.getBookBorrowedCount());
        
        library.takeBook("Title 1");
        assertEquals(2, library.getBookBorrowedCount());
        
        library.takeBook("Title 2");
        assertEquals(3, library.getBookBorrowedCount());
    }
    
}
