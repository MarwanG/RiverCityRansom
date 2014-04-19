package gestionCombat;

import contract.Contractor;

public class CombatContract extends CombatDecorator {

	public CombatContract(CombatI delegate) {
		super(delegate);
	}

	@Override
	public void init(int x, int y, int z) {
		if(x < 50){
			Contractor.defaultContractor().preconditionError("Combat", "init", "x less than 50");
		}
		if(y < 50){
			Contractor.defaultContractor().preconditionError("Combat", "init", "y less than 50");
		}
		if(z < 50){
			Contractor.defaultContractor().preconditionError("Combat", "init", "z less than 50");
		}
		super.init(x, y, z);
		if(this.getLength() != x){
			Contractor.defaultContractor().postconditionError("Combat", "init", "x not correct");
		}
		if(this.getHeight() != y){
			Contractor.defaultContractor().postconditionError("Combat", "init", "y not correct");
		}
		if(this.getWidth() != z){
			Contractor.defaultContractor().postconditionError("Combat", "init", "z not correct");
		}
		if(this.getAlex().getNom() != "alex" || this.getAlex().getHauteur() != 5 || this.getAlex().getForce() != 50 || this.getAlex().getLargeur() != 5 || this.getAlex().getProfondeur() != 5 ){
			Contractor.defaultContractor().postconditionError("Combat", "init", "alex not correct");
		}
		if(this.getRyan().getNom() != "ryan" || this.getAlex().getHauteur() != 6 || this.getAlex().getForce() != 50 || this.getAlex().getLargeur() != 5 || this.getAlex().getProfondeur() != 5 ){
			Contractor.defaultContractor().postconditionError("Combat", "init", "ryan not correct");
		}
		if(this.getTerrain().getLength() != x || this.getTerrain().getHeight() != y || this.getTerrain().getWidth() != z){
			Contractor.defaultContractor().postconditionError("Combat", "init", "terrain not correct");
		}
	}

	@Override
	public void step(Commande c1, Commande c2) {
		// NOT SURE WHAT AM SUPPOSE TO DO WITH ALL THE IFS.
		super.step(c1, c2);
	}

	
	
	
	
	
}
