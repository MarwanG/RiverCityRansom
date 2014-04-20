package terrain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bloc.BlocI;
import bloc.BlocImpl;

public class TerrainImplTest {


	@Test
	public void testInit() {
		TerrainI t = new TerrainImpl(1, 1, 1);
		assertTrue(t.getLength() ==1);
		assertTrue(t.getHeight() ==1);
		assertTrue(t.getWidth() ==1);
	}

	@Test
	public void testSetBlocCoord() {
		TerrainI t = new TerrainImpl(1, 1, 1);
		BlocI b = new BlocImpl(false, null);
		t.setBlocCoord(0, 0, 0, b);
		assertTrue(t.getBlocCoord(0,0,0) == b);
	}

}
