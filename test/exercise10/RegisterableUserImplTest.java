/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class RegisterableUserImplTest {
    Library library;
    RegisterableUser user;
    
    @Before
    public void buildUp() {
        library = new LibraryImpl("Library name");
        user = new RegisterableUserImpl("UserName");
    }

    /**
     * Test of getID method, of class RegisterableUserImpl.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        user.register(library);
        assertEquals(user.getID(), library.getID(user.getName())); 
    }

    /**
     * Test of getLibrary method when no library is set
     * (of class RegisterableUserImpl).
     */
    @Test
    public void testGetEmptyLibrary() {
        System.out.println("getLibrary when no library is set");
        assertEquals(user.getLibrary(), "");
    }
    
    /**
     * Test of getLibrary method, of class RegisterableUserImpl.
     */
    @Test
    public void testGetLibrary() {
        System.out.println("getLibrary");
        user.register(library);
        assertEquals(user.getLibrary(), library.getName());
    }
    
    @Test
    public void testTakeBook() {
        user.register(library);
        library.addBook("Title1", "Author1");
        user.takeBook("Title1");
        
        assertEquals("Title1", user.getTakenBookTitles().get(0));
    }
    
    @Test
    public void testReturnBook() {
        user.register(library);
        library.addBook("Title1", "Author1");
        
        user.takeBook("Title1");
        assertEquals(1, user.getTakenBookTitles().size());
        
        user.returnBook("Title1");
        assertEquals(0, user.getTakenBookTitles().size());
    }
}
