package gestionCombat;

import java.util.ArrayList;

import personnage.PersonnageI;
import statuswrapper.StatusWrapperI;
import terrain.TerrainI;

public interface CombatI {

	//obs
	public int getLength();
	public int getHeight();
	public int getWidth();
	public int nbGangsters();
	
	public TerrainI getTerrain();
	
	public PersonnageI getAlex();
	public PersonnageI getRyan();
	public PersonnageI getSlick();
	public ArrayList<StatusWrapperI> getGansgters();
	
	public boolean inRange(StatusWrapperI p1 , StatusWrapperI p2);
	
	//init
	public void init(int x,int y,int z);
	
	//opé
	public void step(Commande c1,Commande c2);
	
	
}
