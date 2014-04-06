package bloc;

public interface BlocI {

	public void init(boolean b,Object obj);		//object needs to be converted once we create our service obj.
	
	public boolean isEmpty();
	
	public boolean isPit();
	
	public boolean hasTreasure();
	
	public Object getTreasure();
	
	public Object removeTreasure();
	
}
