package bloc;

import contract.Contractor;

public class BlocContract extends BlocDecorator {

	
	public BlocContract(BlocI b){
		super(b);
	}
	
	public Object getTreasure(){
		if(!delegate.hasTreasure()){
			Contractor.defaultContractor().preconditionError("BlocContract", "getTreasure", "doesnt has treasure");
			return null;
		}else{
			return delegate.getTreasure();
		}
	}
	
	
	public Object removeTreasure(){
		if(!delegate.hasTreasure()){
			Contractor.defaultContractor().preconditionError("BlocContract", "removeTreasure", "doesnt has treasure");
			return null;
		}else{
			return delegate.removeTreasure();
		}
	}
}
