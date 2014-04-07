package bloc;

import static org.junit.Assert.*;

import object.ObjectI;
import object.ObjectImpl;

import org.junit.Before;
import org.junit.Test;

import personnage.PersonnageI;
import personnage.PersonnageImpl;

public class BlocImplTest {

	
	
	@Test
	public void test1() {
		BlocI b = new BlocImpl(true,null);
		assert(b.isEmpty());
		assertFalse(b.isPit());
		assertFalse(b.hasTreasure());
		assert(b.getTreasure() == null);
	}
	
	@Test
	public void test2() {
		BlocI b = new BlocImpl(false,null);
		assertFalse(b.isEmpty());
		assert(b.isPit());
		assertFalse(b.hasTreasure());
		assert(b.getTreasure() == null);
	}
	
	@Test
	public void test3() {
		ObjectI obj = new ObjectImpl(null, null, 0, 0); //TODO
		BlocI b = new BlocImpl(true,obj);
		assert(b.hasTreasure());
		assertFalse(b.getTreasure() == null);
		assert(b.getTreasure() == obj);
	}
	
	@Test
	public void test4() {
		BlocI b = new BlocImpl(true,null);
		b.removeTreasure();
		assertFalse(b.hasTreasure());
		assert(b.getTreasure() == null);
	}
	
	@Test
	public void test5() {
		ObjectI obj = new ObjectImpl(null, null, 0, 0);//TODO
		BlocI b = new BlocImpl(true,obj);
		Object tmp = b.removeTreasure();
		assert(tmp == obj);
		assertFalse(b.hasTreasure());
		assert(b.getTreasure() == null);
	}
	
}
