package object;

import contract.Contractor;

public class ObjectContrat extends ObjectDecorator {

	public ObjectContrat(ObjectI delegate) {
		super(delegate);
	}
	
	
	public void init(String s,Type t,int i){
		if(s == ""){
			Contractor.defaultContractor().preconditionError("ObjectContrat", "init","Nom est vide");
		}
		if(i <= 0){
			Contractor.defaultContractor().preconditionError("ObjectContrat", "init","value of i");
		}
		super.init(s, t, i);
		if(this.getNom() != s){
			Contractor.defaultContractor().postconditionError("ObjectContrat", "init", "name is different");
		}
		if(this.getType() != t){
			Contractor.defaultContractor().postconditionError("ObjectContrat", "init", "Type is different");
		}
		if(!((this.getValue() == 0) || (this.getValue() == i)))
			Contractor.defaultContractor().postconditionError("ObjectContrat", "init", "Value is different");
		if(!((this.getPower() == 0) || (this.getPower() == i)))
			Contractor.defaultContractor().postconditionError("ObjectContrat", "init", "Power is different");
		
	}

}
