package statuswrapper;

import contract.Contractor;
import gestionCombat.Commande;
import personnage.PersonnageI;

public class StatusWrapperContrat extends StatusWrapperDecorator {

	public StatusWrapperContrat(StatusWrapperI delegate) {
		super(delegate);
	}
	
	private void checkInvariants(){
		if(delegate.getX()<0)
			Contractor.defaultContractor().invariantError("StatusWrapper", " x < 0");
		if(delegate.getY()<0)
			Contractor.defaultContractor().invariantError("StatusWrapper", " y < 0");
		if(delegate.getZ()<0)
			Contractor.defaultContractor().invariantError("StatusWrapper", " z < 0");
		if(delegate.freeze()<0)
			Contractor.defaultContractor().invariantError("StatusWrapper", " freeze < 0");
	}

	@Override
	public void init(PersonnageI p, int x, int y, int z, Commande c) {
		checkInvariants();
		
		//pre:
		if(x<0)
			Contractor.defaultContractor().preconditionError("StatusWrapper", "init", "arg x<0");
		if(y<0)
			Contractor.defaultContractor().preconditionError("StatusWrapper", "init", "arg y<0");
		if(z<0)
			Contractor.defaultContractor().preconditionError("StatusWrapper", "init", "arg z<0");
		if(p==null)
			Contractor.defaultContractor().preconditionError("StatusWrapper", "init", "arg p is null");
		if(c != Commande.DOWN && c != Commande.UP && c != Commande.LEFT && c != Commande.RIGHT)
			Contractor.defaultContractor().preconditionError("StatusWrapper", "init", "arg c not in {UP,DOWN,LEFT,RIGHT}");
		
		super.init(p, x, y, z, c);
		
		//post:
		if(delegate.getX() != x)
			Contractor.defaultContractor().postconditionError("StatusWrapper", "init", "getX != x");
		if(delegate.getY() != y)
			Contractor.defaultContractor().postconditionError("StatusWrapper", "init", "getY != y");
		if(delegate.getZ() != z)
			Contractor.defaultContractor().postconditionError("StatusWrapper", "init", "getZ != z");
		if(delegate.freeze() != 0)
			Contractor.defaultContractor().postconditionError("StatusWrapper", "init", "freeze != 0");
		if(delegate.getDirection() != c)
			Contractor.defaultContractor().postconditionError("StatusWrapper", "init", "getDirection != c");
		if(delegate.getPerso() != p)
			Contractor.defaultContractor().postconditionError("StatusWrapper", "init", "getPerso != p");
		
		
		checkInvariants();
	}

	@Override
	public void setX(int x) {
		checkInvariants();
		if(x<0)
			Contractor.defaultContractor().preconditionError("StatusWrapper", "setX", "arg x<0");
		
		super.setX(x);
		
		if(delegate.getX() != x)
			Contractor.defaultContractor().postconditionError("StatusWrapper", "setX", "getX != x");
		checkInvariants();
	}

	@Override
	public void setY(int y) {
		checkInvariants();
		if(y<0)
			Contractor.defaultContractor().preconditionError("StatusWrapper", "setY", "arg y<0");
		
		super.setY(y);
		
		if(delegate.getY() != y)
			Contractor.defaultContractor().postconditionError("StatusWrapper", "setY", "getY != y");
		checkInvariants();
	}

	@Override
	public void setZ(int z) {
		checkInvariants();
		if(z<0)
			Contractor.defaultContractor().preconditionError("StatusWrapper", "setZ", "arg z<0");
		
		super.setZ(z);
		
		if(delegate.getZ() != z)
			Contractor.defaultContractor().postconditionError("StatusWrapper", "getZ", "getZ != z");
		checkInvariants();
	}

	@Override
	public void setFreeze(int f) {
		checkInvariants();
		if(f<0)
			Contractor.defaultContractor().preconditionError("StatusWrapper", "setFreeze", "arg f<0");
		super.setFreeze(f);
		if(delegate.freeze() != 0)
			Contractor.defaultContractor().postconditionError("StatusWrapper", "setFreeze", "freeze != f");
		checkInvariants();
	}

	@Override
	public void setDirection(Commande c) {
		checkInvariants();
		if(c != Commande.DOWN && c != Commande.UP && c != Commande.LEFT && c != Commande.RIGHT)
			Contractor.defaultContractor().preconditionError("StatusWrapper", "setDirection", "arg c not in {UP,DOWN,LEFT,RIGHT}");
		
		super.setDirection(c);
		
		if(delegate.getDirection() != c)
			Contractor.defaultContractor().postconditionError("StatusWrapper", "setDirection", "getDirection != c");
		checkInvariants();
	}
	
	
	

}
