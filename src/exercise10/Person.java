/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() { // Missed a '{'

        return this.name;
    }

    public void setName(String name) {
        //this.name = name; // Can't modify a final variable
    }
}