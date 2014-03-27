package personnage;

public class PersonnageDecorator implements PersonnageI {

	public PersonnageI delegate;
	
	public PersonnageDecorator(PersonnageI delegate) {
		super();
		this.delegate = delegate;
	}
	
	public void init(String nom, int largeur, int hauteur, int profondeur, int force){
		this.delegate.init(nom, largeur, hauteur, profondeur, force);
	}
	
	public void depotsHP(int health) {
		delegate.depotsHP(health);
	}


	public void retraitHP(int dmg) {
		delegate.retraitHP(dmg);
	}


	public void depotsMoney(int s) {
		delegate.depotsMoney(s);
	}


	public void retraitMoney(int s) {
		delegate.retraitMoney(s);
	}


	public void jeter() {
		delegate.jeter();
	}



	public boolean equiped() {
		return delegate.equiped();
	}


	public String getNom() {
		return delegate.getNom();
	}


	public int getLargeur() {
		return delegate.getLargeur();
	}


	public int getHauter() {
		return delegate.getHauteur();
	}


	public int getProfonder() {
		return delegate.getProfondeur();
	}


	public int getForce() {
		return delegate.getForce();
	}


	public int getHp() {
		return delegate.getHp();
	}


	public int getMoney() {
		return delegate.getMoney();
	}


	public boolean youDeadMan() {
		return delegate.youDeadMan();
	}


	public Object getObject() {
		return delegate.getObject();
	}






	@Override
	public void ramasser(Object o) {
		delegate.ramasser(o);
		
	}






	@Override
	public int getHauteur() {
		return delegate.getHauteur();
	}






	@Override
	public int getProfondeur() {
		return delegate.getProfondeur();
	}







	
}
