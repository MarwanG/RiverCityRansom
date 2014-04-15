package moteurDeJeu;

import gestionCombat.CombatI;
import gestionCombat.Commande;

public interface MoteurDeJeuI {
	public void init (int x , int y , int z);
	public boolean isFinished();
	public Result finalResualt();
	public CombatI combat();
	public void gameStep(Commande c1,Commande c2);
}
