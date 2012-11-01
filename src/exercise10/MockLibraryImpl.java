/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exercise10;

import java.util.List;
import java.util.Set;


public class MockLibraryImpl implements Library {

    @Override
    public String getName() {
        return "Mock library";
    }

    @Override
    public int getID(String str) {
        return 13;
    }

    @Override
    public int getMaxBooksPerUser() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addBook(String title, String author) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Book takeBook(String title) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void returnBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getReaderCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getBookCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getBookBorrowedCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<String> getBorrowingUserNames() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<String> getAllUserNames() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getUserNameBorrowingBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
