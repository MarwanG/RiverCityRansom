package Terrain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bloc.BlocI;

public class TerrainImpl implements TerrainI {
	
	private int width;
	private int height;
	private int depth;
	private BlocI[][][] world; 

	public TerrainImpl(int width, int height, int depth, List<BlocI> blocs){
		init(width,height,depth,blocs);
	}
	
	@Override
	public void init(int width, int height, int depth, List<BlocI> blocs) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.world = new BlocI[width][height][depth];
		
		Iterator<BlocI> it = blocs.iterator();
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				for(int k=0;k<depth;k++){
					world[i][j][k] = it.next();
				}
			}	
		}

	}

	@Override
	public BlocI getBlocCoord(int w, int h, int d) {
		return world[w][h][d];
	}

	@Override
	public void setBlocCoord(int w, int h, int d, BlocI b) {
		world[w][h][d] = b;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getDepth() {
		return depth;
	}

	@Override
	public List<BlocI> getBlocList() {
		
		List<BlocI> list = new ArrayList<BlocI>(width*height*depth);
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				for(int k=0;k<depth;k++){
					list.add(world[i][j][k]);
				}
			}	
		}
		return list;
	}

}
