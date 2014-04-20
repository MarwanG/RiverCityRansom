package terrain;

import contract.Contractor;

import bloc.BlocI;

public class TerrainContract extends TerrainDecorator {

	public TerrainContract(TerrainI delegate) {
		super(delegate);
		this.init(delegate.getLength(),delegate.getHeight(),delegate.getWidth());
	}

	public void checkInvariants(){
		
		for(int i=0;i<getLength();i++){
			for(int j=0;j<getHeight();j++){
				for(int k=0;k<getWidth();k++){
					if(delegate.getBlocCoord(i, j, k) == null)
						Contractor.defaultContractor().invariantError("TerrainContract", "A bloc isn't defined");
				}
			}
		}

	}

	@Override
	public void init(int l, int h, int w) {
		if(l<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "init", "lenght is less or equal to zero");
		if(h<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "init", "height is less or equal to zero");
		if(w<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "init", "width is less or equal to zero");


		super.init(l, h, w);

		this.checkInvariants();

		if(this.getWidth() != w)
			Contractor.defaultContractor().postconditionError("TerrainContract", "init", "width isn't set right");

		if(this.getHeight() != h)
			Contractor.defaultContractor().postconditionError("TerrainContract", "init", "height isn't set right");

		if(this.getLength() != l)
			Contractor.defaultContractor().postconditionError("TerrainContract", "init", "length isn't set right");


	}


	@Override
	public BlocI getBlocCoord(int l, int h, int w) {
		checkInvariants();

		if(l<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "getBlocCoord", "length is less or equal to zero");
		if(h<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "getBlocCoord", "height is less or equal to zero");
		if(w<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "getBlocCoord", "width is less or equal to zero");

		if(l>=this.getLength())
			Contractor.defaultContractor().preconditionError("TerrainContract", "getBlocCoord", "length is too big");
		if(h>=this.getHeight())
			Contractor.defaultContractor().preconditionError("TerrainContract", "getBlocCoord", "height is too big");
		if(w>=this.getWidth())
			Contractor.defaultContractor().preconditionError("TerrainContract", "getBlocCoord", "width is too big");

		BlocI  res = super.getBlocCoord(l, h, w);

		if(res == null)
			Contractor.defaultContractor().postconditionError("TerrainContract", "getBlocCoord", "get bloc returns null");

		checkInvariants();

		return res;

	}

	@Override
	public void setBlocCoord(int l, int h, int w, BlocI b) {
		checkInvariants();

		if(l<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "length is less or equal to zero");
		if(h<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "height is less or equal to zero");
		if(w<=0)
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "width is less or equal to zero");
		if(l>=this.getLength())
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "length is too big");
		if(h>=this.getHeight())
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "height is too big");
		if(w>=this.getWidth())
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "width is too big");
		if(b == null)
			Contractor.defaultContractor().preconditionError("TerrainContract", "setBlocCoord", "Bloc is null");

		super.setBlocCoord(l, h, w, b);

		if(getBlocCoord(l, h, w).equals(b) == false)
			Contractor.defaultContractor().postconditionError("TerrainContract", "setBlocCoord", "get bloc set wrong");


		checkInvariants();
	}



}
