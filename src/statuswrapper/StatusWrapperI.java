package statuswrapper;

import gestionCombat.Commande;
import personnage.PersonnageI;

public interface StatusWrapperI {

	/*Obs*/
	public Commande getDirection();
	public PersonnageI getPerso();
	public int getX();
	public int getY();
	public int getZ();
	public boolean isFrozen();
	public int freeze();

	/*Ope*/
	public void init(PersonnageI p, int x,int y, int z, Commande c);
	public void setX(int x);
	public void setY(int y);
	public void setZ(int z);
	public void setFreeze(int f);
	public void decFreeze();
	public void setDirection(Commande c);


}
