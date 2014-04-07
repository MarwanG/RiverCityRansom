package terrain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import bloc.BlocI;
import bloc.BlocImpl;


public class TerrainImplTest {
	
	List<BlocI> blocs;
	
	@Before
	public void createBlocs(){
		blocs = new ArrayList<BlocI>(3);
		blocs.add(new BlocImpl(false, null));
		blocs.add(new BlocImpl(true, null));
		blocs.add(new BlocImpl(true, null));
	}

	@Test
	public void initTest()
	{
		TerrainI ter = new TerrainImpl(3, 1, 1, blocs);
		assertTrue(ter.getWidth() == 3);
		assertTrue(ter.getHeight() == 1);
		assertTrue(ter.getDepth() == 1);
		Iterator<BlocI> it1 = ter.getBlocList().iterator();
		Iterator<BlocI> it2 = blocs.iterator();
		
		assertTrue(it1.hasNext() == it2.hasNext());
		while(it1.hasNext() && it2.hasNext()){
			assertTrue(it1.next() == it2.next());
			assertTrue(it1.hasNext() == it2.hasNext());
		}
			
	}
	
	@Test
	public void testGetBlocCoord() {
		TerrainI ter = new TerrainImpl(3, 1, 1, blocs);
		assertTrue(ter.getBlocCoord(0, 0, 0) == blocs.get(0));
		assertTrue(ter.getBlocCoord(1, 0, 0) == blocs.get(1));
		assertTrue(ter.getBlocCoord(2, 0, 0) == blocs.get(2));
	}

	@Test
	public void testSetBlocCoord() {
		TerrainI ter = new TerrainImpl(3, 1, 1, blocs);
		BlocI newBloc = new BlocImpl(false, null);
		BlocI oldBloc1 = ter.getBlocCoord(0, 0, 0);
		BlocI oldBloc2 = ter.getBlocCoord(1, 0, 0);
		BlocI oldBloc3 = ter.getBlocCoord(2, 0, 0);
		
		ter.setBlocCoord(0, 0, 0, newBloc);
		
		assertTrue(ter.getBlocCoord(0, 0, 0) == newBloc && ter.getBlocCoord(0, 0, 0) != oldBloc1);
		assertTrue(ter.getBlocCoord(1, 0, 0)!= newBloc && ter.getBlocCoord(1, 0, 0) == oldBloc2);
		assertTrue(ter.getBlocCoord(2,0,0) != newBloc && ter.getBlocCoord(2, 0, 0) == oldBloc3);

	}
	

}
