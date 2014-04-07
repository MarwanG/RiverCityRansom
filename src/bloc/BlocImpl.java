package bloc;

import object.ObjectI;

public class BlocImpl implements BlocI {
	
	private boolean empty;
	private ObjectI Treasure;
	
	
	
	public BlocImpl(boolean b,ObjectI obj){
		init(b,obj);
	}
	
	@Override
	public void init(boolean b, ObjectI obj) {
		empty = b;
		if(obj != null){
			Treasure = obj;
		}else{
			Treasure = null;
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
		return (Treasure == null);
	}

	@Override
	public ObjectI getTreasure() {
		return Treasure;
	}

	@Override
	public ObjectI removeTreasure() {
		ObjectI obj = Treasure;
		Treasure = null;
		return obj;
	}
	
}
