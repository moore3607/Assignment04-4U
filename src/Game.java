
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author moore3607
 */
public class Game {
//provides a random number whenever called upon
    public static int randNum() {
        return (int) (Math.random() * 12);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create the game board
        Board board = new Board(12, 12);
        //creating doctor and daleks and starting them in random locations
        Doctor doc = new Doctor(randNum(), randNum());
        Dalek d1 = new Dalek(randNum(), randNum());
        Dalek d2 = new Dalek(randNum(), randNum());
        Dalek d3 = new Dalek(randNum(), randNum());
        //ensures the doctor and daleks never spawn in the same location
        while (doc.getRow() == d1.getRow() && doc.getCol() == d1.getCol()
                || doc.getRow() == d2.getRow() && doc.getCol() == d2.getCol()
                || doc.getRow() == d3.getRow() && doc.getCol() == d3.getCol()) {
            doc.move(randNum(), randNum());
        }
        while (d1.hasCrashed() == true || d2.hasCrashed() == true || d3.hasCrashed()) {
            d1 = new Dalek(randNum(), randNum());
            d2 = new Dalek(randNum(), randNum());
            d3 = new Dalek(randNum(), randNum());
        }

//places pegs at the starter locations of the doctor and the daleks
        board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());
        board.putPeg(Color.BLACK, d1.getRow(), d1.getCol());
        board.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
        board.putPeg(Color.BLACK, d3.getRow(), d3.getCol());

        // put a message on the board
        board.displayMessage("Please click the board.");





        while (true) {
            //gets the coordinates of the click on the board
            Coordinate click = board.getClick();
            //removes the current pegs in preperation for places new ones
            board.removePeg(doc.getRow(), doc.getCol());
            board.removePeg(d1.getRow(), d1.getCol());
            board.removePeg(d2.getRow(), d2.getCol());
            board.removePeg(d3.getRow(), d3.getCol());
            int row = click.getRow();
            int col = click.getCol();
            //moves the doctor accordingly and places a peg on his new position
            doc.move(row, col);
            board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());
            //checks to see if the daleks have crashed and if they havent, 
            //moves them towards the doctor
            if (d1.hasCrashed() == false) {
                d1.advanceTowards(doc);
            }
            if (d2.hasCrashed() == false) {
                d2.advanceTowards(doc);
            }
            if (d3.hasCrashed() == false) {
                d3.advanceTowards(doc);
            }
            
            //checks to see if daleks have crashed and if they have, places a 
            //red peg on the crash location. If they havent, places a black peg
            //on the new dalek location
            if (d1.hit(d2) || d1.hit(d3)) {
                board.putPeg(Color.RED, d1.getRow(), d1.getCol());
            } else {
                board.putPeg(Color.BLACK, d1.getRow(), d1.getCol());
            }

            if (d2.hit(d1) || d2.hit(d3)) {
                board.putPeg(Color.RED, d2.getRow(), d2.getCol());
            } else {
                board.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
            }
            if (d3.hit(d1) || d3.hit(d2)) {
                board.putPeg(Color.RED, d3.getRow(), d3.getCol());
            } else {
                board.putPeg(Color.BLACK, d3.getRow(), d3.getCol());
            }
            //checks to see if all daleks have crashed and if they have, 
            //displays a message to the screen
            if (d1.hasCrashed() == true && d2.hasCrashed() == true && d3.hasCrashed() == true) {
                board.displayMessage("You Win! The Daleks have been defeated!");
                break;
            }
            //checks to see if a dalek is on the same square as the doctor and 
            //if one is, displayes a...different message to the screen
            if (d1.getRow() == doc.getRow() && d1.getCol() == doc.getCol()) {
                board.displayMessage("You Lose! The Daleks have captured The Doctor!");
                board.removePeg(doc.getRow(), doc.getCol());
                board.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                break;
            }

            if (d2.getRow() == doc.getRow() && d2.getCol() == doc.getCol()) {
                board.displayMessage("You Lose! The Daleks have captured The Doctor!");
                board.removePeg(doc.getRow(), doc.getCol());
                board.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                break;
            }

            if (d3.getRow() == doc.getRow() && d3.getCol() == doc.getCol()) {
                board.displayMessage("You Lose! The Daleks have captured The Doctor!");
                board.removePeg(doc.getRow(), doc.getCol());
                board.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                break;
            }




        }
    }
}
