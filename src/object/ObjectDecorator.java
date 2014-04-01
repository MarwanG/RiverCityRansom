package object;

public class ObjectDecorator implements ObjectI {
	
	public ObjectI delegate;

	public ObjectDecorator(ObjectI delegate){
		this.delegate = delegate;
	}
	
	public void init(String s, Type t, int i) {
		delegate.init(s, t, i);
	}

	public String getNom() {
		return delegate.getNom();
	}

	public Type getType() {
		return delegate.getType();
	}

	public int getPower() {
		return delegate.getPower();
	}

	public int getValue() {
		return delegate.getValue();
	}
	

}
