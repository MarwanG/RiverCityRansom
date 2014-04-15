package terrain;

import bloc.BlocI;

public class TerrainDecorator implements TerrainI{

	TerrainI delegate;

	public TerrainDecorator(TerrainI delegate){
		this.delegate = delegate;
	}

	public void init(int length, int height, int width) {
		delegate.init(length, height, width);
	}

	public int getLength() {
		return delegate.getLength();
	}

	public int getHeight() {
		return delegate.getHeight();
	}

	public int getWidth() {
		return delegate.getWidth();
	}

	public BlocI getBlocCoord(int l, int h, int w) {
		return delegate.getBlocCoord(l, h, w);
	}

	public void setBlocCoord(int l, int h, int w, BlocI b) {
		delegate.setBlocCoord(l, h, w, b);
	}



}
