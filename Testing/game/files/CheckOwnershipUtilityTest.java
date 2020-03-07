package game.files;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckOwnershipUtilityTest {

	
	
	ArrayList<AreaBoard> theBoard = new ArrayList<AreaBoard>();
	

	@BeforeEach
	void setUp() throws Exception {
	BoardSetUp.setUpBoard(theBoard);
		
	}

	//Checks that player can own entire field
	@Test
	void testOwnsField() {
		theBoard.get(1).setOwnerId(1);
		theBoard.get(2).setOwnerId(1);
		assertTrue(CheckOwnershipUtility.doesPlayerOwnField(theBoard, 1, 1));
	}
	
	//Checks that player doesn't own entire field
		@Test
		void testDoesntOwnsField() {
			theBoard.get(1).setOwnerId(1);
			theBoard.get(2).setOwnerId(2);
			assertFalse(CheckOwnershipUtility.doesPlayerOwnField(theBoard, 1, 1));
		}
		
	//Checks that player is charged when stepping on a area they don't own
			@Test
			void testChargePlayer() {
				Player p = new Player(1, "Bob", 100, 1);
				Player b = new Player(2, "Tob", 100, 0);
				
				ArrayList<Player> playerArray = new ArrayList<Player>();
				
				playerArray.add(p);
				playerArray.add(b);
				
				theBoard.get(1).bought(1, playerArray);
				
				
				CheckOwnershipUtility.chargePlayer(theBoard,playerArray,0);
				
				int expected = 95;
				
				assertEquals(expected, playerArray.get(0).getMoney());
				}

}
