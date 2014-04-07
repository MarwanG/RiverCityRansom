package object;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ObjectImplTest {


	@Test
	public void test() {
		ObjectImpl obj = new ObjectImpl("l",Type.Sellable,10);
		assertTrue(obj.getType()==Type.Sellable);
		assertTrue(obj.getNom()=="l");
		assertTrue(obj.getValue()==10);
		assertTrue(obj.getPower()==0);
	}
	
	@Test
	public void test2() {
		ObjectImpl obj = new ObjectImpl("l",Type.Usable,10);
		assertTrue(obj.getType()==Type.Usable);
		assertTrue(obj.getNom()=="l");
		assertTrue(obj.getValue()==0);
		assertTrue(obj.getPower()==10);
	}

}
