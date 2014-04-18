package main;

import moteurDeJeu.MoteurDeJeuI;
import moteurDeJeu.MoteurDeJeuImpl;
import gestionCombat.Commande;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		MoteurDeJeuI m = new MoteurDeJeuImpl(50,1,20); //height = 1: 2D isometric w/out jumps
		while(!m.isFinished()){
			m.gameStep(Commande.randomCmd(),Commande.randomCmd());
			Thread.sleep(500);
		}
	
	}

}
