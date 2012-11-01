/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RegisterableUserImpl extends UserImpl implements RegisterableUser {
    private Library library;
    
    public RegisterableUserImpl(String name) {
        super(name);
    }
    
    @Override
    public void register(Library library) {
        this.library = library;
        if (library != null) {
            setID(library.getID(getName()));
        }
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
        Book book = library.takeBook(title);
        if (book != null) {
            book.setTakenBy(this);
        }
    }

    @Override
    public List<String> getTakenBooks() {
        return library.getBooksBorrowedByUser(this);
    }

    

}
