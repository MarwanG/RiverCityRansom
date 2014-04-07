package terrain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import contract.ContractError;
import bloc.BlocI;
import bloc.BlocImpl;

public class TerrainContractTest {

	List<BlocI> blocs;
	TerrainI ter;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void createBlocs(){
		blocs = new ArrayList<BlocI>(3);
		blocs.add(new BlocImpl(false, null));
		blocs.add(new BlocImpl(true, null));
		blocs.add(new BlocImpl(true, null));
		ter = new TerrainContract(new TerrainImpl(3, 1, 1, blocs));
	}


	
	@Test
	public void initTest()
	{
		TerrainI ter = new TerrainContract(new TerrainImpl(3, 1, 1, blocs));
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
	public void initFail1(){
		exception.expect(ContractError.class);
		ter.init(0, 1, 1, blocs);
	}
	
	@Test
	public void initFail1b(){
		exception.expect(ContractError.class);
		ter.init(0, 1, 1, null);
	}
	
	@Test
	public void initFail2(){
		exception.expect(ContractError.class);
		ter.init(1, 0, 1, blocs);
	}
	
	@Test
	public void initFail2b(){
		exception.expect(ContractError.class);
		ter.init(1, 0, 1, null);
	}
	
	@Test
	public void initFail3(){
		exception.expect(ContractError.class);
		ter.init(1, 1, 0, blocs);
	}
	
	@Test
	public void initFail3b(){
		exception.expect(ContractError.class);
		ter.init(1, 1, 0, null);
	}
	
	@Test
	public void initFail4(){
		exception.expect(ContractError.class);
		ter.init(0, 0, 1, blocs);
	}
	
	@Test
	public void initFail4b(){
		exception.expect(ContractError.class);
		ter.init(0, 0, 1, null);
	}
	
	@Test
	public void initFail5(){
		exception.expect(ContractError.class);
		ter.init(1, 0, 0, blocs);
	}
	
	@Test
	public void initFail5b(){
		exception.expect(ContractError.class);
		ter.init(1, 0, 0, null);
	}
	
	@Test
	public void initFail6(){
		exception.expect(ContractError.class);
		ter.init(0, 1, 0, blocs);
	}
	
	@Test
	public void initFail6b(){
		exception.expect(ContractError.class);
		ter.init(0, 1, 0, null);
	}
	
	@Test
	public void initFail7(){
		exception.expect(ContractError.class);
		ter.init(0, 0, 0, blocs);
	}
	
	@Test
	public void initFail7b(){
		exception.expect(ContractError.class);
		ter.init(0, 0, 0, null);
	}
	
	
	@Test
	public void testGetBlocCoord() {
		TerrainI ter =  new TerrainContract(new TerrainImpl(3, 1, 1, blocs));
		assertTrue(ter.getBlocCoord(0, 0, 0) == blocs.get(0));
		assertTrue(ter.getBlocCoord(1, 0, 0) == blocs.get(1));
		assertTrue(ter.getBlocCoord(2, 0, 0) == blocs.get(2));
	}
	
	@Test
	public void testGetBlocCoordFail1() {
		exception.expect(ContractError.class);
		ter.getBlocCoord(-1, 0, 0);
	}
	
	@Test
	public void testGetBlocCoordFail1b() {
		exception.expect(ContractError.class);
		ter.getBlocCoord(3, 0, 0);
	}
	
	@Test
	public void testGetBlocCoordFail2() {
		exception.expect(ContractError.class);
		ter.getBlocCoord(0, -1, 0);
	}
	
	@Test
	public void testGetBlocCoordFail2b() {
		exception.expect(ContractError.class);
		ter.getBlocCoord(0, 14, 0);
	}
	
	@Test
	public void testGetBlocCoordFail3() {
		exception.expect(ContractError.class);
		ter.getBlocCoord(0, 0, -1);
	}
	
	@Test
	public void testGetBlocCoordFail3b() {
		exception.expect(ContractError.class);
		ter.getBlocCoord(0, 0, 15);
	}
	
	@Test
	public void testGetBlocCoordFail4() {
		exception.expect(ContractError.class);
		ter.getBlocCoord(-1, -1, 0);
	}
	
	@Test
	public void testGetBlocCoordFail4b() {
		exception.expect(ContractError.class);
		ter.getBlocCoord(15, 15, 0);
	}
	
	@Test
	public void testGetBlocCoordFail5() {
		exception.expect(ContractError.class);
		ter.getBlocCoord(0, -1, -1);
	}
	
	@Test
	public void testGetBlocCoordFail5b() {
		exception.expect(ContractError.class);
		ter.getBlocCoord(0, 15, 15);
	}
	
	@Test
	public void testGetBlocCoordFail6() {
		exception.expect(ContractError.class);
		ter.getBlocCoord(-1, -1, -1);
	}
	
	@Test
	public void testGetBlocCoordFail6b() {
		exception.expect(ContractError.class);
		ter.getBlocCoord(15, 15, 15);
	}
	
	

	@Test
	public void testSetBlocCoord() {
		TerrainI ter =  new TerrainContract(new TerrainImpl(3, 1, 1, blocs));
		BlocI newBloc = new BlocImpl(false, null);
		BlocI oldBloc1 = ter.getBlocCoord(1, 0, 0);
		BlocI oldBloc2 = ter.getBlocCoord(2, 0, 0);
		BlocI oldBloc3 = ter.getBlocCoord(3, 0, 0);
		
		ter.setBlocCoord(1, 0, 0, newBloc);
		
		assertTrue(ter.getBlocCoord(1, 0, 0) == newBloc && ter.getBlocCoord(1, 0, 0) != oldBloc1);
		assertTrue(ter.getBlocCoord(2, 0, 0)!= newBloc && ter.getBlocCoord(2, 0, 0) == oldBloc2);
		assertTrue(ter.getBlocCoord(3,0,0) != newBloc && ter.getBlocCoord(3, 0, 0) == oldBloc3);

	}
	

}
