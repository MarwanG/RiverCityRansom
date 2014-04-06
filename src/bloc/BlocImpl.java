package bloc;

public class BlocImpl implements BlocI {
	
	private boolean empty;
	private boolean hasTreasure;
	private Object Treasure;
	
	
	
	public BlocImpl(boolean b,Object obj){
		init(b,obj);
	}
	
	@Override
	public void init(boolean b, Object obj) {
		empty = b;
		if(obj != null){
			Treasure = obj;
			hasTreasure = true;
		}else{
			Treasure = null;
			hasTreasure = false;	
		}
	}

	@Override
	public boolean isEmpty() {
		return empty;
	}

	@Override
	public boolean isPit() {
		return !empty;
	}

	@Override
	public boolean hasTreasure() {
		return hasTreasure;
	}

	@Override
	public Object getTreasure() {
		return Treasure;
	}

	@Override
	public Object removeTreasure() {
		hasTreasure = false;
		Object obj = Treasure;
		Treasure = null;
		return obj;
	}
	
}
