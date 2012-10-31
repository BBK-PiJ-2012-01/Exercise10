/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;

import java.util.List;


public class RegisterableUserImpl extends UserImpl implements RegisterableUser {
    private Library library;

    public RegisterableUserImpl(String name) {
        super(name);
    }
    
    @Override
    public void register(Library library) {
        this.library = library;
        if (library != null)
            setID(library.getID(getName()));
    }

    @Override
    public String getLibrary() {
        if (this.library == null)
            return "";
        else
            return library.getName();
    }

    @Override
    public void takeBook(String title) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Book> getTakenBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
