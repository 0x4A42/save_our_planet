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
		// structures to hold board objects
		ArrayList<PlayerPiece> currentPlayers = new ArrayList<PlayerPiece>();
		ArrayList<BoardSquare> gameBoard = new ArrayList<BoardSquare>();
		ArrayList<Die> dice = new ArrayList<Die>();

		// Invoke methods to set up the game
		setUpDice(dice);
		setUpBoard(gameBoard);
		setUpPlayers(currentPlayers);

	} // end of main



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
		boolean validEntryNumberOfPlayers = false;
		boolean validEntryPlayerPiece = false;
		String playerName;
		String playerCharacter;
		// prompt the user
		while (validEntryNumberOfPlayers != true) {
			System.out.println("Please enter the amount of Eco Warriors playing!");
			amountOfPlayers = playerScanner.nextInt();
			if (amountOfPlayers >= 1 && amountOfPlayers <= 4) {
				validEntryNumberOfPlayers = true;
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
			while (validEntryPlayerPiece != true) {
				System.out.println(
						"Please enter the Eco Warrior's character piece (Please refer to manual for valid pieces).");
				playerCharacter = playerCharacterScanner.nextLine();

				if (checkValidPlayerPiece(playerCharacter) == true) {
					player.setCharacter(playerCharacter);
					validEntryPlayerPiece = true;
				} // end of if
			} // end of while
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

	/**
	 * This method will create (by default) two die objects to be used within the
	 * game to simulate board dice. More can be added by creating additional objects
	 * and adding them to the ArrayList
	 * 
	 * @param dice, an ArrayList that will hold the die objects
	 * @return the populated ArrayList
	 */
	public static ArrayList<Die> setUpDice(ArrayList<Die> dice) {
		// create die objects
		Die die1 = new Die();
		Die die2 = new Die();
		// add to ArrayList
		dice.add(die1);
		dice.add(die2);
		// return populated ArrayList
		return dice;
	}

	/**
	 * This method will check if a requested player piece is valid to set (checking
	 * for those values stated in the business rule of the setter). If valid, passes
	 * a true Boolean back to the calling method which will allow the player
	 * creation to continue. If false, the player will be prompted for another
	 * input.
	 * 
	 * @param playerPiece
	 * @return
	 */
	public static boolean checkValidPlayerPiece(String playerPiece) {
		boolean validPiece = false;

		switch (playerPiece.toUpperCase()) {
		case "FISH":
		case "LEAF":
		case "TURTLE":
		case "PENGUIN":
		case "BICYCLE":
			validPiece = true;
			break;
		default:
			validPiece = false;
		}

		return validPiece;
	} // end of checkValidPlayerPiece
	
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
