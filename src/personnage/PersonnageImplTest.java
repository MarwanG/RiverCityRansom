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
		assertFalse(!p.equiped());
		assertFalse(!p.youDeadMan());
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
	public void  addHp()
}
