package game.files;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTesting {

	// test data
	int validPlayerIdLowerBoundary, validPlayerIdUpperBoundary, validPlayerIdLower, validPlayerIdUpper;
	int invalidPlayerIdLower, invalidPlayerIdUpper;
	String validPlayerNameLowerBoundary, validPlayerNameUpperBoundary, validPlayerNameLower, validPlayerNameUpper;
	String invalidPlayerNameLower, invalidPlayerNameUpper;
	double validMoneyBoundary, validMoney;
	double invalidMoney;
	int validBoardPositionLowerBoundary, validBoardPositionUpperBoundary, validBoardPositionLower,
			validBoardPositionUpper;
	int invalidBoardPositionLower, invalidBoardPositionUpper;
	Player playerToTest;

	@BeforeEach
	void setUp() throws Exception {
		validPlayerIdLowerBoundary = 1;
		validPlayerIdLower = 2;
		validPlayerIdUpper = 3;
		validPlayerIdUpperBoundary = 4;
		invalidPlayerIdLower = 0;
		invalidPlayerIdUpper = 5;
		validPlayerNameLowerBoundary = "a";
		validPlayerNameUpperBoundary = "validNameToTest";
		validPlayerNameLower = "validName";
		validPlayerNameUpper = "validNameToTst";
		invalidPlayerNameLower = "";
		invalidPlayerNameUpper = "anInvalidTestNam";
		validMoneyBoundary = 0;
		validMoney = 50;
		invalidMoney = -1;
		validBoardPositionLowerBoundary = 0;
		validBoardPositionUpperBoundary = 11;
		validBoardPositionLower = 4;
		validBoardPositionUpper = 9;
		invalidBoardPositionLower = -1;
		invalidBoardPositionUpper = 12;

		playerToTest = new Player();

	}

	@Test
	void validPlayerId() {
		playerToTest.setPlayerId(validPlayerIdLowerBoundary);
		assertEquals(validPlayerIdLowerBoundary, playerToTest.getPlayerId());

		playerToTest.setPlayerId(validPlayerIdLower);
		assertEquals(validPlayerIdLower, playerToTest.getPlayerId());

		playerToTest.setPlayerId(validPlayerIdUpper);
		assertEquals(validPlayerIdUpper, playerToTest.getPlayerId());

		playerToTest.setPlayerId(validPlayerIdUpperBoundary);
		assertEquals(validPlayerIdUpperBoundary, playerToTest.getPlayerId());

	}

	@Test
	void invalidPlayerId() {
		// test invalid lower value
		Exception invalidIdLower = assertThrows(IllegalArgumentException.class, () -> {
			playerToTest.setPlayerId(invalidPlayerIdLower);
		});
		System.out.println(invalidIdLower.getMessage());

		// test invalid upper value
		Exception invalidIdUpper = assertThrows(IllegalArgumentException.class, () -> {
			playerToTest.setPlayerId(invalidPlayerIdUpper);
		});
		System.out.println(invalidIdUpper.getMessage());

	}

	@Test
	void validPlayerNames() {
		playerToTest.setPlayerName(validPlayerNameLowerBoundary);
		assertEquals(validPlayerNameLowerBoundary, playerToTest.getPlayerName());

		playerToTest.setPlayerName(validPlayerNameUpperBoundary);
		assertEquals(validPlayerNameUpperBoundary, playerToTest.getPlayerName());

		playerToTest.setPlayerName(validPlayerNameLower);
		assertEquals(validPlayerNameLower, playerToTest.getPlayerName());

		playerToTest.setPlayerName(validPlayerNameUpper);
		assertEquals(validPlayerNameUpper, playerToTest.getPlayerName());

	}

	@Test
	void invalidPlayerNames() {
		Exception invalidNameLower = assertThrows(NullPointerException.class, () -> {
			playerToTest.setPlayerName(invalidPlayerNameLower);
		});
		System.out.println(invalidNameLower.getMessage());

		/*
		 * Tests to check if the name that is fed in (16 characters) is correctly
		 * truncated to be 15 "anInvalidTestNam" should become "anInvalidTestNa".
		 */
		String expected = "anInvalidTestNa";
		playerToTest.setPlayerName(invalidPlayerNameUpper);
		assertEquals(expected, playerToTest.getPlayerName());
	}

	@Test
	void validMoney() {

		playerToTest.setMoney(validMoneyBoundary);
		assertEquals(validMoneyBoundary, playerToTest.getMoney());

		playerToTest.setMoney(validMoney);
		assertEquals(validMoney, playerToTest.getMoney());
	}

	@Test
	void invalidMoney() {

		Exception invalidMoneyException = assertThrows(IllegalArgumentException.class, () -> {
			playerToTest.setMoney(invalidMoney);
		});
		System.out.println(invalidMoneyException.getMessage());
	}

	@Test
	void validBoardPosition() {
		playerToTest.setBoardPosition(validBoardPositionLowerBoundary);
		assertEquals(validBoardPositionLowerBoundary, playerToTest.getBoardPosition());

		playerToTest.setBoardPosition(validBoardPositionUpperBoundary);
		assertEquals(validBoardPositionUpperBoundary, playerToTest.getBoardPosition());

		playerToTest.setBoardPosition(validBoardPositionLower);
		assertEquals(validBoardPositionLower, playerToTest.getBoardPosition());

		playerToTest.setBoardPosition(validBoardPositionUpper);
		assertEquals(validBoardPositionUpper, playerToTest.getBoardPosition());
	}

	@Test
	void invalidBoardPosition() {
		Exception invalidBoardPositionLowerException = assertThrows(IllegalArgumentException.class, () -> {
			playerToTest.setBoardPosition(invalidBoardPositionLower);
		});
		System.out.println(invalidBoardPositionLowerException.getMessage());

		Exception invalidBoardPositionUpperException = assertThrows(IllegalArgumentException.class, () -> {
			playerToTest.setBoardPosition(invalidBoardPositionUpper);
		});
		System.out.println(invalidBoardPositionUpperException.getMessage());

	}

	@Test
	void validDefaultConstructor() {
		Player playerDefaultConstructor = new Player();
		// sets and checks ID
		playerDefaultConstructor.setPlayerId(validPlayerIdLowerBoundary);
		assertEquals(validPlayerIdLowerBoundary, playerDefaultConstructor.getPlayerId());
		// sets and checks board position
		playerDefaultConstructor.setBoardPosition(validBoardPositionLower);
		assertEquals(validBoardPositionLower, playerDefaultConstructor.getBoardPosition());
		// sets and checks money
		playerDefaultConstructor.setMoney(validMoney);
		assertEquals(validMoney, playerDefaultConstructor.getMoney());
		// sets and checks name
		playerDefaultConstructor.setPlayerName(validPlayerNameUpper);
		assertEquals(validPlayerNameUpper, playerDefaultConstructor.getPlayerName());
	}

	@Test
	void validConstructorWithArgs() {
		// tests the constructor with args with one set of args
		Player firstPlayerConstructorArgs = new Player(validPlayerIdLower, validPlayerNameLowerBoundary, validMoney,
				validBoardPositionUpper);
		assertEquals(firstPlayerConstructorArgs.getPlayerId(), validPlayerIdLower);
		assertEquals(firstPlayerConstructorArgs.getPlayerName(), validPlayerNameLowerBoundary);
		assertEquals(firstPlayerConstructorArgs.getMoney(), validMoney);
		assertEquals(firstPlayerConstructorArgs.getBoardPosition(), validBoardPositionUpper);
		// tests the constructor with args with a second set of args
		Player secondPlayerConstructorArgs = new Player(validPlayerIdUpper, validPlayerNameUpper, validMoneyBoundary,
				validBoardPositionLowerBoundary);
		assertEquals(secondPlayerConstructorArgs.getPlayerId(), validPlayerIdUpper);
		assertEquals(secondPlayerConstructorArgs.getPlayerName(), validPlayerNameUpper);
		assertEquals(secondPlayerConstructorArgs.getMoney(), validMoneyBoundary);
		assertEquals(secondPlayerConstructorArgs.getBoardPosition(), validBoardPositionLowerBoundary);

	}

	@Test
	void invalidConstructorWithArgs() {

		Exception invalidArgsID = assertThrows(IllegalArgumentException.class, () -> {
			Player playerConstructorArgs = new Player(invalidPlayerIdUpper, validPlayerNameLowerBoundary, validMoney,
					validBoardPositionUpper);
		});
		System.out.println(invalidArgsID.getMessage());

		Exception invalidArgsName = assertThrows(NullPointerException.class, () -> {
			Player playerConstructorArgs = new Player(validPlayerIdLower, invalidPlayerNameLower, validMoney,
					validBoardPositionUpper);
		});
		System.out.println(invalidArgsName.getMessage());

		Exception invalidArgsMoney = assertThrows(IllegalArgumentException.class, () -> {
			Player playerConstructorArgs = new Player(validPlayerIdLower, validPlayerNameUpper, invalidMoney,
					validBoardPositionUpper);
		});
		System.out.println(invalidArgsMoney.getMessage());

		Exception invalidArgsPosition = assertThrows(IllegalArgumentException.class, () -> {
			Player playerConstructorArgs = new Player(validPlayerIdLower, validPlayerNameUpperBoundary, validMoney,
					invalidBoardPositionLower);
		});
		System.out.println(invalidArgsPosition.getMessage());

	}

}
