/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class BookImplTest {
    private BookImpl instance;
    private String expected_author = "Author Test";
    private String expected_title = "Title Test";
    
    @Before
    public void buildUp() {
        instance = new BookImpl(expected_title, expected_author);
    }

    /**
     * Test of getAuthor method, of class BookImpl.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        assertEquals(expected_author, instance.getAuthor());
    }

    /**
     * Test of getTitle method, of class BookImpl.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        assertEquals(expected_title, instance.getTitle());
    }
    
    /**
     * Tests that the default status of taken is false
     */
    @Test
    public void testDefaultTaken() {
        assertFalse(instance.isTaken());
    }
    
    /**
     * Tests setTaken and isTaken
     */
    @Test
    public void testSetTaken() {
        instance.setTaken(true);
        assertTrue(instance.isTaken());
        instance.setTaken(false);
        assertFalse(instance.isTaken());
    }
}
