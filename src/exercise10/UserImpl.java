/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;


public class UserImpl implements User {
    private final String name;
    private int libraryID = -1;
    
    public UserImpl(String name) {
        this.name = name;
    }

    @Override
    public void setID(int ID) {
        if (ID < 0)
            this.libraryID = -1;
        else
            this.libraryID = ID;
    }

    @Override
    public int getID() {
        return libraryID;
    }

    @Override
    public String getName() {
        return name;
    }

}
