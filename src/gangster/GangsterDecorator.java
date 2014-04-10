package gangster;

public class GangsterDecorator implements GangsterI {

	GangsterI delgate;
	
	
	

	public GangsterDecorator(GangsterI delgate) {
		super();
		this.delgate = delgate;
	}

	public void init(String nom, int largeur, int hauteur, int profondeur,
			int force) {
		delgate.init(nom, largeur, hauteur, profondeur, force);
	}

	public void init(String nom) {
		delgate.init(nom);
	}

	public void depotsHP(int health) {
		delgate.depotsHP(health);
	}

	public void retraitHP(int dmg) {
		delgate.retraitHP(dmg);
	}

	public void depotsMoney(int s) {
		delgate.depotsMoney(s);
	}

	public void retraitMoney(int s) {
		delgate.retraitMoney(s);
	}

	public void jeter() {
		delgate.jeter();
	}

	public void ramasser(Object o) {
		delgate.ramasser(o);
	}

	public boolean equiped() {
		return delgate.equiped();
	}

	public String getNom() {
		return delgate.getNom();
	}

	public int getLargeur() {
		return delgate.getLargeur();
	}

	public int getHauteur() {
		return delgate.getHauteur();
	}

	public int getProfondeur() {
		return delgate.getProfondeur();
	}

	public int getForce() {
		return delgate.getForce();
	}

	public int getHp() {
		return delgate.getHp();
	}

	public int getMoney() {
		return delgate.getMoney();
	}

	public boolean youDeadMan() {
		return delgate.youDeadMan();
	}

	public Object getObject() {
		return delgate.getObject();
	}
	
}
