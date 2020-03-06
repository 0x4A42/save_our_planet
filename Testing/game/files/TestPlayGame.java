package game.files;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * class that tests PlayGame class and thus all game logic such as
 * moving, buying, landing, upgrading, quiting, losing
 * @author Catherine
 *
 */
class TestPlayGame {
	
	private ArrayList<AreaBoard> board;
	private ArrayList<Player> players;
	private Player player1;
	private Player player2;

	@BeforeEach
	void setUp() throws Exception {
		board = BoardSetUp.setUpBoard(new ArrayList<AreaBoard>());
		player1 = new Player(1, "player1", 1000, 0);
		player2 = new Player(2, "player2", 1000, 0);
		players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
	}
	
	@Test
	public void testUpgrade_OwnNoFileds() {
		// set up scanner input - player will try to upgrade property 4
		ByteArrayInputStream in = new ByteArrayInputStream(("4").getBytes());
	    System.setIn(in);
	    Scanner input = new Scanner(System.in);
	    PlayGame.setInput(input);
	    
		// upgrade
		PlayGame.upgrade(players, 0, board);
		
		// should now have no minor upgrades on property 4
		assertEquals(0, board.get(4).getMinorUpgrades());
	}

	@Test
	public void testUpgrade_AddMinorUpgrade() {
		// set first two properties to be owned by player 1
		board.get(1).setOwnerId(1);
		board.get(2).setOwnerId(1);
		
		// set up scanner input - player will try to upgrade field 1
		ByteArrayInputStream in = new ByteArrayInputStream(("1").getBytes());
	    System.setIn(in);
	    Scanner input = new Scanner(System.in);
	    PlayGame.setInput(input);
	    
		// upgrade
		PlayGame.upgrade(players, 0, board);
		
		// should now have minor upgrades on property 1
		assertEquals(1, board.get(1).getMinorUpgrades());
		assertEquals(0, board.get(2).getMinorUpgrades());
	}
	
	@Test
	public void testUpgrade_AddMinorUpgrade_NotEnoughMoney() {
		// set player 1 money to 1
		player1.setMoney(1);
		
		// set field 2 to be owned by player 1
		board.get(3).setOwnerId(1);
		board.get(4).setOwnerId(1);
		board.get(6).setOwnerId(1);
		
		// set up scanner input - player will try to upgrade field 2
		ByteArrayInputStream in = new ByteArrayInputStream(("4").getBytes());
	    System.setIn(in);
	    Scanner input = new Scanner(System.in);
	    PlayGame.setInput(input);
	    
		// upgrade
		PlayGame.upgrade(players, 0, board);
		
		// should now have no minor upgrades on property 4
		assertEquals(0, board.get(4).getMinorUpgrades());
	}
	
	@Test
	public void testUpgrade_AddMajorUpgrade() {
		// set field 3 to be owned by player 1
		board.get(7).setOwnerId(1);
		board.get(8).setOwnerId(1);
		board.get(9).setOwnerId(1);
		
		// set up scanner input - player will try to upgrade field 3 - 4 times
		ByteArrayInputStream in = new ByteArrayInputStream(("8" + System.lineSeparator()
			+ "8" + System.lineSeparator() 
			+ "8" + System.lineSeparator() 
			+ "8").getBytes());
	    System.setIn(in);
	    Scanner input = new Scanner(System.in);
	    PlayGame.setInput(input);
	    
		// upgrade same property 4 times
		PlayGame.upgrade(players, 0, board);
		PlayGame.upgrade(players, 0, board);
		PlayGame.upgrade(players, 0, board);
		PlayGame.upgrade(players, 0, board);
		
		// should now have 3 minor upgrades and 1 major upgrade on property 8
		assertEquals(3, board.get(8).getMinorUpgrades());
		assertEquals(1, board.get(8).getMajorUpgrades());
		assertEquals(0, board.get(9).getMinorUpgrades());
		assertEquals(0, board.get(9).getMajorUpgrades());
	}
	
	@Test
	public void testUpgrade_ProperyMaxedOut() {
		// set first two properties to be owned by player 1
		board.get(10).setOwnerId(1);
		board.get(11).setOwnerId(1);
		
		// set up scanner input - player will try to upgrade field 4 - 5 times
		ByteArrayInputStream in = new ByteArrayInputStream(("10" + System.lineSeparator()
			+ "10" + System.lineSeparator() 
			+ "10" + System.lineSeparator() 
			+ "10" + System.lineSeparator() 
			+ "10").getBytes());
	    System.setIn(in);
	    Scanner input = new Scanner(System.in);
	    PlayGame.setInput(input);
	    
		// upgrade same property 4 times
		PlayGame.upgrade(players, 0, board);
		PlayGame.upgrade(players, 0, board);
		PlayGame.upgrade(players, 0, board);
		PlayGame.upgrade(players, 0, board);
		PlayGame.upgrade(players, 0, board);
		
		// should now have 3 minor upgrades and 1 major upgrade on property 1
		assertEquals(3, board.get(10).getMinorUpgrades());
		assertEquals(1, board.get(10).getMajorUpgrades());
		assertEquals(0, board.get(11).getMinorUpgrades());
		assertEquals(0, board.get(11).getMajorUpgrades());
	}
	
	@Test
	public void testRollDice() {
		int max = 0;
		int min = 12;
		for (int i = 0; i < 1000; i++) {
			int result = PlayGame.rollDice();
			if (result > max) {
				max = result;
			} else if (result < min) {
				min = result;
			}
		}
		assertEquals(2, min);
		assertEquals(12, max);
	}
	
	@Test
	public void testMovePosition_Buy() {
		// set up scanner input - player will roll and try to buy
		ByteArrayInputStream in = new ByteArrayInputStream(("x").getBytes());
		System.setIn(in);
		Scanner input = new Scanner(System.in);
		PlayGame.setInput(input);
		
		// move to first property
		PlayGame.movePosition(1, players, 0, board);
		
		// first property should now be owned by player 1
		assertEquals(1, board.get(1).getOwnerId());
	}
	
	@Test
	public void testMovePosition_MoveAroundBoard_Buy() {
		// set up scanner input - player will roll and try to buy
		ByteArrayInputStream in = new ByteArrayInputStream(("x").getBytes());
		System.setIn(in);
		Scanner input = new Scanner(System.in);
		PlayGame.setInput(input);
		
		// move around board and onto first property
		PlayGame.movePosition(12, players, 0, board);
		
		// first property should now be owned by player 1
		assertEquals(1, board.get(1).getOwnerId());
	}
	
	@Test
	public void testMovePosition_Buy_NotEnoughMoney() {
		// set player 1 money to 1
		player1.setMoney(1);
		
		// set up scanner input - player will roll and try to buy
		ByteArrayInputStream in = new ByteArrayInputStream(("x").getBytes());
		System.setIn(in);
		Scanner input = new Scanner(System.in);
		PlayGame.setInput(input);
		
		// move to first property
		PlayGame.movePosition(1, players, 0, board);
		
		// first property should now not be owned
		assertEquals(0, board.get(1).getOwnerId());
	}
	
	@Test
	public void testMovePosition_Buy_LandOnEnemyProperty() {
		// set up scanner input - player will roll and try to buy
		ByteArrayInputStream in = new ByteArrayInputStream(("x").getBytes());
		System.setIn(in);
		Scanner input = new Scanner(System.in);
		PlayGame.setInput(input);
		
		// player 1 move to first property and buy it
		PlayGame.movePosition(1, players, 0, board);
		
		// player 1 should have lost 50 money
		assertTrue(player1.getMoney() == 950);
		
		// player 2 move to first property
		PlayGame.movePosition(1, players, 1, board);
		
		// player 2 should have lost money
		assertTrue(player2.getMoney() < 1000);
		
		// player 1 should have gained money
		int diff = 1000 - player2.getMoney();
		assertTrue(player1.getMoney() == 950 + diff);
	}
	
	@Test
	public void testQuitGame_EndGame() {
		// set up scanner input - player quit
		ByteArrayInputStream in = new ByteArrayInputStream(("q" 
		+ System.lineSeparator() + "y").getBytes());
		System.setIn(in);
		Scanner input = new Scanner(System.in);
		PlayGame.setInput(input);
		
		// quit the game
		PlayGame.playerTurn(players, board);
		
		// game should be over
		assertFalse(PlayGame.continueGame);
	}
	
	@Test
	public void testGameOver_OutOfMoney() {
		// set player 1 money to 0
		player1.setMoney(0);
		
		// set up scanner input - player takes their turn
		ByteArrayInputStream in = new ByteArrayInputStream(("x" 
		+ System.lineSeparator() + "x").getBytes());
		System.setIn(in);
		Scanner input = new Scanner(System.in);
		PlayGame.setInput(input);
		
		// quit the game
		PlayGame.playerTurn(players, board);
		
		// game should be over
		assertFalse(PlayGame.continueGame);
	}
	
	@Test
	public void testPrintPortfolio() {
		player1.setMoney(0);
		board.get(10).setOwnerId(1);
		
		// set up scanner input - player takes their turn
		ByteArrayInputStream in = new ByteArrayInputStream(("p" 
		+ System.lineSeparator() + "x"
		+ System.lineSeparator() + "x").getBytes());
		System.setIn(in);
		Scanner input = new Scanner(System.in);
		PlayGame.setInput(input);
		
		//play game
		PlayGame.playerTurn(players, board);
		
		// no assertion
	}

}
