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
        String name = "";
        LibraryImpl instance = null;
        int expResult = 0;
        int result = instance.getID(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxBooksPerUser method, of class LibraryImpl.
     */
    @Test
    public void testGetMaxBooksPerUser() {
        System.out.println("getMaxBooksPerUser");
        assertTrue(library.getMaxBooksPerUser() >= 0);
    }
}
