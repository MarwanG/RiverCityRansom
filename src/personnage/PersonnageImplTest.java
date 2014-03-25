package personnage;

import static org.junit.Assert.*;

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
		assert(p.getNom().equals("m"));
		assert(p.getForce() == 10);
		assert(p.getLargeur() == 10);
		assert(p.getHauteur() == 10);
		assert(p.getProfondeur() == 10);
		assertFalse(p.equiped());
		assertFalse(p.youDeadMan());
		assert(p.getMoney() == 0);
		assert(p.getHp() == 100);
		assert(p.getObject() == null);		
	}

	@Test
	public void initNegative(){
		PersonnageI p = new PersonnageImpl("",10,10,10,10);
		assert(p == null);
	}
	
	@Test
	public void initNegative2(){
		PersonnageI p = new PersonnageImpl("m",10,10,10,-10);
		assert(p == null);
	}
	
	@Test
	public void  addHp(){
		int hpAvant = p.getHp();
		p.depotsHP(5);
		assert(hpAvant+5 == p.getHp());
	}
	
	@Test
	public void  addHpNeg(){
		int hpAvant = p.getHp();
		p.depotsHP(-5);
		assertFalse(hpAvant+5 == p.getHp());
	}
	
	@Test
	public void  removeHp(){
		int hpAvant = p.getHp();
		p.retraitHP(5);
		assert(hpAvant == p.getHp()+5);
	}
	
	@Test
	public void  removeHpNeg(){
		int hpAvant = p.getHp();
		p.retraitHP(-5);
		assert(hpAvant == p.getHp());
	}
	
	
	
	@Test
	public 	void depotMoney(){
		int money = p.getMoney();
		p.depotsMoney(5);
		assert(money+5 == p.getMoney());
	}
	
	@Test
	public 	void depotMoneyNeg(){
		int money = p.getMoney();
		p.depotsMoney(-5);
		assertFalse(money+5 == p.getMoney());
	}
	
	@Test
	public 	void retraitMoney(){
		int money = p.getMoney();
		p.retraitMoney(5);
		assert(money+5 == p.getMoney());
	}
	
	@Test
	public 	void retraitMoneyNeg(){
		int money = p.getMoney();
		p.retraitMoney(-5);
		assertFalse(money == p.getMoney());
	}
	
	
	@Test
	public void jeter(){
		p.ramasser(new Object());
		p.jeter();
		assert(p.getObject() == null);
		assert(p.equiped());
	}
	
	
	@Test
	public void ramasser(){
		Object o = new Object();
		p.ramasser(o);
		assert(p.getObject() == o);
		assert(p.equiped());
	}
	
}
