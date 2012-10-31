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
public class RegisterableUserImplTest {
    Library library;
    RegisterableUser user;
    
    @Before
    public void buildUp() {
        library = new MockLibraryImpl();
        user = new RegisterableUserImpl("UserName");
    }

    /**
     * Test of getID method, of class RegisterableUserImpl.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        user.register(library);
        assertEquals(user.getID(), library.getID()); 
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
}
