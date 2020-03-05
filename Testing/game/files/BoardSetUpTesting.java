package game.files;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardSetUpTesting {

	// test data

	// Scanner testScanner;

	int playerAmountValidUpper, playerAmountValidLower, playerAmountInvalid;
	char playerAmountDataInvalid;

	String nameValid, nameInvalid;

	ArrayList<Player> testPlayers;

	Player validPlayer1;
	Player validPlayer2;

	@BeforeEach
	void setUp() throws Exception {
		playerAmountValidUpper = 4;
		playerAmountValidLower = 1;
		playerAmountInvalid = 0;

		playerAmountDataInvalid = 'f';
		nameInvalid = "";
		nameValid = "Valid Name";

		testPlayers = new ArrayList<Player>();

		validPlayer1 = new Player(1, nameValid, 100, 0);
		validPlayer2 = new Player(2, nameValid, 50, 0);

		testPlayers.add(validPlayer1);
		testPlayers.add(validPlayer2);

	}

	// test correct no of players
	// test in correct no of players
	// test invalid input type
	@Test
	void testSetUpPlayers() {
		// BoardSetUp.setUpPlayers(testScanner);

	}

	// valid name input
	// invalid name input
	// test objs added to array
	@Test
	void testCreatePlayer() {

		// BoardSetUp.createPlayer(testScanner, 2, testPlayers);
		// assertNotNull(testPlayers);
	}

	@Test
	void testSetUpBoard() {
		ArrayList<AreaBoard> testArea = new ArrayList<AreaBoard>();

		BoardSetUp.setUpBoard(testArea);

		assertNotNull(testArea);

	}

}
