package moteurDeJeu;

import contract.Contractor;
import gestionCombat.Commande;

public class MoteurDeJeuContract extends MoteurdeJeuDecorator {

	public MoteurDeJeuContract(MoteurDeJeuI delegate) {
		super(delegate);
	}

	@Override
	public void gameStep(Commande c1, Commande c2) {
		if(isFinished())
			Contractor.defaultContractor().preconditionError("MoteurJeu", "gamestep", "jeu fini");
		super.gameStep(c1, c2);
	}
	
	

}
