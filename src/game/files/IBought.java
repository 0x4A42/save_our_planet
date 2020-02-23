package game.files;

import java.util.ArrayList;

/**
 * CSC7053-1920-G2: Jordan Brown (40282125), Ricards Estemirovs (40126945),
 * Rebekah Logan (40059637), Catherine McGuckin (40105486)
 * 
 * This interface, when implemented, will contain a method that will determine
 * if a property has been bought or not.
 * 
 * @author v2.0 - 2.2 Ricards (Initial class creation)
 * @author v2.3 - Jordan (updating of documentation)
 *
 */
public interface IBought {

	public void bought(int currentPlayer, ArrayList<Player> playerArray);
}
