package bloc;

import contract.Contractor;

public class BlocContract extends BlocDecorator {

	
	public BlocContract(BlocI b){
		super(b);
		
	}
	
	public void checkInvariant(){
		if(this.hasTreasure() && this.getTreasure() == null){
			Contractor.defaultContractor().invariantError("BlocContract", "Treasure changed in variant");
		}
		if(!this.hasTreasure() && this.getTreasure()!= null){
			Contractor.defaultContractor().invariantError("BlocContract", "Treasure changed in variant");		
		}
		if(this.isPit() == this.isEmpty()){
			Contractor.defaultContractor().invariantError("BlocContract", "Pit and empty problem");		
		}
	}
	
	public void init(boolean b, Object obj){
		super.init(b, obj);
		checkInvariant();
		if(b && !this.isEmpty())
			Contractor.defaultContractor().postconditionError("BlocContract", "init", "empty defined wrong");
		if(obj == null && this.hasTreasure())
				Contractor.defaultContractor().postconditionError("BlocContract", "init", "treasure not defined");
		if(obj != null && !this.hasTreasure())
			Contractor.defaultContractor().postconditionError("BlocContract", "init", "treasure should be defined");
		if(obj != null && this.getTreasure()!=obj)
			Contractor.defaultContractor().postconditionError("BlocContract", "init", "treasure not properly defined");
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
			checkInvariant();
			Object obj =  delegate.removeTreasure();
			checkInvariant();
			if(this.getTreasure() != null)
				Contractor.defaultContractor().postconditionError("BlocContract", "removeTreasure", "treasure not removed");
			if(!this.hasTreasure())
				Contractor.defaultContractor().postconditionError("BlocContract", "removeTreasure", "has treasure wrong");
			return obj;
		}
	}
}
