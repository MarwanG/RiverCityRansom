package moteurDeJeu;

import gestionCombat.CombatI;
import gestionCombat.Commande;

public class MoteurdeJeuDecorator implements MoteurDeJeuI{

	MoteurDeJeuI delegate;
	
	public MoteurdeJeuDecorator(MoteurDeJeuI delegate) {
		this.delegate = delegate;
	}

	public void init(int x, int y, int z) {
		delegate.init(x, y, z);
	}

	public boolean isFinished() {
		return delegate.isFinished();
	}

	public Result finalResualt() {
		return delegate.finalResualt();
	}

	public CombatI combat() {
		return delegate.combat();
	}

	public void gameStep(Commande c1, Commande c2) {
		delegate.gameStep(c1, c2);
	}
	
}
