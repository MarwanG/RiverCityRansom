package personnage;

public class Personnage implements PersonnageI {
	
	private String nom;
	private int largeur;
	private int hauter;
	private int profonder;
	private int force;
	private int hp;
	private int money;
	private boolean alive;
	private Object object;				//TO be modified when service object is created;
	
	
	
	public Personnage(String nom, int largeur, int hauter, int profonder,
			int force) {
		super();
		this.nom = nom;
		this.largeur = largeur;
		this.hauter = hauter;
		this.profonder = profonder;
		this.force = force;
		this.hp = 100;
		this.money = 0;
		this.alive = true;
		object = null;
	}
	
	
	public void depotsHP(int health){
		if(alive){
			hp+=health;
		}
	}
	
	public void retraitHP(int dmg){
		if(alive){
			hp-=dmg;
			if(hp <= 0){
				alive = false;
			}
		}
	}
	
	public void depotsMoney(int s){
		if(alive){
			money+=s;
		}
	}
	
	public void retraitMoney(int s){
		if(s > money){
			money = 0;
		}else{
			money-=s;
		}
	}
	
	public void  jeter(){
		if(equiped()){
			this.object = null;
		}
	}
	
	public void rammaser(Object o){
		this.object = o;

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


	public int getHauter() {
		return hauter;
	}


	public void setHauter(int hauter) {
		this.hauter = hauter;
	}


	public int getProfonder() {
		return profonder;
	}


	public void setProfonder(int profonder) {
		this.profonder = profonder;
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


	public boolean isAlive() {
		return alive;
	}


	public void setAlive(boolean alive) {
		this.alive = alive;
	}


	public Object getObject() {
		return object;
	}


	public void setObject(Object object) {
		this.object = object;
	}
	
	
	
	
	
}
