package game.files;

import java.util.ArrayList;

public class TestUpgrades {

	public static void main(String[] args) {

		ArrayList<AreaBoard> a = new ArrayList<AreaBoard>();

		AreaBoard t1 = new AreaBoard("Bob", true, 1, 20);
		AreaBoard t2 = new AreaBoard("John", true, 1, 20);

		a.add(t1);
		a.add(t2);
		a.get(0).setOwnerId(1);
		a.get(1).setOwnerId(1);

		System.out.println(CheckOwnershipUtility.ownsFieldOne(a, 1, 1));
	}
}
