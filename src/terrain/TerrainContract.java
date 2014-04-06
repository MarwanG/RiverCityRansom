package terrain;

import java.util.Iterator;
import java.util.List;

import contract.Contractor;

import bloc.BlocI;

public class TerrainContract extends TerrainDecorator {

	public TerrainContract(TerrainI delegate) {
		super(delegate);
	}

	public void checkInvariants(){
		
		for(int i=0;i<getWidth();i++){
			for(int j=0;j<getHeight();j++){
				for(int k=0;k<getDepth();k++){
					if(getBlocCoord(i, j, k) == null)
						Contractor.defaultContractor().invariantError("TerrainContract", "A bloc isn't defined");
				}
			}	
		}
		
	}
	
	@Override
	public void init(int width, int height, int depth, List<BlocI> blocs) {
		if(width<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "init", "width is less or equal to zero");
		if(height<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "init", "height is less or equal to zero");
		if(depth<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "init", "depth is less or equal to zero");
		if(blocs == null)
			Contractor.defaultContractor().preconditionError("TerrainContract", "init", "blocs is null");
		if(blocs.size()!=width*height*depth)
			Contractor.defaultContractor().preconditionError("TerrainContract", "init", "blocs length is wrong");
		
		super.init(width, height, depth, blocs);
		
		this.checkInvariants();
		
		if(this.getWidth() != width)
			Contractor.defaultContractor().postconditionError("TerrainContract", "init", "width isn't set right");
		
		if(this.getHeight() != height)
			Contractor.defaultContractor().postconditionError("TerrainContract", "init", "height isn't set right");
			
		if(this.getDepth() != depth)
			Contractor.defaultContractor().postconditionError("TerrainContract", "init", "depth isn't set right");
					
		
		
		Iterator<BlocI> it = blocs.iterator();
		for(int i=0;i<getWidth();i++){
			for(int j=0;j<getHeight();j++){
				for(int k=0;k<getDepth();k++){
					if(getBlocCoord(i, j, k) != it.next())
						Contractor.defaultContractor().postconditionError("TerrainContract", "init", "a bloc isn't set right");
				}
			}	
		}
		
		
	}


	@Override
	public BlocI getBlocCoord(int w, int h, int d) {
		checkInvariants();
		
		if(w<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "getBlocCoord", "width is less or equal to zero");
		if(h<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "getBlocCoord", "height is less or equal to zero");
		if(d<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "getBlocCoord", "depth is less or equal to zero");
		if(w>=this.getWidth())
			Contractor.defaultContractor().preconditionError("TerrainContract", "getBlocCoord", "width is too big");
		if(h>=this.getHeight())
			Contractor.defaultContractor().preconditionError("TerrainContract", "getBlocCoord", "height is too big");
		if(d>=this.getDepth())
			Contractor.defaultContractor().preconditionError("TerrainContract", "getBlocCoord", "depth is too big");
		
		BlocI  res = super.getBlocCoord(w, h, d);
		
		if(res == null)
			Contractor.defaultContractor().postconditionError("TerrainContract", "getBlocCoord", "get bloc returns null");
		checkInvariants();
		
		return res;
		
	}

	@Override
	public void setBlocCoord(int w, int h, int d, BlocI b) {
		checkInvariants();
		
		if(w<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "width is less or equal to zero");
		if(h<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "height is less or equal to zero");
		if(d<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "depth is less or equal to zero");
		if(w>=this.getWidth())
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "width is too big");
		if(h>=this.getHeight())
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "height is too big");
		if(d>=this.getDepth())
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "depth is too big");
		if(b == null)
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "Bloc is null");
		
		super.setBlocCoord(w, h, d, b);
		
		if(getBlocCoord(w, h, d).equals(b) == false)
			Contractor.defaultContractor().postconditionError("TerrainContract", "setBlocCoord", "get bloc set wrong");
		
		
		checkInvariants();
	}
	
	

}
