package bloc;

import object.ObjectI;

public interface BlocI {

	public void init(boolean b,ObjectI obj);		//object needs to be converted once we create our service obj.
	
	public boolean isEmpty();
	
	public boolean isPit();
	
	public boolean hasTreasure();
	
	public ObjectI getTreasure();
	
	public ObjectI removeTreasure();
	
}
