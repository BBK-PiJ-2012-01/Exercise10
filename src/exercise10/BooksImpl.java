/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;


public class BooksImpl implements Books {
    private final String author, title;
    
    public BooksImpl(String author, String title) {
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

}
