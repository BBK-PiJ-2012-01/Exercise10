/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;


public class UserImpl implements User {
    private final String name;
    private int ID = -1;
    
    public UserImpl(String name) {
        this.name = name;
    }

    @Override
    public void setID(int ID) {
        if (ID < 0)
            this.ID = -1;
        else
            this.ID = ID;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

}
