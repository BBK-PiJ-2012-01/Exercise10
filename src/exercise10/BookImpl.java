/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;


public class BookImpl implements Book {
    private final String author, title;
    private boolean taken;
    
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
    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    @Override
    public boolean isTaken() {
        return taken;
    }

}
