package terrain;

import java.util.Random;

import object.ObjectImpl;

import bloc.BlocI;
import bloc.BlocImpl;

public class TerrainImpl implements TerrainI {

	private int length;
	private int height;
	private int width;
	private BlocI[][][] world;
	private Random rand = new Random();

	public TerrainImpl(int width, int height, int depth){
		init(width,height,depth);
	}

	@Override
	public void init(int length, int height, int width) {
		this.width = width;
		this.height = height;
		this.length = length;

		for(int i=0;i<length;i++){
			for(int j=0;j<height;j++){
				for(int k=0;k<width;k++){
					if(i<=5 || i >= height-5){
						world[i][j][k] = new BlocImpl(false,ObjectImpl.randomObjectCreator()); //cannot create starting/ending fosse
					}
					else{
						world[i][j][k] = new BlocImpl(rand.nextBoolean(),ObjectImpl.randomObjectCreator());
					}
				}
			}
		}

	}

	@Override
	public BlocI getBlocCoord(int l, int h, int w) {
		return world[l][h][w];
	}

	@Override
	public void setBlocCoord(int l, int h, int w, BlocI b) {
		world[l][h][w] = b;
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
	public int getLength() {
		return length;
	}




}
