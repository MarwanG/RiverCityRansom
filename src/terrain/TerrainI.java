package terrain;

import java.util.List;

import bloc.BlocI;

public interface TerrainI {
	
	void init(int width, int height, int depth, List<BlocI> blocs);
	int getWidth();
	int getHeight();
	int getDepth();
	List<BlocI> getBlocList();
	BlocI getBlocCoord(int w, int h, int d);
	void setBlocCoord(int w, int h, int d, BlocI b);

}
