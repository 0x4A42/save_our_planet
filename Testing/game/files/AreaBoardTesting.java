package game.files;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AreaBoardTesting {

	// test data
	int validFieldIdLowerBoundary, validFieldIdUpperBoundary, validFieldIdLower, validFieldIdMiddle, validFieldIdUpper;
	int invalidFieldIdLower, invalidFieldIdUpper;
	String validSpaceNameLowerBoundary, validSpaceNameLower, validSpaceNameMiddle, validSpaceNameUpper,
			validSpaceNameUpperBoundary;
	String invalidSpaceNameLower, invalidSpaceNameUpper;
	int validCostLowerBoundary, validCostUpperBoundary, validCostLower, validCostMiddle, validCostUpper;
	int invalidCostLower, invalidCostUpper;
	int validPlayerIdLowerBoundary, validPlayerIdLower, validPlayerIdMiddle, validPlayerIdUpperBoundary;
	int invalidPlayerIdLower, invalidPlayerIdUpper;
	AreaBoard squareToTest;

	@BeforeEach
	void setUp() throws Exception {
		validFieldIdLowerBoundary = 0;
		validFieldIdUpperBoundary = 4;
		validFieldIdLower = 1;
		validFieldIdMiddle = 2;
		validFieldIdUpper = 3;
		invalidFieldIdLower = -1;
		invalidFieldIdUpper = 5;
		validSpaceNameLowerBoundary = "a";
		validSpaceNameLower = "valid";
		validSpaceNameMiddle = "validSpaceName";
		validSpaceNameUpper = "thisIsAValidName";
		validSpaceNameUpperBoundary = "thisIsAValidSpaceName1234";
		invalidSpaceNameLower = "";
		invalidSpaceNameUpper = "thisIsAnInvalidSpaceName12";
		validCostLowerBoundary = 50;
		validCostUpperBoundary = 80;
		validCostLower = 51;
		validCostMiddle = 65;
		validCostUpper = 79;
		invalidCostLower = 49;
		invalidCostUpper = 81;
		validPlayerIdLowerBoundary = 1;
		validPlayerIdLower = 2;
		validPlayerIdMiddle = 3;
		validPlayerIdUpperBoundary = 4;
		invalidPlayerIdLower = 0;
		invalidPlayerIdUpper = 5;

		squareToTest = new AreaBoard();

	}

	@Test
	void validFieldId() {
		squareToTest.setFieldId(validFieldIdLowerBoundary);
		assertEquals(validFieldIdLowerBoundary, squareToTest.getFieldId());

		squareToTest.setFieldId(validFieldIdUpperBoundary);
		assertEquals(validFieldIdUpperBoundary, squareToTest.getFieldId());

		squareToTest.setFieldId(validFieldIdLower);
		assertEquals(validFieldIdLower, squareToTest.getFieldId());

		squareToTest.setFieldId(validFieldIdMiddle);
		assertEquals(validFieldIdMiddle, squareToTest.getFieldId());

		squareToTest.setFieldId(validFieldIdUpper);
		assertEquals(validFieldIdUpper, squareToTest.getFieldId());

	}

	@Test
	void invalidFieldId() {

		Exception invalidFieldIdLowerException = assertThrows(IllegalArgumentException.class, () -> {
			squareToTest.setFieldId(invalidFieldIdLower);
		});
		System.out.println(invalidFieldIdLowerException.getMessage());

		Exception invalidFieldIdUpperException = assertThrows(IllegalArgumentException.class, () -> {
			squareToTest.setFieldId(invalidFieldIdUpper);
		});
		System.out.println(invalidFieldIdUpperException.getMessage());

	}

	@Test
	void validSpaceName() {
		squareToTest.setSpaceName(validSpaceNameLowerBoundary);
		assertEquals(validSpaceNameLowerBoundary, squareToTest.getSpaceName());

		squareToTest.setSpaceName(validSpaceNameLower);
		assertEquals(validSpaceNameLower, squareToTest.getSpaceName());

		squareToTest.setSpaceName(validSpaceNameMiddle);
		assertEquals(validSpaceNameMiddle, squareToTest.getSpaceName());

		squareToTest.setSpaceName(validSpaceNameUpper);
		assertEquals(validSpaceNameUpper, squareToTest.getSpaceName());

		squareToTest.setSpaceName(validSpaceNameUpperBoundary);
		assertEquals(validSpaceNameUpperBoundary, squareToTest.getSpaceName());
	}

	@Test
	void invalidSpaceName() {
		Exception invalidSpaceNameLowerException = assertThrows(NullPointerException.class, () -> {
			squareToTest.setSpaceName(invalidSpaceNameLower);
		});
		System.out.println(invalidSpaceNameLowerException.getMessage());

		// checks that the correct truncation happens
		String expected = "thisIsAnInvalidSpaceName1";
		squareToTest.setSpaceName(invalidSpaceNameUpper);
		assertEquals(expected, squareToTest.getSpaceName());
	}

	@Test
	void validCost() {
		// sets field ID to 1 as validation in place if the ID is 0.
		squareToTest.setFieldId(1);

		squareToTest.setCost(validCostLowerBoundary);
		assertEquals(validCostLowerBoundary, squareToTest.getCost());

		squareToTest.setCost(validCostLower);
		assertEquals(validCostLower, squareToTest.getCost());

		squareToTest.setCost(validCostMiddle);
		assertEquals(validCostMiddle, squareToTest.getCost());

		squareToTest.setCost(validCostUpper);
		assertEquals(validCostUpper, squareToTest.getCost());

		squareToTest.setCost(validCostUpperBoundary);
		assertEquals(validCostUpperBoundary, squareToTest.getCost());

		/*
		 * Testing validation of cost if field ID = 0. Cost should be set to 0 no matter
		 * the param.
		 */
		squareToTest.setFieldId(0);
		int expected = 0;

		squareToTest.setCost(validCostLowerBoundary);
		assertEquals(expected, squareToTest.getCost());

		squareToTest.setCost(validCostUpperBoundary);
		assertEquals(expected, squareToTest.getCost());
	}

	@Test
	void invalidCost() {
		squareToTest.setFieldId(1);
		Exception invalidCostLowerException = assertThrows(IllegalArgumentException.class, () -> {
			squareToTest.setCost(invalidCostLower);
		});
		System.out.println(invalidCostLowerException.getMessage());

		Exception invalidCostUpperException = assertThrows(IllegalArgumentException.class, () -> {
			squareToTest.setCost(invalidCostUpper);
		});
		System.out.println(invalidCostUpperException.getMessage());

		/*
		 * Cost of a field with an ID of 0 should be set to 0 no matter the parameter.
		 */
		squareToTest.setFieldId(0);
		int expected = 0;

		squareToTest.setCost(invalidCostLower);
		assertEquals(expected, squareToTest.getCost());

		squareToTest.setCost(invalidCostUpper);
		assertEquals(expected, squareToTest.getCost());

	}

	@Test
	void isOwned() {
		// test when property is not owned
		boolean expectedFalse = false;
		boolean actual = squareToTest.isOwned();
		assertEquals(expectedFalse, actual);

		/**
		 * Test when property is able to be owned, sets state to be ownable, creates
		 * validID to attempt purchase.
		 */
		squareToTest.setOwnable(true);

		boolean expectedTrue = true;
		squareToTest.bought(validPlayerIdLower);
		assertEquals(expectedTrue, squareToTest.isOwned());

	}

	@Test
	void validOwnerID() {

		squareToTest.setOwnerId(validPlayerIdLowerBoundary);
		assertEquals(validPlayerIdLowerBoundary, squareToTest.getOwnerId());

		squareToTest.setOwnerId(validPlayerIdLower);
		assertEquals(validPlayerIdLower, squareToTest.getOwnerId());

		squareToTest.setOwnerId(validPlayerIdMiddle);
		assertEquals(validPlayerIdMiddle, squareToTest.getOwnerId());

		squareToTest.setOwnerId(validPlayerIdUpperBoundary);
		assertEquals(validPlayerIdUpperBoundary, squareToTest.getOwnerId());

	}

	@Test
	void invalidOwnerID() {

		Exception invalidPlayerIdLowerException = assertThrows(IllegalArgumentException.class, () -> {
			squareToTest.setOwnerId(invalidPlayerIdLower);
		});
		System.out.println(invalidPlayerIdLowerException.getMessage());

		Exception invalidPlayerIdUpperException = assertThrows(IllegalArgumentException.class, () -> {
			squareToTest.setOwnerId(invalidPlayerIdUpper);
		});
		System.out.println(invalidPlayerIdUpperException.getMessage());

	}

	@Test
	void validConstructorArgs() {
		/*
		 * Testing the constructor with args with one set of data
		 */
		AreaBoard validSquareConstructorArgs = new AreaBoard(validSpaceNameLower, false, validFieldIdLower,
				validCostUpper);
		assertEquals(validSpaceNameLower, validSquareConstructorArgs.getSpaceName());
		assertEquals(false, validSquareConstructorArgs.isOwnable());
		assertEquals(validFieldIdLower, validSquareConstructorArgs.getFieldId());
		assertEquals(validCostUpper, validSquareConstructorArgs.getCost());

		/*
		 * Testing the constructor with args with a second set of data
		 */

		AreaBoard anotherValidSquareConstructorArgs = new AreaBoard(validSpaceNameMiddle, true, validFieldIdUpper,
				validCostMiddle);
		assertEquals(validSpaceNameMiddle, anotherValidSquareConstructorArgs.getSpaceName());
		assertEquals(true, anotherValidSquareConstructorArgs.isOwnable());
		assertEquals(validFieldIdUpper, anotherValidSquareConstructorArgs.getFieldId());
		assertEquals(validCostMiddle, anotherValidSquareConstructorArgs.getCost());
	}

	@Test
	void invalidConstructorArgs() {

		Exception invalidNameLowerConstructorArgs = assertThrows(NullPointerException.class, () -> {
			AreaBoard invalidConstructorArgs = new AreaBoard(invalidSpaceNameLower, false, validFieldIdLower,
					validCostLower);
		});
		System.out.println(invalidNameLowerConstructorArgs.getMessage());

		Exception invalidFieldIDLowerException = assertThrows(IllegalArgumentException.class, () -> {
			AreaBoard invalidConstructorArgs = new AreaBoard(validSpaceNameMiddle, false, invalidFieldIdLower,
					validCostLower);
		});
		System.out.println(invalidFieldIDLowerException.getMessage());

		Exception invalidFieldIDUpperException = assertThrows(IllegalArgumentException.class, () -> {
			AreaBoard invalidConstructorArgs = new AreaBoard(validSpaceNameLower, false, invalidFieldIdUpper,
					validCostLower);
		});
		System.out.println(invalidFieldIDUpperException.getMessage());

		Exception invalidCostLowerException = assertThrows(IllegalArgumentException.class, () -> {
			AreaBoard invalidConstructorArgs = new AreaBoard(validSpaceNameLower, false, invalidFieldIdUpper,
					invalidCostLower);
		});
		System.out.println(invalidCostLowerException.getMessage());

		Exception invalidCostUpperException = assertThrows(IllegalArgumentException.class, () -> {
			AreaBoard invalidConstructorArgs = new AreaBoard(validSpaceNameLower, false, validFieldIdMiddle,
					invalidCostUpper);
		});
		System.out.println(invalidCostUpperException.getMessage());

	}
}
