package personnage;

import static org.junit.Assert.*;
import object.ObjectI;
import object.ObjectImpl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import contract.ContractError;

public class PersonnageContratTest {

	PersonnageContrat p;
	
	@Rule
    public ExpectedException exception = ExpectedException.none();

	
	@Before
	public void setUp() throws Exception {
		p = new PersonnageContrat(new PersonnageImpl("m",10,10,10,10));
	}
	

	@Test
	public void test1(){
		exception.expect(ContractError.class);
		p.init("", 1, 1, 1, 1);			
	}
	
	@Test
	public void test2() {
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
	public void test3(){
		exception.expect(ContractError.class);
		p.init("m", 1, 1, 1, 0);			
	}
	
	@Test
	public void test4(){
		exception.expect(ContractError.class);
		p.init("m", 1, 1, 1, -1);			
	}
	@Test
	public void  test5(){
		exception.expect(ContractError.class);
		int hpAvant = p.getHp();
		p.depotsHP(5);
		assertTrue(100 == p.getHp());
	}
	
	@Test
	public void  test6(){
		p.retraitHP(50);
		int hpAvant = p.getHp();
		p.depotsHP(5);
		assertTrue((hpAvant+5) == p.getHp());
	}
	
	@Test
	public void  test7(){
		int hpAvant = p.getHp();
		exception.expect(ContractError.class);
		p.depotsHP(-5);
	}
	
	@Test
	public void  test8(){
		exception.expect(ContractError.class);
		int hpAvant = p.getHp();
		p.depotsHP(5);
		assertTrue((hpAvant+5) == p.getHp());
	}
	
	@Test
	public void  test9(){
		int hpAvant = p.getHp();
		p.retraitHP(5);
		assertTrue(hpAvant == p.getHp()+5);
	}
	
	@Test
	public void  test10(){
		exception.expect(ContractError.class);
		p.retraitHP(-5);
	}
	
	
	
	@Test
	public 	void test11(){
		int money = p.getMoney();
		p.depotsMoney(5);
		assertTrue(money+5 == p.getMoney());
	}
	
	@Test
	public 	void test12(){
		int money = p.getMoney();
		exception.expect(ContractError.class);
		p.depotsMoney(-5);
	}
	
	@Test
	public 	void test13(){
		exception.expect(ContractError.class);
		int money = p.getMoney();
		p.retraitMoney(5);
		assertTrue(money-5 == p.getMoney());
	}
	
	@Test
	public 	void test14(){
		p.depotsMoney(50);
		int money = p.getMoney();
		p.retraitMoney(5);
		assertTrue(money-5 == p.getMoney());
	}
	
	@Test
	public 	void test15(){
		int money = p.getMoney();
		exception.expect(ContractError.class);
		p.retraitMoney(-5);
		assertFalse(money == p.getMoney());
	}
	
	
	@Test
	public void test16(){
		p.ramasser(new ObjectImpl(null, null, 0));
		p.jeter();
		assertTrue(p.getObject() == null);
		assertTrue(p.equiped());
	}
	
	
	@Test
	public void test17(){
		ObjectI o = new ObjectImpl(null, null, 0);
		p.ramasser(o);
		assertTrue(p.getObject() == o);
		assertTrue(p.equiped());
	}
	
}
