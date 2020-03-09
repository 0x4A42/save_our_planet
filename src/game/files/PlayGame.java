/**
 * 
 */
package game.files;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * CSC7053-1920-G2: Jordan Brown (40282125), Ricards Estemirovs (40126945),
 * Rebekah Logan (40059637), Catherine McGuckin (40105486)
 * 
 * 
 * This class will be where the board game is played.
 * 
 * @author v1.0 Bekah, Ricards (Set up initial class and methods)
 * @author v1.1 Bekah, Catherine, Jordan, Ricards (Scanner issues repaired &
 *         Refactored) this is the main class the game is played from it keeps
 *         calling the playerTurn method until a player leaves then game then
 *         proceeds to the endGame method
 * @author v3 Bekah, Ricards (Movement, buy/pay rent, & upgrade systems
 *         implemented)
 * @author v4 Catherine (quit and winning conditions, end game implemented,
 *         print portfolio implemented, continueGame made into static instance
 *         variable, rollDice rewrite to loop for numberOfDice, numberOfDice
 *         made into constant)
 * @author v4.1 Jordan (bug fixes, some additional documentation and rewording
 *         of prompts to user. Fixed the upgrade system.) Catherine (view
 *         portfolio function).
 * @author v4.2 Jordan (further validation of at least 2 players to avoid Array
 *         error if a single player is playing and attempts to upgrade property)
 * @author v4.3 Catherine (fix bug in upgrade system where player n+1 would be
 *         charged for an upgrade done by player n. This causes exception if
 *         last player upgrades)
 * @author v4.4 Jordan (updating naming of constants to ensure they follow
 *         convention - e.g numberOfDice to NUMBER_OF_DICE and updated any
 *         appearance of it within code).
 * @author v4.5 Jordan (Made it so user must now confirm with a key entry when given the state of their portfolio or tries to upgrade but can't, updated economy values. )
 */
public class PlayGame {

	// Scanner that is used by all methods in game
	public static Scanner input = new Scanner(System.in);
	public static boolean continueGame = true;
	private static final int NUMBER_OF_DICE = 2;
	private static final int MONEY_GAINED_PER_TURN = 40;

	public static void main(String[] args) {

		/*
		 * Set up for the game, including creating ArrayLists to hold the board and /
		 * player objects
		 */
		ArrayList<Player> currentPlayers = new ArrayList<Player>();
		ArrayList<AreaBoard> gameBoard = new ArrayList<AreaBoard>();
		int amountOfPlayers = BoardSetUp.setUpPlayers(input);
		input.reset();
		currentPlayers = BoardSetUp.createPlayer(input, amountOfPlayers, currentPlayers);
		gameBoard = BoardSetUp.setUpBoard(gameBoard);

		// player turns continue until victory condition fulfilled
		do {

			playerTurn(currentPlayers, gameBoard);

		} while (continueGame == true);
	}

	/**
	 * This method loops through each player in the ArrayList it contains,
	 * displaying a turn menu which will allow the player to either a) roll the dice
	 * normally b) upgrade their existing properties if they own all within a field
	 * c) view their portfolio of properties and d) quit the game (ending it)
	 * 
	 * @param currentPlayers, an ArrayList containing the players within this game
	 * @param gameBoard,      an ArrayList containing the board squares.
	 */
	public static void playerTurn(ArrayList<Player> currentPlayers, ArrayList<AreaBoard> gameBoard) {

		String inputStr;

		for (int loop = 0; loop < currentPlayers.size(); loop++) {

			int roll;
			inputStr = null;

			System.out.println("\nIt's now " + currentPlayers.get(loop).getPlayerName() + "'s turn!");
			System.out.println("You currently have " + currentPlayers.get(loop).getMoney() + " EcoCoins!");
			// menu prompt to user
			System.out.println("\nEnter X to roll the dice...");
			System.out.println("Enter U to upgrade your property...");
			System.out.println("Enter P to view your portfolio...");
			System.out.println("Enter Q to quit");
			// input.nextLine();
			inputStr = input.nextLine();

			// switch statement to complete different functions based on the user's choice
			switch (inputStr.toLowerCase()) {

			case "x": // roll and take your turn normally
				roll = (rollDice());
				movePosition(roll, currentPlayers, loop, gameBoard);
				break;

			/*
			 * Calls the upgrade method to determine if the player has all properties within
			 * a field. If so, they can upgrade and this takes up their turn. If not, they
			 * roll normally.
			 */
			case "u":
				if (upgrade(currentPlayers, loop, gameBoard) == false) {
					roll = (rollDice());
					movePosition(roll, currentPlayers, loop, gameBoard);
				}
				break;

			case "p": // views the portfolio of the player
				printPortfolio(currentPlayers, loop, gameBoard);
				roll = (rollDice());
				movePosition(roll, currentPlayers, loop, gameBoard);
				break;

			case "q": // quits the game
				quitGame(currentPlayers, loop);
				break;

			// if the user does not enter X, U, P or Q, prompt them until they do so.
			default:

				System.out.println("Please enter X, U, P or Q to continue...");
				while (input.hasNextLine()) {
					inputStr = input.nextLine();
					roll = (rollDice());
					movePosition(roll, currentPlayers, loop, gameBoard);

					break;
				}

			}// end of switch

			// if a player has 0 EcoCoins left, ends the game.
			if (currentPlayers.get(loop).getMoney() <= 0) {
				endGame(currentPlayers, currentPlayers.get(loop).getPlayerName());
			}

			/*
			 * if game should end, either through no money or selecting quit, breaks out of
			 * loop.
			 */
			if (!continueGame) {
				break;
			}

		} // end of for loop
		if (continueGame) {
			System.out.println("End of Round! Press Enter to continue!");
			input.nextLine();
		}
	}

	/**
	 * This displays the player's current owned properties that they can upgrade
	 * (provided they own all areas within a field).
	 * 
	 * @param currentPlayers, an ArrayList of players in the current game
	 * @param currentPlayer,  the player whose turn it currently is and will make
	 *                        upgrades
	 * @param gameBoard,      an Arraylist of the current game board
	 * @return a Boolean, if false it means that the player rolls in this turn, if
	 *         true then they have completed an upgrade and will not roll.
	 */
	public static boolean upgrade(ArrayList<Player> currentPlayers, int currentPlayer, ArrayList<AreaBoard> gameBoard) {
		boolean canUpgrade = false;
		System.out.println("Now displaying upgrades available:");

		int currentPlayersId = currentPlayers.get(currentPlayer).getPlayerId();

		// Temporary storage to check if a player owns any of the fields
		boolean check1 = CheckOwnershipUtility.doesPlayerOwnField(gameBoard, currentPlayersId, 1);
		boolean check2 = CheckOwnershipUtility.doesPlayerOwnField(gameBoard, currentPlayersId, 2);
		boolean check3 = CheckOwnershipUtility.doesPlayerOwnField(gameBoard, currentPlayersId, 3);
		boolean check4 = CheckOwnershipUtility.doesPlayerOwnField(gameBoard, currentPlayersId, 4);

		/*
		 * If at least one of the fields is owned it will allow the player to upgrade a
		 * field The initial if statement checks if the player owns all properties
		 * within a specified field, the inner if statements then check if the player
		 * owns specific fields and prints out the property details if so (thus allowing
		 * them to purchase the property upgrades)
		 */
		if (check1 == true || check2 == true || check3 == true || check4 == true) {
			// prints out all field 1 properties if the player owns all areas
			if (check1 == true) {
				CheckOwnershipUtility.returnOwnedByField(gameBoard, currentPlayers.get(currentPlayer).getPlayerId(), 1);
				canUpgrade = true;
			}

			// prints out all field 2 properties if the player owns all areas
			if (check2 == true) {
				CheckOwnershipUtility.returnOwnedByField(gameBoard, currentPlayers.get(currentPlayer).getPlayerId(), 2);
				canUpgrade = true;
			}

			// prints out all field 3 properties if the player owns all areas
			if (check3 == true) {
				CheckOwnershipUtility.returnOwnedByField(gameBoard, currentPlayers.get(currentPlayer).getPlayerId(), 3);
				canUpgrade = true;
			}

			// prints out all field 4 properties if the player owns all areas
			if (check4 == true) {
				CheckOwnershipUtility.returnOwnedByField(gameBoard, currentPlayers.get(currentPlayer).getPlayerId(), 4);
				canUpgrade = true;
			}
			// calls addUpgrade method to allow the user to purchase upgrades
			addUpgrade(currentPlayers, currentPlayersId, gameBoard);
			// if no fields are owned, displays message to user
		} else {
			System.out.println("Sorry you have no upgrades available!\n");
			System.out.println("Please enter any key to continue your turn.");
			input.nextLine();
		}

		return canUpgrade;

	}

	/**
	 * If the player can upgrade an area due to owning the field, this method will
	 * handle the process.
	 * 
	 * @param currentPlayers, an ArrayList of players in the current game
	 * @param currentPlayer,  the player whose turn it currently is and will make
	 *                        upgrades
	 * @param gameBoard,      an Arraylist of the current game board
	 */
	public static void addUpgrade(ArrayList<Player> currentPlayers, int currentPlayerId,
			ArrayList<AreaBoard> gameBoard) {

		System.out.println("Which area would you like to upgrade? Enter number.");

		int playerInputUpgrade;
		playerInputUpgrade = input.nextInt();
		// if the player owns the property and it does not have a major upgrade, enter
		// the nested loop
		if (gameBoard.get(playerInputUpgrade).getOwnerId() == currentPlayerId
				&& gameBoard.get(playerInputUpgrade).getMajorUpgrades() != 1) {
			/*
			 * If the property does not have the max amount of minor upgrades, purchase a
			 * minor upgrade.
			 */
			if (gameBoard.get(playerInputUpgrade).getMinorUpgrades() < AreaBoard.UPPER_MINOR_UPGRADE_LIMIT) {
				gameBoard.get(playerInputUpgrade).buyMinorUpgrade(currentPlayers.get(currentPlayerId - 1));
				/*
				 * If the max amount of minor upgrades exist, purchase a Major upgrade.
				 */
			} else {
				gameBoard.get(playerInputUpgrade).buyMajorUpgrade(currentPlayers.get(currentPlayerId - 1));
			}

		}

	}

	/**
	 * this method accepts the dice roll and decides the player's new position on
	 * the board it checks if the player passes go (makes a full pass around the
	 * board and returns to beginning)
	 * 
	 * @param roll
	 * @param currentPlayers
	 * @param currentPlayer
	 * @return int, the player's new board position
	 */
	public static int movePosition(int roll, ArrayList<Player> currentPlayers, int currentPlayer,
			ArrayList<AreaBoard> gameBoard) {

		System.out.println("You move a total of " + roll + " spaces!");

		int oldPos = currentPlayers.get(currentPlayer).getBoardPosition();

		int newPosition = (roll + oldPos);
		/*
		 * This if else statement checks if the roll will place the player on a position
		 * greater than the length of the current board. If so, removes 11 from the
		 * position to ensure it is still within the range.
		 */
		if (newPosition > 11) {
			newPosition -= 11;
			currentPlayers.get(currentPlayer).gainMoney(MONEY_GAINED_PER_TURN);
			System.out.println("You have passed Start and gained " + MONEY_GAINED_PER_TURN + " EcoCoins!");
			currentPlayers.get(currentPlayer).setBoardPosition(newPosition);
		} else {
			currentPlayers.get(currentPlayer).setBoardPosition(newPosition);
		}

		String currentBoardPosition = gameBoard.get(newPosition).getSpaceName();

		System.out.println("\n" + currentPlayers.get(currentPlayer).getPlayerName() + " is now on square " + newPosition
				+ ": " + currentBoardPosition + "!");

		if (gameBoard.get(newPosition).isOwnable() && !gameBoard.get(newPosition).isOwned()) {

			System.out.println(currentBoardPosition + " is not owned by anyone. Would you like to purchase it for "
					+ gameBoard.get(newPosition).getCost() + "?");

			System.out.println("Enter X to purchase, else enter Y...");
			// input.nextLine();
			String choice = input.nextLine();

			/*
			 * If the user inputs X, they will buy the property they have landed on (if not
			 * already owned). If they input Y, they do not purchase and their turns ends.
			 */

			switch (choice.toLowerCase()) {

			case "x":
				gameBoard.get(newPosition).bought(currentPlayer, currentPlayers);
				break;

			case "y":
				break;

			default:
			}

		} else if (gameBoard.get(newPosition).isOwnable()
				&& gameBoard.get(newPosition).getOwnerId() != currentPlayers.get(currentPlayer).getPlayerId()) {
			System.out.println(currentBoardPosition + " is owned by " + gameBoard.get(newPosition).getOwnerId() + ".");

			CheckOwnershipUtility.chargePlayer(gameBoard, currentPlayers, currentPlayer);

		} else if (gameBoard.get(newPosition).isOwnable()
				&& gameBoard.get(newPosition).getOwnerId() == currentPlayers.get(currentPlayer).getPlayerId()) {

			System.out.println(currentBoardPosition + " is owned by you!");
		}

		else {
			System.out.println("Feel free to rest here for a while!");
		}

		return newPosition;
	}

	/**
	 * method that rolls the number of dice and returns total result
	 * 
	 * @return totalRoll, the total roll result
	 */
	public static int rollDice() {
		int totalRoll = 0;
		Random diceRoll = new Random();
		for (int i = 0; i < NUMBER_OF_DICE; i++) {
			int roll = diceRoll.nextInt(6) + 1;
			System.out.println("Roll for dice " + (i + 1) + ": " + roll);
			totalRoll += roll;
		}
		return totalRoll;
	}

	/**
	 * prints the players stats, owned properties and how upgraded they are
	 * 
	 * @param currentPlayers
	 * @param loop
	 * @param gameBoard
	 */
	public static void printPortfolio(ArrayList<Player> currentPlayers, int loop, ArrayList<AreaBoard> gameBoard) {
		Player player = currentPlayers.get(loop);
		System.out.println("Player: " + player.getPlayerName() + ", Money: " + player.getMoney());
		System.out.println("Owned property");
		for (AreaBoard areaBoard : gameBoard) {
			if (areaBoard.getOwnerId() == player.getPlayerId()) {
				System.out.println("\nProperty name: " + areaBoard.getSpaceName());
				System.out.println("Minor upgrades: " + areaBoard.getMinorUpgrades());
				System.out.println("Major upgrades: " + areaBoard.getMajorUpgrades() + "\n");

			}
		}
		System.out.println("Please enter any key to continue your turn.");
		input.nextLine();
	}

	/**
	 * this method called when player quits the game and ends the game
	 * 
	 * @param currentPlayers     - ArrayList<player>
	 * @param currentPlayerIndex - int
	 */
	public static void quitGame(ArrayList<Player> currentPlayers, int currentPlayerIndex) {
		System.out.println("Are you sure you want to quit? Press Y to quit or N to cancel.");
		String answer = input.next();
		String loser = currentPlayers.get(currentPlayerIndex).getPlayerName();
		if (answer.equalsIgnoreCase("y")) {
			endGame(currentPlayers, loser);
		}

	}

	/**
	 * method called when a player quits or runs out of money, it ends the game
	 * 
	 * @param currentPlayers - ArrayList<player>
	 * @param loser          - string
	 */
	public static void endGame(ArrayList<Player> currentPlayers, String loser) {
		double maxMoney = 0;
		String winner = "";
		System.out.println("\nPlayer " + loser + " has lost - game over!");
		System.out.println("Final money of all players is: ");
		for (Player player : currentPlayers) {
			System.out.println(player.getPlayerName() + " : " + player.getMoney());
			if (player.getMoney() > maxMoney && !player.getPlayerName().equals(loser)) {
				maxMoney = player.getMoney();
				winner = player.getPlayerName();
			}
		}
		System.out.println("\nThe winner is... " + winner + " with a total money of: " + maxMoney);
		continueGame = false;

	}

	/**
	 * @param input the input to set
	 */
	public static void setInput(Scanner input) {
		PlayGame.input = input;
	}
}
