package main;

import moteurDeJeu.MoteurDeJeuI;
import moteurDeJeu.MoteurDeJeuImpl;
import gestionCombat.Commande;

public class Main {

	public static void main(String[] args) {
		MoteurDeJeuI m = new MoteurDeJeuImpl(50,50,50);
		while(!m.isFinished()){
			m.gameStep(Commande.randomCmd(), Commande.randomCmd());
			System.out.println(m.combat().lastCommand(m.combat().recupPersonnage("alex")));
			System.out.println(m.combat().position(m.combat().recupPersonnage("alex"), "x"));
		}
	
	}

}
