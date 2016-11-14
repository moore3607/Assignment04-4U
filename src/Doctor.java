
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author moore3607
 */
public class Doctor {
// instance variables
    private int row;
    private int col;

    public Doctor(int row, int col) {
        //initializing instance variables
        this.row = row;
        this.col = col;
    }
/**
 * makes the doctor move to wherever the click was or to a random location if the click was not nearby
 * @param newRow the row the doctor is now on
 * @param newCol the column the doctor is now on
 */
    public void move(int newRow, int newCol) {
        if(row == newRow && col == newCol){
            this.row = row;
            this.col = col;
        }
        if (row == newRow || row == (newRow - 1) || row == (newRow + 1)) {
            if (col == newCol || col == (newCol - 1) || col == (newCol + 1)) {
                col = newCol;
                row = newRow;
            } else {
                row = (int) (Math.random() * 12);
                col = (int) (Math.random() * 12);


            }
        } else {
            row = (int) (Math.random() * 12);
            col = (int) (Math.random() * 12);
        }
    }
/**
 * returns the row the doctor is on
 * @return the row the doctor is on
 */
    public int getRow() {
        return this.row;
    }
/**
 * returns the column the doctor is on
 * @return the column the doctor is on
 */
    public int getCol() {
        return this.col;
    }
}
