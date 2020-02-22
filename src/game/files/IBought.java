package game.files;

import java.util.ArrayList;

/**
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
