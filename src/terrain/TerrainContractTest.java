package terrain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import contract.ContractError;

public class TerrainContractTest {
	
	@Rule
    public ExpectedException exception = ExpectedException.none();

	@Test
	public void testInit() {
		TerrainI t = new TerrainContract(new TerrainImpl(5, 5, 5));
		assertTrue(t.getLength() ==5);
		assertTrue(t.getHeight() ==5);
		assertTrue(t.getWidth() ==5);
	}
	
	@Test
	public void testInitFail() {
		exception.expect(ContractError.class);
		TerrainI t = new TerrainContract(new TerrainImpl(0, 0, 0));
		
	}
	@Test
	public void testInitFail2() {
		exception.expect(ContractError.class);
		TerrainI t = new TerrainContract(new TerrainImpl(5, 0, 0));
	}
	
	@Test
	public void testInitFail3() {
		exception.expect(ContractError.class);
		TerrainI t = new TerrainContract(new TerrainImpl(5, 5, 0));
	}

}
