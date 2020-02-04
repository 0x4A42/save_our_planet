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
		setUpPlayers(currentPlayers);
		setUpBoard(gameBoard);

	} // end of main

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
			player.setBoardPosition(0);
			// add to ArrayList
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
		case "TREE":
			validPiece = true;
			break;
		default:
			validPiece = false;
		}

		return validPiece;
	} // end of checkValidPlayerPiece

	/**
	 * This method will create the board by creating individual Board Square
	 * objects, adding them to an ArrayList and then returning this ArrayList to the
	 * calling method Field one will be based around biomass, Field Two will be
	 * based around Hydroelectricity, Field Three will be based around Solar energy
	 * and Field Four will be based around Wind energy
	 * 
	 * 
	 * @return the populated gameBoard ArrayList
	 */
	public static ArrayList<BoardSquare> setUpBoard(ArrayList<BoardSquare> gameBoard) {
		// create 'special' board squares
		BoardSquare startSquare = new BoardSquare("Start Square", 0);
		BoardSquare blankSquare = new BoardSquare("Carbon Neutral Square", 10);
		// create property squares for field one area one
		Property f1a1p1 = new Property("Ironbridge", 1, 60, "Oak", false, false, false, false, "Bank");
		Property f1a1p2 = new Property("Polaniec", 2, 60, "Oak", false, false, false, false, "Bank");
		Property f1a1p3 = new Property("Alholmens Kraft", 3, 60, "Oak", false, false, false, false, "Bank");
		// create property squares for field one area two
		Property f1a2p1 = new Property("Kymijärvi II", 4, 90, "Pine", false, false, false, false, "Bank");
		Property f1a2p2 = new Property("Wisapower", 5, 90, "Pine", false, false, false, false, "Bank");
		Property f1a2p3 = new Property("Vaasa Bio Plant", 6, 90, "Pine", false, false, false, false, "Bank");
		// create property squares for field one area three
		Property f1a3p1 = new Property("New Hope", 7, 120, "Cedar", false, false, false, false, "Bank");
		Property f1a3p2 = new Property("Kaukaan Voima", 8, 120, "Cedar", false, false, false, false, "Bank");
		Property f1a3p3 = new Property("Seinäjoki", 9, 120, "Cedar", false, false, false, false, "Bank");
		// create property squares for field two area one
		Property f2a1p1 = new Property("Nurek Dam", 11, 150, "Sky Blue", false, false, false, false, "Bank");
		Property f2a1p2 = new Property("Three Gorges Dam", 12, 150, "Sky Blue", false, false, false, false, "Bank");
		Property f2a1p3 = new Property("Itaipu Dam", 13, 150, "Sky Blue", false, false, false, false, "Bank");
		Property f2a1p4 = new Property("Longtan Dam", 14, 150, "Sky Blue", false, false, false, false, "Bank");
		// create property squares for field two area two
		Property f2a2p1 = new Property("Xiangjiaba", 15, 180, "Cerulean", false, false, false, false, "Bank");
		Property f2a2p2 = new Property("Guri", 16, 180, "Cerulean", false, false, false, false, "Bank");
		Property f2a2p3 = new Property("Xiluodu", 17, 180, "Cerulean", false, false, false, false, "Bank");
		Property f2a2p4 = new Property("Krasnoyarsk", 18, 180, "Cerulean", false, false, false, false, "Bank");
		Property f2a2p5 = new Property("Robert-Bourassa", 19, 180, "Cerulean", false, false, false, false, "Bank");
		// create property squares for field three area one
		Property f3a1p1 = new Property("Solar Star", 20, 210, "Lemon", false, false, false, false, "Bank");
		Property f3a1p2 = new Property("Desert Sunlight", 21, 210, "Lemon", false, false, false, false, "Bank");
		Property f3a1p3 = new Property("Topaz", 22, 210, "Lemon", false, false, false, false, "Bank");
		// create property squares for field three area two
		Property f3a2p1 = new Property("Longyangxia", 23, 240, "Honey", false, false, false, false, "Bank");
		Property f3a2p2 = new Property("Copper Mountain", 24, 240, "Honey", false, false, false, false, "Bank");
		Property f3a2p3 = new Property("NP Kunta", 25, 240, "Honey", false, false, false, false, "Bank");
		// create property squares for field three area three
		Property f3a3p1 = new Property("Rewa Ultra Mega", 26, 270, "Dandelion", false, false, false, false, "Bank");
		Property f3a3p2 = new Property("Mula Photovoltaic", 27, 270, "Dandelion", false, false, false, false, "Bank");
		Property f3a3p3 = new Property("Mount Signal", 28, 270, "Dandelion", false, false, false, false, "Bank");
		// create property squares for field four area one
		Property f4a1p1 = new Property("Walney", 29, 300, "Graphite", false, false, false, false, "Bank");
		Property f4a1p2 = new Property("Fantanele-Cogealac", 30, 300, "Graphite", false, false, false, false, "Bank");
		Property f4a1p3 = new Property("Gemini", 31, 300, "Graphite", false, false, false, false, "Bank");
		Property f4a1p4 = new Property("Beatrice", 32, 300, "Graphite", false, false, false, false, "Bank");
		Property f4a1p5 = new Property("Whitelee", 32, 300, "Graphite", false, false, false, false, "Bank");
		// create property squares for field four area two
		Property f4a2p1 = new Property("Gode Wind 1", 33, 330, "Pewter", false, false, false, false, "Bank");
		Property f4a2p2 = new Property("Gode Wind 2", 34, 330, "Pewter", false, false, false, false, "Bank");
		Property f4a2p3 = new Property("Gwynt y Môr", 35, 330, "Pewter", false, false, false, false, "Bank");
		Property f4a2p4 = new Property("Race Bank", 36, 330, "Pewter", false, false, false, false, "Bank");
		// add board squares to the ArrayList
		gameBoard.add(startSquare);
		gameBoard.add(f1a1p1);
		gameBoard.add(f1a1p2);
		gameBoard.add(f1a1p3);
		gameBoard.add(f1a2p1);
		gameBoard.add(f1a2p2);
		gameBoard.add(f1a2p3);
		gameBoard.add(f1a3p1);
		gameBoard.add(f1a3p2);
		gameBoard.add(f1a3p3);
		gameBoard.add(blankSquare);
		gameBoard.add(f2a1p1);
		gameBoard.add(f2a1p2);
		gameBoard.add(f2a1p3);
		gameBoard.add(f2a1p4);
		gameBoard.add(f2a2p1);
		gameBoard.add(f2a2p2);
		gameBoard.add(f2a2p3);
		gameBoard.add(f2a2p4);
		gameBoard.add(f2a2p5);
		gameBoard.add(f3a1p1);
		gameBoard.add(f3a1p2);
		gameBoard.add(f3a1p3);
		gameBoard.add(f3a2p1);
		gameBoard.add(f3a2p2);
		gameBoard.add(f3a2p3);
		gameBoard.add(f3a3p1);
		gameBoard.add(f3a3p2);
		gameBoard.add(f3a3p3);
		gameBoard.add(f4a1p1);
		gameBoard.add(f4a1p2);
		gameBoard.add(f4a1p3);
		gameBoard.add(f4a1p4);
		gameBoard.add(f4a1p5);
		gameBoard.add(f4a2p1);
		gameBoard.add(f4a2p2);
		gameBoard.add(f4a2p3);
		gameBoard.add(f4a2p4);

		// return populated gameboard to the calling method
		return gameBoard;
	} // end of setUpBoard

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
