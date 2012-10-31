/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;


public class MockLibraryImpl implements Library {

    @Override
    public String getName() {
        return "Mock library";
    }

    @Override
    public int getID() {
        return 13;
    }

}
