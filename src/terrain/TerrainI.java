package terrain;

import java.util.List;

import bloc.BlocI;

public interface TerrainI {

	void init(int length, int height, int width); //x,y,z
	int getLength();
	int getHeight();
	int getWidth();
	BlocI getBlocCoord(int l, int h, int w);
	void setBlocCoord(int l, int h, int w, BlocI b);

}
