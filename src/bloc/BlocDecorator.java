package bloc;

public class BlocDecorator implements  BlocI {
	public BlocI delegate;

	
	
	
	public BlocDecorator(BlocI delegate) {
		super();
		this.delegate = delegate;
	}

	public void init(boolean b, Object obj) {
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

	public Object getTreasure() {
		return delegate.getTreasure();
	}

	public Object removeTreasure() {
		return delegate.removeTreasure();
	}
	
	
}
