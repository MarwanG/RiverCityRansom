package gestionCombat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Commande {
	UP,DOWN,LEFT,RIGHT, JUMP_UP,JUMP_DOWN,JUMP_LEFT,JUMP_RIGHT,KICK,THROW, PICKUP;
	
	private static final List<Commande> VALUES =
		    Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static Commande randomCmd()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
