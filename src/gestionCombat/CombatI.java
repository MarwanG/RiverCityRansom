package gestionCombat;

import personnage.PersonnageI;

public interface CombatI {

	
	public void init(int x,int y,int z);
	public boolean inRange(PersonnageI p1 , PersonnageI p2);	
	public void step(Commande c1,Commande c2);
	public PersonnageI getRyan();
	public PersonnageI getSlick();
	public PersonnageI getAlex();
	
}
