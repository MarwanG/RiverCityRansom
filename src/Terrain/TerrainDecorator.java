package Terrain;

import java.util.List;

import bloc.BlocI;

public class TerrainDecorator implements TerrainI{

	TerrainI delegate;
	
	public void init(int width, int height, int depth, List<BlocI> blocs) {
		delegate.init(width, height, depth, blocs);
	}

	public int getWidth() {
		return delegate.getWidth();
	}

	public int getHeight() {
		return delegate.getHeight();
	}

	public int getDepth() {
		return delegate.getDepth();
	}

	public List<BlocI> getBlocList() {
		return delegate.getBlocList();
	}

	public BlocI getBlocCoord(int w, int h, int d) {
		return delegate.getBlocCoord(w, h, d);
	}

	public void setBlocCoord(int w, int h, int d, BlocI b) {
		delegate.setBlocCoord(w, h, d, b);
	}

	public TerrainDecorator(TerrainI delegate){
		this.delegate = delegate;
	}
}
