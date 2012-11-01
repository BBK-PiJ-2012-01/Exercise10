/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;


public class BookImpl implements Book {
    private final String author, title;
    private User user;
    
    public BookImpl(String title, String author) {
        this.author = author;
        this.title = title;
    }   

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }


    @Override
    public boolean isTaken() {
        return user != null;
    }

    @Override
    public void setTakenBy(User user) {
        this.user = user;
    }

    @Override
    public void setReturned() {
        user = null;
    }

    @Override
    public User getTakenBy() {
        return user;
    }

}
