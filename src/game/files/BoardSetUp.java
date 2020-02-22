package game.files;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class sets up the board for the game.
 * 
 * @author v1.0 Jordan
 * @author v2.0 - 2.2 Bekah, Catherine, Ricards (Refactored code, fixed issue
 *         with scanners)
 * @author v2.3 - Jordan (updating of documentation)
 *
 */

public class BoardSetUp {

	/**
	 * 
	 * Sets up the number of players playing the game
	 *
	 * @param currentPlayers
	 * @param input
	 * @return an int that specifies the amount of players within the game
	 */
	public static int setUpPlayers(Scanner input) {

		int amountOfPlayers = 0;
		boolean validEntryNumberOfPlayers = false;

		// prompt the user
		while (validEntryNumberOfPlayers != true) {

			System.out.println("Please enter the amount of Eco Warriors playing!");

			amountOfPlayers = input.nextInt();
			input.nextLine();
			// input.reset();

			if (amountOfPlayers >= 1 && amountOfPlayers <= 4) {
				validEntryNumberOfPlayers = true;
			} else {
				System.err.println("Sorry, please enter a number of players between 1 - 4.");
			}

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
			player.setMoney(125);
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

		AreaBoard tile06 = new AreaBoard("Eci-Pit Stop", false, 0, 0);

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
