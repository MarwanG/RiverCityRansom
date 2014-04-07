package bloc;

import static org.junit.Assert.*;
import object.ObjectI;
import object.ObjectImpl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import contract.ContractError;

public class BlocContratTest {

	@Rule
    public ExpectedException exception = ExpectedException.none();

	
	@Test
	public void test1() {
		BlocI b = new BlocContract(new BlocImpl(true,null));
		assertTrue(b.isEmpty());
		assertFalse(b.isPit());
		assertFalse(b.hasTreasure());
		assertTrue(b.getTreasure() == null);
	}
	
	@Test
	public void test2() {
		BlocI b = new BlocContract(new BlocImpl(false,null));
		assertFalse(b.isEmpty());
		assertTrue(b.isPit());
		assertFalse(b.hasTreasure());
		assertTrue(b.getTreasure() == null);
	}
	
	@Test
	public void test3() {
		ObjectI obj = new ObjectImpl(null, null, 0); //TODO
		BlocI b = new BlocContract(new BlocImpl(true,obj));
		assertTrue(b.isEmpty());
		assertFalse(b.isPit());
		assertTrue(b.hasTreasure());
		assertFalse(b.getTreasure() == null);
		assertTrue(b.getTreasure() == obj);
	}
	
	@Test
	public void test4() {
		exception.expect(ContractError.class);
		BlocI b = new BlocContract(new BlocImpl(true,null));
		b.removeTreasure();
		assertFalse(b.hasTreasure());
		assertTrue(b.getTreasure() == null);
	}
	
	@Test
	public void test5() {
		exception.expect(ContractError.class);
		ObjectI obj = new ObjectImpl(null, null, 0);//TODO
		BlocI b = new BlocContract(new BlocImpl(true,obj));
		Object tmp = b.removeTreasure();
		assertTrue(tmp == obj);
		assertFalse(b.hasTreasure());
		assertTrue(b.getTreasure() == null);
	}

	

}
