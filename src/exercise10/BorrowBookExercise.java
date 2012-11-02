/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;

import BBK.PiJ01.common.Exercise;
import java.util.List;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class BorrowBookExercise implements Exercise {

    @Override
    public String getTitle() {
        return "Book borrowing and returning.";
    }

    @Override
    public String getDescription() {
        return "A user borrows one book then returns it";
    }

    @Override
    public void run() {
        Library library = new LibraryImpl("Library");
        library.addBook("Principia Mathematica", "Newton");
        
        RegisterableUser user = new RegisterableUserImpl("Bob");
        user.register(library);
        user.takeBook("Principia Mathematica");
        
        System.out.format("User \'%s\' has taken out books: [", user.getName());
        
        for (String title : user.getTakenBookTitles()) {
            System.out.format("\'%s\', ", title);
        }
        
        System.out.format("]\nNow Bob returned his book... the books he has is now: [");
        user.returnBook("Principia Mathematica");
        
        for (String title : user.getTakenBookTitles()) {
            System.out.format("\'%s\', ", title);
        }
        
        System.out.format("]\n");
    }

}
