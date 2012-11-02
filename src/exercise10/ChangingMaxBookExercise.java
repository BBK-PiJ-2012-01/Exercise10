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
public class ChangingMaxBookExercise implements Exercise {

    @Override
    public String getTitle() {
        return "Changing max books per user";
    }

    @Override
    public String getDescription() {
        return "A user takes 2 books out, then the max books per user\n"
                + "is set to 1, then 0, then 2";
    }

    @Override
    public void run() {
        Library library = new LibraryImpl("Library");
        library.setMaxBookPolicy(2);
        
        RegisterableUser user = new RegisterableUserImpl("Bob");
        user.register(library);
        
        library.addBook("Title1", "Author1");
        library.addBook("Title2", "Author2");
        
        user.takeBook("Title1");
        user.takeBook("Title2");
        System.out.format("User took book: [\'Title1\', \'Title2\']\n\n");
        
        System.out.format("Set max books per user as 1.  Now these users are in violation: [");
        for (String violating_user : library.setMaxBookPolicy(1)) {
            System.out.format("\'%s\', ", violating_user);
        }
        System.out.format("]\n\n");
        
        System.out.format("Set max books per user as 0.  Now these users are in violation: [");
        for (String violating_user : library.setMaxBookPolicy(0)) {
            System.out.format("\'%s\', ", violating_user);
        }
        System.out.format("]\n\n");
        
        System.out.format("Set max books per user as 3.  Now these users are in violation: [");
        for (String violating_user : library.setMaxBookPolicy(3)) {
            System.out.format("\'%s\', ", violating_user);
        }
        System.out.format("]\n\n");
        
    }

}
