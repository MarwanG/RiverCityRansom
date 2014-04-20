package personnage;

import static org.junit.Assert.*;
import object.ObjectI;
import object.ObjectImpl;

import org.junit.Before;
import org.junit.Test;

public class PersonnageImplTest {

	PersonnageI p;
	
	@Before
	public void setUp() throws Exception {
		p = new PersonnageImpl("m",10,10,10,10);
		
	}

	@Test
	public void initPositive(){
		assertTrue(p.getNom().equals("m"));
		assertTrue(p.getForce() == 10);
		assertTrue(p.getLargeur() == 10);
		assertTrue(p.getHauteur() == 10);
		assertTrue(p.getProfondeur() == 10);
		assertFalse(p.equiped());
		assertFalse(p.youDeadMan());
		assertTrue(p.getMoney() == 0);
		assertTrue(p.getHp() == 100);
		assertTrue(p.getObject() == null);		
	}

	
	@Test
	public void  addHp(){
		int hpAvant = p.getHp();
		p.depotsHP(5);
		assertTrue(100 == p.getHp());
	}
	
	@Test
	public void  addHp2(){
		p.retraitHP(50);
		int hpAvant = p.getHp();
		p.depotsHP(5);
		assertTrue((hpAvant+5) == p.getHp());
	}
	
	@Test
	public void  removeHp(){
		int hpAvant = p.getHp();
		p.retraitHP(5);
		assertTrue(hpAvant == p.getHp()+5);
	}
	
	@Test
	public 	void depotMoney(){
		int money = p.getMoney();
		p.depotsMoney(5);
		assertTrue(money+5 == p.getMoney());
	}
	
	@Test
	public 	void retraitMoney(){
		p.depotsMoney(50);
		int money = p.getMoney();
		assertTrue(money>5);
		p.retraitMoney(5);
		assertTrue(p.getMoney() == money-5);
	}
	
	@Test
	public void jeter(){
		p.ramasser(new ObjectImpl(null, null, 0));
		p.jeter();
		assertTrue(p.getObject() == null);
		assertFalse(p.equiped());
	}
	
	@Test
	public void ramasser(){
		ObjectI o = new ObjectImpl(null, null, 0);
		p.ramasser(o);
		assertTrue(p.getObject() == o);
		assertTrue(p.equiped());
	}
	
}
