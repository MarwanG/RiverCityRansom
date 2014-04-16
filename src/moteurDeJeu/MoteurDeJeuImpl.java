package moteurDeJeu;

import gestionCombat.CombatI;
import gestionCombat.CombatImpl;
import gestionCombat.Commande;

public class MoteurDeJeuImpl implements MoteurDeJeuI {

	
	boolean finished;
	Result finalResult;
	CombatI gc;
	
	
	public MoteurDeJeuImpl(int x , int y , int z){
		init(x,y,z);
	}
	
	@Override
	public void init(int x, int y, int z) {
		gc = new CombatImpl(x,y,z);
		finished = false;
	}

	@Override
	public boolean isFinished() {
		return finished;
	}

	@Override
	public Result finalResualt() {
		return finalResult;
	}

	@Override
	public CombatI combat() {
		return gc;
	}

	@Override
	public void gameStep(Commande c1, Commande c2) {
		gc.step(c1, c2);
		if(gc.getSlick().youDeadMan()){
			finished = true;
			finalResult = Result.WON;
		}
		if(gc.getAlex().youDeadMan() && gc.getRyan().youDeadMan()){
			finished = true;
			finalResult = Result.LOST;
		}
		if(gc.getAlex().youDeadMan() && gc.getRyan().youDeadMan() && gc.getSlick().youDeadMan()){
			finished = true;
			finalResult = Result.TIED;
		}
			
	}

}
