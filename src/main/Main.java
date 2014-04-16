package main;

import moteurDeJeu.MoteurDeJeuI;
import moteurDeJeu.MoteurDeJeuImpl;
import gestionCombat.Commande;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		MoteurDeJeuI m = new MoteurDeJeuImpl(50,50,50);
		while(!m.isFinished()){
			m.gameStep(Commande.RIGHT, Commande.RIGHT);
			Thread.sleep(1000);
		}
	
	}

}
