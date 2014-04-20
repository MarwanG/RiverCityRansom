package personnage;

import object.ObjectI;

public class PersonnageImpl implements PersonnageI {
	
	private String nom;
	private int largeur;
	private int hauteur;
	private int profondeur;
	private int force;
	private int hp;
	private int money;
	private boolean alive;
	private ObjectI object;
	
	
	
	public PersonnageImpl(String nom, int largeur, int hauteur, int profondeur,
			int force) {
		this.init(nom,largeur,hauteur,profondeur, force);
	}
	

	
	public void init(String nom, int largeur, int hauteur, int profondeur, int force) {
		this.nom = nom;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.profondeur = profondeur;
		this.force = force;
		this.hp = 100;
		this.money = 0;
		this.alive = true;
		object = null;
		
	}
	
	public int getHauteur() {
		return hauteur;
	}


	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}


	public int getProfondeur() {
		return profondeur;
	}


	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}


	public void depotsHP(int health){
			this.hp = Math.min(this.hp+health, 100);
	}
	
	public void retraitHP(int dmg){
			this.hp = Math.max(0, this.hp-dmg);
			if(hp <= 0){
				alive = false;
			}
	}
	
	public void depotsMoney(int s){
			money+=s;
	}
	

	public void retraitMoney(int s){
		if(money >= s)
			this.money = Math.max(0, this.money-s);
	}
	
	public void  jeter(){
			this.object = null;
	}
	
	
	public boolean equiped(){
		return (this.object != null);
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getLargeur() {
		return largeur;
	}


	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getForce() {
		return force;
	}


	public void setForce(int force) {
		this.force = force;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public boolean youDeadMan() {
		return !alive;
	}


	public void setAlive(boolean alive) {
		this.alive = alive;
	}


	public ObjectI getObject() {
		return object;
	}

	public void ramasser(ObjectI o) {
		this.object = o;
		
	}
	
	
	
	
	
	
}

