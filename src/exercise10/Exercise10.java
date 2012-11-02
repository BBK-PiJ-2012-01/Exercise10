/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

import BBK.PiJ01.common.BadInput;
import BBK.PiJ01.common.Exercise;
import BBK.PiJ01.common.ExerciseChooser;
import java.util.ArrayList;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class Exercise10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BadInput {
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        
        exercises.add(new BorrowBookExercise());
        exercises.add(new GreedyUserExercise());
        exercises.add(new WhoBorrowedExercise());
        exercises.add(new ChangingMaxBookExercise());
        
        ExerciseChooser ech = new ExerciseChooser(exercises);
        ech.run();
    }
}
