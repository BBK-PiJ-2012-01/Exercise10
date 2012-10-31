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
public class BooksImplTest {
    private BooksImpl instance;
    private String expected_author = "Author Test";
    private String expected_title = "Title Test";
    
    @Before
    public void buildUp() {
        instance = new BooksImpl(expected_author, expected_title);
    }

    /**
     * Test of getAuthor method, of class BooksImpl.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        assertEquals(expected_author, instance.getAuthor());
    }

    /**
     * Test of getTitle method, of class BooksImpl.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        assertEquals(expected_title, instance.getTitle());
    }
}
