/**
 * 
 */
package game.files;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class will be where the board game is played. 
 * @author v1.0 Bekah, Ricards (Set up initial class and methods)
 * @author v1.1 Bekah, Cathrine, Jordan, Ricards (Scanner issues repaired &
 *         Refactored) this is the main class the game is played from it keeps
 *         calling the playerTurn method until a player leaves then game then
 *         proceeds to the endGame method
 *
 */
public class PlayGame {

	// Scanner that is used by all methods in game
	public static Scanner input = new Scanner(System.in);
 
	/**
	 * default constructor
	 */
	public PlayGame() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		boolean continueGame = true;

		// set up

		ArrayList<Player> currentPlayers = new ArrayList<Player>();
		ArrayList<AreaBoard> gameBoard = new ArrayList<AreaBoard>();

		int amountOfPlayers = BoardSetUp.setUpPlayers(input);

		input.reset();

		currentPlayers = BoardSetUp.createPlayer(input, amountOfPlayers, currentPlayers);

		// Tests to see if Objects are working (To be removed later)
		gameBoard = BoardSetUp.setUpBoard(gameBoard);

		System.out.println("Game board space 1: " + gameBoard.get(0).getSpaceName());
		System.out.println("First player has id: " + currentPlayers.get(0).getPlayerId());

		System.out.println("Number of players in array: " + currentPlayers.size() + "\n\n");

		// returnStr(input);

		// player turns continue until victory condition fulfilled
		do {

			playerTurn(currentPlayers);

		} while (continueGame == true);

		endGame();

	}

	/**
	 * 
	 * @param input
	 */
	public static void returnStr(Scanner input) {
		String a = "";
		a = input.nextLine();

		System.out.println(a);
		input.reset();

	}

	/**
	 * this method loops through each player in the array it contains the turn menu:
	 * roll dice + move OR view portfolio end round & check whether to continue
	 * 
	 * @param currentPlayers
	 */
	public static void playerTurn(ArrayList<Player> currentPlayers) {

		// TO DO check scanner input

		String inputStr;

		for (int loop = 0; loop < currentPlayers.size(); loop++) {

			int roll;

			System.out.println("It's now " + currentPlayers.get(loop).getPlayerName() + "'s turn!");
			// System.out.println("You ended your last turn on " +
			// currentPlayers.get(loop).getBoardPosition());
			System.out.println("\nEnter X to roll the dice...");
			System.out.println("Enter Y to view your portfolio...");

			inputStr = input.nextLine();

			switch (inputStr.toLowerCase()) {

			case "x": // roll
				roll = (rollDice());
				movePosition(roll, currentPlayers, loop);
				break;
			case "y": // view portfolio
				playerPortfolio(currentPlayers, loop);
				break;
			default:
				System.out.println("Please enter X or Y to continue...");
				while (input.hasNextLine()) {
					inputStr = input.nextLine();
				}
				// does this return to top of switch?
			}

			System.out.println("End of Round!");

		}
		// sc.close();
	}

	// display player status
	// money, portfolio, where you are now

	// roll dice

	// move to new square
	// upgrade or play rent

	/**
	 * view player's portfolio money + properties then return to menu
	 * 
	 * @param currentPlayers
	 * @param currentPlayer
	 */
	public static void playerPortfolio(ArrayList<Player> currentPlayers, int currentPlayer) {
		Scanner sc = new Scanner(System.in);

		// ADD total number of properties/list of properties

		System.out.println("Now displaying +" + currentPlayers.get(currentPlayer).getPlayerName() + "'s portfolio.");
		System.out.println("You are currently on " + currentPlayers.get(currentPlayer).getBoardPosition() + ".");
		System.out.println("You currently have " + currentPlayers.get(currentPlayer).getMoney() + " EcoCoins.");

		sc.close();
	}

	/**
	 * this method accepts the dice roll and decides the player's new position on
	 * the board it checks if the player passes go (makes a full pass around the
	 * board and returns to beginning)
	 * 
	 * @param roll
	 * @param currentPlayers
	 * @param currentPlayer
	 * @return
	 */
	public static int movePosition(int roll, ArrayList<Player> currentPlayers, int currentPlayer) {

		System.out.println("You move a total of " + roll + " spaces!");

		// old position
		int oldPos = currentPlayers.get(currentPlayer).getBoardPosition();

		// adds roll to old position, calculates new position

		int newPosition = (roll + oldPos);

		// passed go?
		// if (newPosition > oldPos) {
		// newPosition=(newPosition - old position);
		// System.out.println("You passed go!");
		// add money
		//

		// return new position
		return newPosition;
	}

	/**
	 * this method handles the dice roll 2 dice are rolled, if they are both the
	 * same then roll again
	 * 
	 */
	public static int rollDice() {

		int totalRoll = 0;
		int roll1, roll2, roll3, roll4;
		Random diceRoll = new Random();

		roll1 = diceRoll.nextInt(6) + 1;
		System.out.println("Roll for dice 1: " + roll1);
		totalRoll += roll1;
		roll2 = diceRoll.nextInt(6) + 1;
		System.out.println("Roll for dice 2: " + roll2);
		totalRoll += roll2;

		// System.out.println("You move a total of " + totalRoll + " spaces!");

		return totalRoll;
	}

	/**
	 * this method represents the end of the game
	 */
	public static void endGame() {

		System.out.println("End of game!");

	}
}
