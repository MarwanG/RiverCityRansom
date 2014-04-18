package statuswrapper;

import static org.junit.Assert.*;
import gestionCombat.Commande;

import org.junit.Before;
import org.junit.Test;

import personnage.PersonnageI;
import personnage.PersonnageImpl;

public class StatusWrapperImplTest {

	StatusWrapperI sw;
	PersonnageI p;
	@Before
	public void setUp() throws Exception {
		p = new PersonnageImpl("jack", 1, 1, 1, 12);
		sw = new StatusWrapperImpl(p, 1, 2, 3, Commande.UP);
	}

	@Test
	public void testInit() {
		assertTrue(sw.getX()==1);
		assertTrue(sw.getY()==2);
		assertTrue(sw.getZ()==3);
		assertTrue(sw.freeze()==0);
		assertTrue(sw.getDirection()==Commande.UP);
		assertTrue(sw.getPerso()==p);
		assertFalse(sw.isFrozen());
	}
	
	@Test
	public void testSetters(){
		sw.setX(12);
		assertTrue(sw.getX()==12);
		sw.setY(22);
		assertTrue(sw.getY()==22);
		sw.setZ(33);
		assertTrue(sw.getZ()==33);
		sw.setFreeze(3);
		assertTrue(sw.freeze()==3);
		sw.setDirection(Commande.DOWN);
		assertTrue(sw.getDirection()==Commande.DOWN);
		assertTrue(sw.isFrozen());
	}
	
	@Test
	public void testDecFreeze(){
		sw.setFreeze(2);
		assertTrue(sw.freeze()==2);
		sw.decFreeze();
		assertTrue(sw.freeze()==1);
		sw.decFreeze();
		assertTrue(sw.freeze()==0);
		sw.decFreeze();
		assertTrue(sw.freeze()==0);
	}

}
