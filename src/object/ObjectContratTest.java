package object;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import contract.ContractError;

public class ObjectContratTest {

	@Rule
    public ExpectedException exception = ExpectedException.none();


	@Test
	public void test() {
		ObjectContrat obj = new ObjectContrat( new ObjectImpl("l",Type.Sellable,10));
		assertTrue(obj.getType()==Type.Sellable);
		assertTrue(obj.getNom()=="l");
		assertTrue(obj.getValue()==10);
		assertTrue(obj.getPower()==0);
	}
	
	@Test
	public void test2() {
		ObjectContrat obj = new ObjectContrat(new ObjectImpl("l",Type.Usable,10));
		assertTrue(obj.getType()==Type.Usable);
		assertTrue(obj.getNom()=="l");
		assertTrue(obj.getValue()==0);
		assertTrue(obj.getPower()==10);
	}
	
	@Test
	public void test3(){
		exception.expect(ContractError.class);
		ObjectContrat obj = new ObjectContrat(new ObjectImpl("",Type.Usable,10));
		obj.init("", Type.Usable, 10);
	}
	
	@Test
	public void test4(){
		exception.expect(ContractError.class);
		ObjectContrat obj = new ObjectContrat(new ObjectImpl("l",Type.Usable,-10));
		obj.init("m", Type.Usable, -10);
	}
	
	@Test
	public void test5(){
		exception.expect(ContractError.class);
		ObjectContrat obj = new ObjectContrat(new ObjectImpl("l",Type.Usable,0));
		obj.init("m", Type.Usable, 0);
	}
}
