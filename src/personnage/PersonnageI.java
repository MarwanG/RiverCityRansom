package personnage;

public interface PersonnageI {
	public void depotsHP(int health);
	
	public void retraitHP(int dmg);
	
	public void depotsMoney(int s);
	
	public void retraitMoney(int s);
	
	public void  jeter();
	
	public void rammaser(Object o);
	
	public boolean equiped();
	
	public String getNom();
	
	public int getLargeur();
	
	public int getHauter();
	
	public int getProfonder();
	
	public int getForce();
	

	public int getHp();

	public int getMoney();


	public boolean isAlive();
	
	public Object getObject();
	
}
