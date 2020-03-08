package game.files;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CSC7053-1920-G2: Jordan Brown (40282125), Ricards Estemirovs (40126945),
 * Rebekah Logan (40059637), Catherine McGuckin (40105486)
 * 
 * This class sets up the state of the board for the game, including the player
 * objects based on an input by the user.
 * 
 * @author v1.0 Jordan
 * @author v2.0 - 2.2 Bekah, Catherine, Ricards (Refactored code, fixed issue
 *         with scanners)
 * @author v2.3 - Jordan (updating of documentation)
 * @author v4.4 Jordan (ensure all instances of messages to user uses constant
 *         values where applicable, to ensure easy maintainability of code)
 * @Author v4.5 Ricards (Applied a parseInt fix to player create to prevent game
 *         crash upon a string input)
 */

public class BoardSetUp {

	private static final int LOWER_PLAYER_LIMIT = 2;
	private static final int UPPER_PLAYER_LIMIT = 4;
	private static final int STARTING_MONEY = 125;

	/**
	 * 
	 * Sets up the number of players playing the game
	 *
	 * @param currentPlayers
	 * @param input
	 * @return an int that specifies the amount of players within the game
	 */
	public static int setUpPlayers(Scanner input) {

		String amountOfPlayerString = null;
		int amountOfPlayers = 0;

		boolean validEntryNumberOfPlayers = false;

		// prompt the user
		while (validEntryNumberOfPlayers != true) {

			System.out.println("Please enter the number of Eco Warriors (" + LOWER_PLAYER_LIMIT + " - "
					+ UPPER_PLAYER_LIMIT + ") playing.");

			boolean stringIsInt = false;

			// Checks if input is a valid integer
			while (!stringIsInt) {

				try {
					amountOfPlayerString = input.nextLine();

					int temp = Integer.parseInt(amountOfPlayerString);
					amountOfPlayers = temp;
					stringIsInt = true;

				} catch (NumberFormatException e) {
					System.err.println("Not a valid number, please try again!");
				}

			}

			// input.nextLine();
			// input.reset();

			if (Integer.parseInt(amountOfPlayerString) >= LOWER_PLAYER_LIMIT
					&& Integer.parseInt(amountOfPlayerString) <= UPPER_PLAYER_LIMIT) {
				validEntryNumberOfPlayers = true;
			} else {
				System.err.println("Sorry, please enter a valid number of players (" + LOWER_PLAYER_LIMIT + " - "
						+ UPPER_PLAYER_LIMIT + ").");
			}

			amountOfPlayers = Integer.parseInt(amountOfPlayerString);
		}

		return amountOfPlayers;
	}

	/**
	 * /** Creates player objects and puts them into an array
	 * 
	 * @param input,           a scanner which will set the player's name from their
	 *                         input
	 * @param amountOfPlayers, the amount of players within the game to ensure that
	 *                         the relevant amount of player objects are created
	 * @param arrayPlayer,     an ArrayList containing all players.
	 * @return arrayPlayer, an ArrayList containing all players for this game.
	 */
	public static ArrayList<Player> createPlayer(Scanner input, int amountOfPlayers, ArrayList<Player> arrayPlayer) {

		for (int loop = 0; loop < amountOfPlayers; loop++) {

			// System.out.println("Please enter the Eco Warrior's name.");
			System.out.println("Please enter player name.");
			Player player = new Player();
			String playerName = input.nextLine();
			input.reset();
			player.setPlayerName(playerName);
			player.setPlayerId(loop + 1);
			player.setMoney(STARTING_MONEY);
			player.setBoardPosition(0);

			arrayPlayer.add(player);
		}

		return arrayPlayer;
	}

	/**
	 * Sets up the game board by creating all relevant squares anr property and
	 * adding them to an ArrayList.
	 * 
	 * @param theBoard
	 * @return an ArrayList containing the gameboard.
	 */
	public static ArrayList<AreaBoard> setUpBoard(ArrayList<AreaBoard> theBoard) {

		// Set up spaces
		AreaBoard tile01 = new AreaBoard("Start", false, 0, 0);
		AreaBoard tile02 = new AreaBoard("Ironbridge", true, 1, 50);
		AreaBoard tile03 = new AreaBoard("Polaniec", true, 1, 50);
		AreaBoard tile04 = new AreaBoard("Jiuquan", true, 2, 60);
		AreaBoard tile05 = new AreaBoard("Capricorn Ridge", true, 2, 60);
		AreaBoard tile06 = new AreaBoard("Eco-Pit Stop", false, 0, 0);
		AreaBoard tile07 = new AreaBoard("Walney", true, 2, 60);
		AreaBoard tile08 = new AreaBoard("Desert Sunlight", true, 3, 65);
		AreaBoard tile09 = new AreaBoard("Topaz", true, 3, 65);
		AreaBoard tile10 = new AreaBoard("Rewa Ultra Mega", true, 3, 65);
		AreaBoard tile11 = new AreaBoard("Three Gorges", true, 4, 80);
		AreaBoard tile12 = new AreaBoard("Itaipu", true, 4, 80);

		// Adding to board
		theBoard.add(tile01);
		theBoard.add(tile02);
		theBoard.add(tile03);
		theBoard.add(tile04);
		theBoard.add(tile05);
		theBoard.add(tile06);
		theBoard.add(tile07);
		theBoard.add(tile08);
		theBoard.add(tile09);
		theBoard.add(tile10);
		theBoard.add(tile11);
		theBoard.add(tile12);

		// returns the ArrayList which has been populated with tiles.
		return theBoard;
	}
}
