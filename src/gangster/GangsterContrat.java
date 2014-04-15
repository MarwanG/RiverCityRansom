package gangster;

import object.ObjectI;
import contract.Contractor;

public class GangsterContrat extends GangsterDecorator {

	public GangsterContrat(GangsterI delgate) {
		super(delgate);
	}

	
	public void checkInvariant(){
		if(this.getHp() <= 0 && !this.youDeadMan()){
			Contractor.defaultContractor().invariantError("Gangster", "dead man");
		}
		if(this.getHp() >= 0 && this.youDeadMan()){
			Contractor.defaultContractor().invariantError("Gangster", "dead man");
		}
		if(this.equiped() && this.getObject() == null){
			Contractor.defaultContractor().invariantError("Gangster", "Object");
		}
		if(!this.equiped() && this.getObject() != null){
			Contractor.defaultContractor().invariantError("Gangster", "Object");
		}
	}
	
	public void init(String nom){
		if(nom.equals("")){
			Contractor.defaultContractor().preconditionError("GangsterContrat", "init","Nom est vide");
		}
		super.init(nom);
		checkInvariant();
		if(this.getNom() != nom)
			Contractor.defaultContractor().postconditionError("GangsterContrat", "init", "nom");
		if(this.getLargeur() != 5)
			Contractor.defaultContractor().postconditionError("GangsterContrat", "init", "largeur");
		if(this.getHauteur() != 5)
			Contractor.defaultContractor().postconditionError("GangsterContrat", "init", "hauteur");
		if(this.getProfondeur() != 5)
			Contractor.defaultContractor().postconditionError("GangsterContrat", "init", "profondeur");
		if(this.getForce() != 20)
			Contractor.defaultContractor().postconditionError("GangsterContrat", "init", "force");
		if(this.getHp() == 100)
			Contractor.defaultContractor().postconditionError("GangsterContrat", "init", "hp");
		if(this.getMoney() == 0)
			Contractor.defaultContractor().postconditionError("GangsterContrat", "init", "Money");
		if(!this.equiped())
			Contractor.defaultContractor().postconditionError("GangsterContrat", "init", "equiped");
		if(this.getObject() == null)
			Contractor.defaultContractor().postconditionError("GangsterContrat", "init", "getObject");
	}
	@Override
	public void depotsHP(int health){
		if(health < 0){
			Contractor.defaultContractor().preconditionError("GangsterContrat", "depotsHP","hp plus petit");	
		}
		if(this.youDeadMan()){
			Contractor.defaultContractor().preconditionError("GangsterContrat", "depotsHP","you dead !!");	
		}
		int hp = this.getHp();
		checkInvariant();
		super.depotsHP(health);
		checkInvariant();
		if(hp != this.getHp())
			Contractor.defaultContractor().postconditionError("GangsterContrat", "depotsHp", "hp");		
	}
	
	public void retraitHP(int dmg){
		if(dmg < 0){
			Contractor.defaultContractor().preconditionError("GangsterContrat", "RetraitHP","hp plus petit");	
		}
		if(this.youDeadMan()){
			Contractor.defaultContractor().preconditionError("GangsterContrat", "RetraitHP","you dead !!");	
		}
		int hp = this.getHp();
		checkInvariant();
		super.retraitHP(dmg);
		checkInvariant();
		if(hp - dmg != this.getHp())
			Contractor.defaultContractor().postconditionError("GangsterContrat", "retraitHp", "hp");	
	}
	
	public void depotsMoney(int s){
		if(this.youDeadMan()){
			Contractor.defaultContractor().preconditionError("GangsterContrat", "depotsMoney","you dead !!");	
		}
		if(s <= 0){
			Contractor.defaultContractor().preconditionError("GangsterContrat", "depotsMoney","No money");	
		}
		int m = this.getMoney();
		checkInvariant();
		super.depotsMoney(s);
		checkInvariant();
		if(0 != this.getMoney())
			Contractor.defaultContractor().postconditionError("GangsterContrat", "depotsMoney", "Money");		
	}
	
	public void retraitMoney(int s){
		if(this.youDeadMan()){
			Contractor.defaultContractor().preconditionError("GangsterContrat", "retraitMoney","you dead !!");	
		}
		if(s <= 0){
			Contractor.defaultContractor().preconditionError("GangsterContrat", "retraitMoney","No money");	
		}
		int m = this.getMoney();
		checkInvariant();
		super.retraitMoney(s);
		checkInvariant();
		if(0 != this.getMoney())
			Contractor.defaultContractor().postconditionError("GangsterContrat", "retraitMoney", "Money");	
	}
	
	public void jeter() {
		//NOT SURE WHAT TO PLACE.
	
	}
	

	@Override
	public void ramasser(ObjectI o) {
		//NOT SURE WHAT TO PLACE AS WELL.
	}
}
