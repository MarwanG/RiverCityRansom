package statuswrapper;

import static org.junit.Assert.*;
import gestionCombat.Commande;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import contract.ContractError;

import personnage.PersonnageI;
import personnage.PersonnageImpl;

public class StatusWrapperContratTest {
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	StatusWrapperI c;
	PersonnageI p;

	@Before
	public void setUp() throws Exception {
		p = new PersonnageImpl("jack", 10, 10, 10, 10);
		c = new StatusWrapperContrat(new StatusWrapperImpl(
				p, 1, 1, 1, Commande.DOWN));
	}

	@Test
	public void testInit() {
		assertTrue(c != null); //test ok;
		assertTrue(c.getX()==1);
		assertTrue(c.getY()==1);
		assertTrue(c.getZ()==1);
		assertTrue(c.freeze()==0);
		assertTrue(c.getDirection()==Commande.DOWN);
		assertTrue(c.getPerso() == p);
		
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
	
	@Test
	public void testSetXFalse(){
		exception.expect(ContractError.class);
		c.setX(-1);	
	}
	
	@Test
	public void testSetYFalse(){
		exception.expect(ContractError.class);
		c.setY(-1);	
	}
	
	@Test
	public void testSetZFalse(){
		exception.expect(ContractError.class);
		c.setZ(-1);	
	}
	
	@Test
	public void testSetFreezeFalse(){
		exception.expect(ContractError.class);
		c.setFreeze(-1);	
	}
	
	@Test
	public void testSetDirectionFalse(){
		exception.expect(ContractError.class);
		c.setDirection(Commande.JUMP_RIGHT);	
	}
	
	@Test
	public void testbadInit1(){
		exception.expect(ContractError.class);
		c = new StatusWrapperContrat(new StatusWrapperImpl(p, -1, 1, 1, Commande.DOWN));

	}
	
	@Test
	public void testbadInit2(){
		exception.expect(ContractError.class);
		c = new StatusWrapperContrat(new StatusWrapperImpl(p, 1, -1, 1, Commande.DOWN));

	}
	
	@Test
	public void testbadInit3(){
		exception.expect(ContractError.class);
		c = new StatusWrapperContrat(new StatusWrapperImpl(p, 1, 1, -1, Commande.DOWN));

	}
	
	@Test
	public void testbadInit4(){
		exception.expect(ContractError.class);
		c = new StatusWrapperContrat(new StatusWrapperImpl(p, 1, 1, 1, Commande.JUMP_DOWN));

	}
	
	@Test
	public void testbadInit5(){
		exception.expect(ContractError.class);
		c = new StatusWrapperContrat(new StatusWrapperImpl(null, 1, 1, 1, Commande.DOWN));
	}
	
	


}
