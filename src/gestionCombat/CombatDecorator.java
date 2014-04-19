package gestionCombat;

import personnage.PersonnageI;
import statuswrapper.StatusWrapperI;
import terrain.TerrainI;

public class CombatDecorator implements CombatI {
	CombatI delegate;

	
	public CombatDecorator(CombatI delegate){
		super();
		this.delegate = delegate;
	}
	
	public int getLength() {
		return delegate.getLength();
	}

	public int getHeight() {
		return delegate.getHeight();
	}

	public int getWidth() {
		return delegate.getWidth();
	}

	public int getNbGangsters() {
		return delegate.getNbGangsters();
	}

	public TerrainI getTerrain() {
		return delegate.getTerrain();
	}

	public void init(int x, int y, int z) {
		delegate.init(x, y, z);
	}

	public boolean inRange(StatusWrapperI p1, StatusWrapperI p2) {
		return delegate.inRange(p1, p2);
	}

	public void step(Commande c1, Commande c2) {
		delegate.step(c1, c2);
	}

	public PersonnageI getRyan() {
		return delegate.getRyan();
	}

	public PersonnageI getSlick() {
		return delegate.getSlick();
	}

	public PersonnageI getAlex() {
		return delegate.getAlex();
	}
}
