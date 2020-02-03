/**
 * 
 */
package save.our.planet.game;

import java.util.*;


/**
 * This class will represent the board game for the Save Our Planet project. The
 * board game will be created and played within this class.
 * 
 * @author Jordan
 *
 */
public class BoardGame {

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		Die die1 = new Die();
		Die die2 = new Die();
		// a structure to hold the die objects within
		ArrayList<Die> dice = new ArrayList<Die>();
		dice.add(die1);
		dice.add(die2);
		// test rolling dice
		rollDice(dice);
		
	} // end of main

	/**
	 * This method will simulate the roll of two die. The Random object will roll
	 * each die's number between 1-6 (inclusive) and display it to the user.
	 * 
	 * @param dice, an ArrayList of Die objects.
	 */
	public static void rollDice(ArrayList<Die> dice) {
		Random diceRoll = new Random();
		int roll;
		for (Die d : dice) {
			roll = diceRoll.nextInt(6) + 1;
			d.setRollCount(roll);
			System.out.println("Roll for die: " + d.getRollCount());
		} // end of enhancedFor

	} // end of rollDice

} // end of class
