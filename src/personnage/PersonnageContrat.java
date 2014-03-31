package personnage;

import contract.Contractor;


public class PersonnageContrat extends PersonnageDecorator {



	public PersonnageContrat(PersonnageI del){
		super(del);
	}
	
	public void checkInvariant(){
		if(this.getHp() <= 0 && !this.youDeadMan()){
			Contractor.defaultContractor().invariantError("Personnage", "dead man");
		}
		if(this.getHp() >= 0 && this.youDeadMan()){
			Contractor.defaultContractor().invariantError("Personnage", "dead man");
		}
		if(this.equiped() && this.getObject() == null){
			Contractor.defaultContractor().invariantError("Personnage", "Object");
		}
		if(!this.equiped() && this.getObject() != null){
			Contractor.defaultContractor().invariantError("Personnage", "Object");
		}
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
		checkInvariant();
		if(this.getNom() != nom)
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "init", "nom");
		if(this.getLargeur() != largeur)
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "init", "largeur");
		if(this.getHauter() != hauteur)
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "init", "hauteur");
		if(this.getProfondeur() != profondeur)
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "init", "profondeur");
		if(this.getForce() != force)
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "init", "force");
		if(this.getHp() == 100)
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "init", "hp");
		if(this.getMoney() == 0)
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "init", "Money");
		if(!this.equiped())
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "init", "equiped");
		if(this.getObject() == null)
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "init", "getObject");
	}
	@Override
	public void depotsHP(int health){
		if(health < 0){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "depotsHP","hp plus petit");	
		}
		if(this.youDeadMan()){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "depotsHP","you dead !!");	
		}
		int hp = this.getHp();
		checkInvariant();
		super.depotsHP(health);
		checkInvariant();
		if(hp + health != this.getHp())
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "depotsHp", "hp");
		
	}
	
	
	public void retraitHP(int dmg){
		if(dmg < 0){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "RetraitHP","hp plus petit");	
		}
		if(this.youDeadMan()){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "RetraitHP","you dead !!");	
		}
		int hp = this.getHp();
		checkInvariant();
		super.retraitHP(dmg);
		checkInvariant();
		if(hp - dmg != this.getHp())
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "retraitHp", "hp");
	
	}
	
	public void depotsMoney(int s){
		if(this.youDeadMan()){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "depotsMoney","you dead !!");	
		}
		if(s <= 0){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "depotsMoney","No money");	
		}
		int m = this.getMoney();
		checkInvariant();
		super.depotsMoney(s);
		checkInvariant();
		if(m + s != this.getMoney())
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "depotsMoney", "Money");
	
		
	}
	
	public void retraitMoney(int s){
		if(this.youDeadMan()){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "retraitMoney","you dead !!");	
		}
		if(s <= 0){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "retraitMoney","No money");	
		}
		int m = this.getMoney();
		checkInvariant();
		super.retraitMoney(s);
		checkInvariant();
		if(m - s != this.getMoney())
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "retraitMoney", "Money");
	
	}

	public void jeter() {
		if(!this.equiped()){
			Contractor.defaultContractor().preconditionError("PersonnageContrat", "jeter","empty handed !!");	
		}
		checkInvariant();
		super.jeter();
		checkInvariant();
		if(this.equiped())
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "Jeter", "equiped");
	}
	

	@Override
	public void ramasser(Object o) {
		checkInvariant();
		super.ramasser(o);
		checkInvariant();
		if(!this.equiped()){
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "rammaser", "equiped");
		}
		if(this.getObject() == o){
			Contractor.defaultContractor().postconditionError("PersonnageContrat", "rammaser", "object");
		}
		
	}
	
	
	
	
}
