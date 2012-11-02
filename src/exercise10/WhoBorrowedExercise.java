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
public class WhoBorrowedExercise implements Exercise {

    @Override
    public String getTitle() {
        return "Who borrowed this book?";
    }

    @Override
    public String getDescription() {
        return "Demonstrates finding the user(s) who borrowed certain titles";
    }

    @Override
    public void run() {
        Library library = new LibraryImpl("Library");
        library.setMaxBookPolicy(2);
        
        RegisterableUser alice = new RegisterableUserImpl("Alice");
        alice.register(library);
        
        RegisterableUser bob = new RegisterableUserImpl("Bob");
        bob.register(library);
        
        RegisterableUser charlie = new RegisterableUserImpl("Charlie");
        charlie.register(library);
        
        library.addBook("Title1", "Author1");
        library.addBook("Title1", "Author2");
        library.addBook("Title2", "Author3");
        
        alice.takeBook("Title1");
        bob.takeBook("Title1");    // Two books of the same title 'Title1'
        charlie.takeBook("Title2");
        
        System.out.format("Users who took \'Title1\': [");
        for (String title : library.getBorrowersOfTitle("Title1")) {
            System.out.format("\'%s\', ", title);
        }
        System.out.format("]\n\n");
        
        System.out.format("Users who took \'Title2\': [");
        for (String title : library.getBorrowersOfTitle("Title2")) {
            System.out.format("\'%s\', ", title);
        }
        System.out.format("]\n");
        
    }

}
