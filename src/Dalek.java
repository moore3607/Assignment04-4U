/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moore3607
 */
public class Dalek {
    //instance variables
    private int row;
    private int col;
    public boolean crash;
    
    /**
     * a constructor to create new daleks
     * @param row the row the dalek is on
     * @param col the column the dalek is on
     */
    public Dalek(int row, int col){
        //initializing instance variables
        this.row = row;
        this.col = col;
    }
    
    //class methods
    /**
     * moves the dalek towards the Doctor via the fastest route
     * @param doc the doctor
     */
    public void advanceTowards(Doctor doc){
        int docRow = doc.getRow();
        if(docRow < this.row){
            this.row--;
        }
        int docRow2 = doc.getRow();
        if(docRow2 > this.row){
            this.row++;
        }
        int docCol = doc.getCol();
        if(docCol < this.col){
            this.col--;
        }
        int docCol2 = doc.getCol();
        if(docCol2 > this.col){
            this.col++;
        }
    
  }
    /**
     * returns true if daleks have collided
     * @param d1 another dalek
     * @return true if daleks have collided and false if they have not
     */
    public boolean hit(Dalek d1){
        //checks to see if daleks have crashed
        if(d1.getRow() == this.row && d1.getCol() == this.col){
            crash = true;
            return true;
        }else{
            crash = false;
            return false;
        }
    }
    /**
     * returns the row the dalek is on
     * @return the row the dalek is on
     */
    public int getRow() {
        return this.row;
    }
    /**
     * returns the column the dalek is on
     * @return the column the dalek is on
     */
    public int getCol() {
        return this.col;
    }
    /**
     * returns true if the dalek has crashed and vice versa
     * @return true if the dalek has crashed and vice versa
     */
    public boolean hasCrashed(){
        return crash;
    }
    /**
     * makes crash true
     */
    public void crash(){
        crash = true;
           
    }
}
