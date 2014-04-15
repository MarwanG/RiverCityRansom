package gestionCombat;

import personnage.PersonnageI;

public interface CombatI {

	
	public void init(int x,int y,int z);
	public Commande lastCommand(PersonnageI p);
	public PersonnageI recupPersonnage(String s);
	public int position(PersonnageI p, String pos);
	public int freeze(PersonnageI p);
	public boolean inRange(PersonnageI p1 , PersonnageI p2);
	
	public void step(Commande c1,Commande c2);
	
}
