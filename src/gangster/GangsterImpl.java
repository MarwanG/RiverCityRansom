package gangster;

import object.ObjectI;

public class GangsterImpl implements GangsterI {

	

	private String nom;
	private int largeur;
	private int hauteur;
	private int profondeur;
	private int force;
	private int hp;
	private int money;
	private boolean alive;
	private Object object;		
	
	
	public GangsterImpl(String nom){
		init(nom);
	}
	
	@Override
	public void init(String nom, int largeur, int hauteur, int profondeur,
			int force) {
		//USELESS NOT SURE WHAT TO DO DUE TO EXTENDING INTERFACE.
	}

	@Override
	public void init(String nom) {
		this.nom = nom;
		this.largeur = 5;
		this.hauteur = 5;
		this.profondeur = 5;
		this.force = 20;
		this.hp = 100;
		this.money = 0;
		this.alive = true;
		object = null;			//NEED TO CHECK THE PAPER.
	}

	@Override
	public void depotsHP(int health) {	
	}

	@Override
	public void retraitHP(int dmg) {
		this.hp = Math.max(0, this.hp-dmg);
		if(hp <= 0){
			alive = false;
		}
	}

	@Override
	public void depotsMoney(int s) {
	}

	@Override
	public void retraitMoney(int s) {
	}

	@Override
	public void jeter() {
	}


	@Override
	public boolean equiped() {
		return false;
	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public int getLargeur() {
		return largeur;
	}

	@Override
	public int getHauteur() {
		return hauteur;
	}

	@Override
	public int getProfondeur() {
		return profondeur;
	}

	@Override
	public int getForce() {
		return force;
	}

	@Override
	public int getHp() {
		return hp;
	}

	@Override
	public int getMoney() {
		return 0;
	}

	@Override
	public boolean youDeadMan() {
		return !alive;
	}

	@Override
	public void ramasser(ObjectI o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ObjectI getObject() {
		// TODO Auto-generated method stub
		return null;
	}


}
