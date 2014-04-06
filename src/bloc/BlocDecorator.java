package bloc;

import object.ObjectI;

public class BlocDecorator implements  BlocI {
	public BlocI delegate;

	
	
	
	public BlocDecorator(BlocI delegate) {
		super();
		this.delegate = delegate;
	}

	public void init(boolean b, ObjectI obj) {
		delegate.init(b, obj);
	}

	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	public boolean isPit() {
		return delegate.isPit();
	}

	public boolean hasTreasure() {
		return delegate.hasTreasure();
	}

	public ObjectI getTreasure() {
		return delegate.getTreasure();
	}

	public ObjectI removeTreasure() {
		return delegate.removeTreasure();
	}
	
	
}
