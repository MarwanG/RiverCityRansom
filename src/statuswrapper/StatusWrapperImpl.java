package statuswrapper;

import gestionCombat.Commande;
import personnage.PersonnageI;

public class StatusWrapperImpl implements StatusWrapperI {
	int x;
	int y;
	int z;
	int freeze;
	PersonnageI p;
	Commande direction;

	public StatusWrapperImpl(PersonnageI p, int x, int y, int z, Commande c){
		this.init(p,x,y,z,c);
	}

	@Override
	public void init(PersonnageI p, int x, int y, int z, Commande c) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.z = z;
		this.freeze = 0;
		this.direction = c;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public PersonnageI getPerso() {
		return p;
	}

	public Commande getDirection(){
		return direction;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void setZ(int z) {
		this.z = z;
	}


	@Override
	public void setFreeze(int freeze) {
		this.freeze = freeze;
	}

	@Override
	public void decFreeze() {
		freeze = Math.max(freeze-1, 0);

	}

	@Override
	public boolean isFrozen() {
		return (freeze != 0);
	}

	@Override
	public void setDirection(Commande c) {
		this.direction = c;
	}

	@Override
	public int freeze() {
		return freeze;
	}




}
