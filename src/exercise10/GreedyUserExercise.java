/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;

import BBK.PiJ01.common.Exercise;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class GreedyUserExercise implements Exercise {

    @Override
    public String getTitle() {
        return "Greedy user";
    }

    @Override
    public String getDescription() {
        return "A user takes too many books, then returns one\n"
                + "in order to take another.";
    }

    @Override
    public void run() {
        Library library = new LibraryImpl("Library");
        library.setMaxBookPolicy(2);
        
        RegisterableUser user = new RegisterableUserImpl("Bob");
        user.register(library);
        
        System.out.format("User tried to take books: [\'Title1\', \'Title2\', \'Title3\']\n\n");
        
        library.addBook("Title1", "Author1");
        library.addBook("Title2", "Author2");
        library.addBook("Title3", "Author3");
        
        user.takeBook("Title1");
        user.takeBook("Title2");
        user.takeBook("Title3");
        
        System.out.format("User has books: [");
        for (String title : user.getTakenBookTitles()) {
            System.out.format("\'%s\', ", title);
        }
        System.out.format("]\n\nNow remove \'Title2\' and take \'Title3\', \nand has: [");
        
        user.returnBook("Title2");
        user.takeBook("Title3");
        
        for (String title : user.getTakenBookTitles()) {
            System.out.format("\'%s\', ", title);
        }
        System.out.format("]\n");
    }

}
