package game.files;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AreaBoardTesting {

	int minorUpgradeLowerBoundary;
	int minorUpgradeLower;
	int minorUpgradeHigher;
	int minorUpgradeHigherBoundary;
	int minorUpgradeInvalidLower;
	int minorUpgradeInvalidHigher;
	int majorUpgradeValid;
	int majorUpgradeInvalidLower;
	int majorUpgradeInvalidUpper;
	int playerIDLower;
	int playerIDLowerBoundary;
	int playerIDHigher;
	int playerIDHigherBoundary;
	int playerIDInvalidLower;
	int playerIDInvalidUpper;
	int fieldIDLower;
	int fieldIDLowerBoundary;
	int fieldIDHigher;
	int fieldIDHigherBoundary;
	int fieldIDInvalidLower;
	int fieldIDInvalidUpper;
	int costValidLowerBoundary;
	int costValidMiddle;
	int costValidUpperBoundary;
	int costInvalidLower;
	int costInvdalidUpper;
	boolean ownableTrue;
	boolean ownableFalse;
	String validSpaceName;
	AreaBoard abToTest;
	Player p;

	@BeforeEach
	void setUp() throws Exception {
		playerIDLower = 1;
		playerIDLowerBoundary = 2;
		playerIDHigher = 3;
		playerIDHigherBoundary = 4;
		playerIDInvalidLower = 0;
		playerIDInvalidUpper = 5;
		fieldIDLower = 2;
		fieldIDLowerBoundary = 0;
		fieldIDHigher = 3;
		fieldIDHigherBoundary = 4;
		fieldIDInvalidLower = -1;
		fieldIDInvalidUpper = 5;
		costValidLowerBoundary = 50;
		costValidMiddle = 75;
		costValidUpperBoundary = 80;
		costInvalidLower = 49;
		costInvdalidUpper = 81;
		ownableTrue = true;
		ownableFalse = false;
		validSpaceName = "validSpace";
		abToTest = new AreaBoard();
		p = new Player();
	}

	@Test
	void validFieldId() {
		abToTest.setFieldId(fieldIDLowerBoundary);
		assertEquals(fieldIDLowerBoundary, abToTest.getFieldId());
		
		abToTest.setFieldId(fieldIDLower);
		assertEquals(fieldIDLower, abToTest.getFieldId());
		
		abToTest.setFieldId(fieldIDHigher);
		assertEquals(fieldIDHigher, abToTest.getFieldId());
		
		abToTest.setFieldId(fieldIDHigherBoundary);
		assertEquals(fieldIDHigherBoundary, abToTest.getFieldId());
		
	}
	
	@Test
	void invalidFieldId() {
		
		Exception invalidLower = assertThrows(IllegalArgumentException.class, () -> {
			abToTest.setFieldId(fieldIDInvalidLower);
		});
		
		System.out.println(invalidLower.getMessage());
		Exception invalidUpper = assertThrows(IllegalArgumentException.class, () -> {
			abToTest.setFieldId(fieldIDInvalidUpper);
		});
		System.out.println(invalidUpper.getMessage());
		
	}
	
	@Test
	void validMinorUpgrade() {
		p.setMoney(1000);
		p.setPlayerId(1);
		ArrayList<AreaBoard> testArea = new ArrayList<AreaBoard>();
		BoardSetUp.setUpBoard(testArea);
		for (AreaBoard a : testArea) {
			a.setOwnerId(p.getPlayerId());
		}
		
		abToTest.buyMinorUpgrade(p);
		
		
	}
	
	@Test
	void invalidMinorUpgrade() {
		p.setMoney(10);
		abToTest.buyMinorUpgrade(p);
		
	}
	
	@Test
	void validMajorUpgrade() {
		p.setMoney(100000);
		p.setPlayerId(1);
		ArrayList<AreaBoard> testArea = new ArrayList<AreaBoard>();
		BoardSetUp.setUpBoard(testArea);
		
		for (int i = 0; i < 3; i++) {
			for (AreaBoard a : testArea) {
				a.setOwnerId(p.getPlayerId());
				a.buyMinorUpgrade(p);
			}
		}
			for (AreaBoard a : testArea) {
				a.buyMajorUpgrade(p);
			}
		}

	@Test
	void invalidMajorUpgrade() {
		p.setMoney(100000);
		p.setPlayerId(1);
		ArrayList<AreaBoard> testArea = new ArrayList<AreaBoard>();
		BoardSetUp.setUpBoard(testArea);
		
		for (AreaBoard a : testArea) {
			a.buyMajorUpgrade(p);
		}
	}	
	@Test
	void validCost() {
		abToTest.setFieldId(1);
		
		abToTest.setCost(costValidLowerBoundary);
		assertEquals(costValidLowerBoundary, abToTest.getCost());
		
		abToTest.setCost(costValidMiddle);
		assertEquals(costValidMiddle, abToTest.getCost());
		
		abToTest.setCost(costValidUpperBoundary);
		assertEquals(costValidUpperBoundary, abToTest.getCost());
		

		
	}
	
	@Test
	void invalidCost() {
		
		abToTest.setFieldId(1);
		
		Exception invalidLower = assertThrows(IllegalArgumentException.class, () -> {
			abToTest.setCost(costInvalidLower);
		});
		
		System.out.println(invalidLower.getMessage());
		Exception invalidUpper = assertThrows(IllegalArgumentException.class, () -> {
			abToTest.setCost(costInvdalidUpper);
		});
		System.out.println(invalidUpper.getMessage());
	
		
	}
	
	@Test
	void ownable() {
		abToTest.setOwnable(ownableTrue);
		assertEquals(ownableTrue, abToTest.isOwnable());
		
		abToTest.setOwnable(ownableFalse);
		assertEquals(ownableFalse, abToTest.isOwnable());
		
	}
	
	@Test
	void validConstructor() {
	
		AreaBoard validConstuctor = new AreaBoard(validSpaceName, ownableTrue, fieldIDHigher, costValidMiddle);
		assertEquals(validSpaceName, validConstuctor.getSpaceName());
		assertEquals(ownableTrue, validConstuctor.isOwnable());
		assertEquals(fieldIDHigher, validConstuctor.getFieldId());
		assertEquals(costValidMiddle, validConstuctor.getCost());
	}
	
	@Test
	void invalidConstructor() {
		
		Exception invalidFieldID = assertThrows(IllegalArgumentException.class, () -> {
			AreaBoard invalidConstuctor = new AreaBoard(validSpaceName, ownableTrue, fieldIDInvalidLower, costValidMiddle);
		});
		System.out.println(invalidFieldID);
		
		Exception invalidCost = assertThrows(IllegalArgumentException.class, () -> {
			
			AreaBoard invalidConstuctor = new AreaBoard(validSpaceName, ownableTrue, fieldIDHigher, costInvdalidUpper);
		});
		System.out.println(invalidCost);
	}
	
	
}
