package moteurDeJeu;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoteurDeJeuImplTest {

	@Test
	public void testInit() {
		MoteurDeJeuI mj = new MoteurDeJeuImpl(12, 1, 12);
		assertTrue(mj.combat() != null);
		assertFalse(mj.isFinished());
	}

}
