/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;

import java.util.HashMap;
import java.util.Map;


public class LibraryImpl implements Library {
    private final String name;
    private int max_bpu;
    private Map<String, Integer> user_ID = new HashMap<String, Integer>();

    public LibraryImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID(String name) {
        
    }

    @Override
    public int getMaxBooksPerUser() {
        return max_bpu;
    }

}
