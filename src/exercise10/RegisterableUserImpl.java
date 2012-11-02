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
        if (book != null && library.canUserTakeMoreBooks(this)) {
            book.setTakenBy(this);
        }
    }

    @Override
    public List<String> getTakenBookTitles() {
        List<String> book_titles = new ArrayList<String>();
        
        for (Book book : library.getBooksBorrowedByUser(this) ) {
            book_titles.add(book.getTitle());
        }
        return book_titles;
    }

    @Override
    public void returnBook(String title) {
        
        for (Book book : library.getBooksBorrowedByUser(this) ){
            if (book.getTitle().equals(title)) {
                book.setReturned();
                return;
            }
        }
    }

}
