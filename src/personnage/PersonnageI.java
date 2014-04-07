package personnage;

import object.ObjectI;

public interface PersonnageI {
	
	public void init( String nom, int largeur, int hauteur, int profondeur,int force);
	
	public void depotsHP(int health);
	
	public void retraitHP(int dmg);
	
	public void depotsMoney(int s);
	
	public void retraitMoney(int s);
	
	public void  jeter();
	
	public void ramasser(ObjectI o);
	
	public boolean equiped();
	
	public String getNom();
	
	public int getLargeur();
	
	public int getHauteur();
	
	public int getProfondeur();
	
	public int getForce();
	
	public int getHp();

	public int getMoney();

	public boolean youDeadMan();
	
	public ObjectI getObject();
	
}
