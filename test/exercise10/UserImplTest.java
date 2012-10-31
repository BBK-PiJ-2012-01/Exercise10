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
public class UserImplTest {
    User instance;
    String expected_name = "Bob";
    
    @Before
    public void buildUp() {
        instance = new UserImpl(expected_name);
    }

    @Test
    public void testDefaultID() {
        System.out.println("Default ID is -1");
        assertEquals(-1, instance.getID());
    }
    
    @Test
    public void testBadID() {
        System.out.println("Setting bad ID returns to default");
        instance.setID(-4);
        assertEquals(-1, instance.getID());
    }
    
    @Test
    public void testSetGetID() {
        System.out.println("setID, getID");
        instance.setID(50);
        assertEquals(50, instance.getID());
    }
}
