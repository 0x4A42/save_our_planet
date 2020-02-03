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
	 * This method will be responsible for the running of the game. It will call
	 * methods which will set up the game by creating the board, prompting the user
	 * for player names and will then begin the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// holds players
		ArrayList<PlayerPiece> currentPlayers = new ArrayList<PlayerPiece>();
		ArrayList<BoardSquare> gameBoard = new ArrayList<BoardSquare>();

		Die die1 = new Die();
		Die die2 = new Die();
		// a structure to hold the die objects within
		ArrayList<Die> dice = new ArrayList<Die>();
		dice.add(die1);
		dice.add(die2);
		// test rolling dice
		rollDice(dice);

		// Set up game
		setUpBoard(gameBoard);
		setUpPlayers(currentPlayers);

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

	/**
	 * This method will create the board by creating individual Board Square
	 * objects, adding them to an ArrayList and then returning this ArrayList to the
	 * calling method
	 * 
	 * @return the populated gameBoard ArrayList
	 */
	public static ArrayList<BoardSquare> setUpBoard(ArrayList<BoardSquare> gameBoard) {
		// create board squares for field one area one

		// create board squares for field one area two

		// create board squares for field one area three

		// create board squares for field two area one

		// create board squares for field two area two

		// create board squares for field three area one

		// create board squares for field three area two

		// create board squares for field three area three

		// create board squares for field four area one

		// create board squares for field four area two

		// add board squares to the ArrayList

		// return populated gameboard to the setUpGame method
		return gameBoard;
	} // end of setUpBoard

	/**
	 * This method will create an ArrayList that holds the players within a current
	 * game (up to a max of 4). Depending on the user's input, they will then be
	 * prompted X times to enter player names and character pieces.
	 * 
	 * @return the ArrayList of players.
	 */
	public static ArrayList<PlayerPiece> setUpPlayers(ArrayList<PlayerPiece> currentPlayers) {
		// Scanner to capture user input
		Scanner playerScanner = new Scanner(System.in);
		Scanner playerNameScanner = new Scanner(System.in);
		Scanner playerCharacterScanner = new Scanner(System.in);
		// variables
		int amountOfPlayers = 0;
		boolean validEntry = false;
		String playerName;
		String playerCharacter;
		// prompt the user
		while (validEntry != true) {
			System.out.println("Please enter the amount of Eco Warriors playing!");
			amountOfPlayers = playerScanner.nextInt();
			if (amountOfPlayers >= 1 && amountOfPlayers <= 4) {
				validEntry = true;
			} else {
				System.err.println("Sorry, please enter a number of players between 1 - 4.");
			}
		}

		// create Player Object
		PlayerPiece player = new PlayerPiece();
		// set up player pieces
		for (int loop = 0; loop < amountOfPlayers; loop++) {
			System.out.println("Please enter the Eco Warrior's name.");
			playerName = playerNameScanner.nextLine();
			player.setPlayerName(playerName);
			System.out.println(
					"Please enter the Eco Warrior's character piece (Please refer to manual for valid pieces).");
			playerCharacter = playerCharacterScanner.nextLine();
			player.setCharacter(playerCharacter);
			player.setMoney(200);
			// add to array
			currentPlayers.add(player);
		} // end of for loop

		// tidy resources
		playerScanner.close();
		playerNameScanner.close();
		playerCharacterScanner.close();
		// return the ArrayList to the calling method
		return currentPlayers;
	}

} // end of class
