package statuswrapper;

import gestionCombat.Commande;
import personnage.PersonnageI;

public class StatusWrapperDecorator {

	StatusWrapperI delegate;
	
	public StatusWrapperDecorator(StatusWrapperI delegate){
		this.delegate = delegate;
	}

	public void init(PersonnageI p, int x, int y, int z, Commande c) {
		delegate.init(p, x, y, z, c);
	}

	public void setX(int x) {
		delegate.setX(x);
	}

	public void setY(int y) {
		delegate.setY(y);
	}

	public void setZ(int z) {
		delegate.setZ(z);
	}

	public void setFreeze(int f) {
		delegate.setFreeze(f);
	}

	public void setDirection(Commande c) {
		delegate.setDirection(c);
	}

	public int freeze() {
		return delegate.freeze();
	}
	
	
}
