package statuswrapper;

import static org.junit.Assert.*;
import gestionCombat.Commande;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import personnage.PersonnageImpl;

public class StatusWrapperContratTest {
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	StatusWrapperI c;

	@Before
	public void setUp() throws Exception {
		c = new StatusWrapperContrat(new StatusWrapperImpl(
				new PersonnageImpl("jack", 10, 10, 10, 10), 1, 1, 1, Commande.DOWN));
	}

	@Test
	public void testInit() {
		assertTrue(c != null); //test ok;
	}

	
	@Test
	public void testSetXYZFREEZECIR() {
		c.setX(3);
		assertTrue(c.getX() == 3);
		
		c.setY(4);
		assertTrue(c.getY() == 4);
		
		c.setZ(5);
		assertTrue(c.getZ() == 5);
		
		c.setFreeze(3);
		assertTrue(c.freeze() == 3);
		
		c.setDirection(Commande.UP);
		assertTrue(c.getDirection() == Commande.UP);
	}


	@Test
	public void testDecFreeze() {
		c.setFreeze(1);
		
		c.decFreeze();
		assertTrue(c.freeze()==0);
		c.decFreeze();
		assertTrue(c.freeze()==0);
	}
	
	


}
