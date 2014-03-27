package personnage;

import contract.Contractor;


public class PersonnageContrat extends PersonnageDecorator {



	public PersonnageContrat(PersonnageI del){
		super(del);
	}
	
	@Override
	public void init(String nom, int largeur, int hauteur, int profondeur, int force) {
		if(nom.equals("")){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "init","Nom est vide");
		}
		if(force <= 0 ){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "init","force est egal ou plus petit que zero");
		}
		super.init(nom, largeur, hauteur, profondeur, force);
	}
	@Override
	public void depotsHP(int health){
		if(health < 0){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "depotsHP","hp plus petit");	
		}
		if(this.youDeadMan()){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "depotsHP","you dead !!");	
		}
		super.depotsHP(health);
	}
	
	
	public void retraitHP(int dmg){
		if(dmg < 0){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "RetraitHP","hp plus petit");	
		}
		if(this.youDeadMan()){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "RetraitHP","you dead !!");	
		}
		super.retraitHP(dmg);
	}
	
	public void depotsMoney(int s){
		if(this.youDeadMan()){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "depotsMoney","you dead !!");	
		}
		if(s <= 0){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "depotsMoney","No money");	
		}
		super.depotsMoney(s);
		
	}
	
	public void retraitMoney(int s){
		if(this.youDeadMan()){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "retraitMoney","you dead !!");	
		}
		if(s <= 0){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "retraitMoney","No money");	
		}
		super.retraitMoney(s);
	}

	public void jeter() {
		if(!this.equiped()){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "jeter","empty handed !!");	
		}
		super.jeter();
	}
	
	
	
	
}
