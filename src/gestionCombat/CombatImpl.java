package gestionCombat;

import java.util.ArrayList;

import gangster.GangsterI;
import gangster.GangsterImpl;
import personnage.PersonnageI;
import personnage.PersonnageImpl;
import terrain.TerrainI;

public class CombatImpl implements CombatI {

	private int length;
	private int depth;
	private int width;
	private int nbGangsters;
	private TerrainI terrain;
	private PersonnageI ryan;
	private PersonnageI alex;
	private GangsterI slick;
	private ArrayList<GangsterI> gang;
	private Commande lastComamandRyan;
	private Commande lastComamandAlex;
	
	private int ryanX;
	private int ryanY;
	private int ryanZ;
	
	private int alexX;
	private int alexY;
	private int alexZ;
	
	private int slickX;
	private int slickY;
	private int slickZ;
	
	private ArrayList<Integer> gangX;
	private ArrayList<Integer> gangY;
	private ArrayList<Integer> gangZ;
	
	
	public CombatImpl(int x , int y , int z){
		init(x,y,z);
	}

	@Override
	public void init(int x, int y, int z) {
		length = x;
		depth = z;
		width = y;
		nbGangsters = (int) (x * y * 0.3);
		alex = new PersonnageImpl("alex",5,6,5,50);
		ryan = new PersonnageImpl("ryan",5,5,5,50);
		slick =  new GangsterImpl("slick");
		gang = new ArrayList<GangsterI>();
		for(int i = 0 ; i < nbGangsters ; i++){
			//MISSING TERRAIN STUFF
			gang.add(new GangsterImpl("Scumbag"));
		}
		//how do u want to save the freeze.
		ryanX = 0;
		alexX = 0;
		slickX = x-1;
		ryanY = 0;
		alexX = 1;
		slickX = 0;
		ryanZ = 0;
		alexZ = 0;
		slickZ = 0;
	}
	
	@Override
	public Commande lastCommand(PersonnageI p) {
		if(p.getNom().equals("alex")){
			return lastComamandAlex;
		}else{
			return lastComamandRyan;
		}
	}
	@Override
	public PersonnageI recupPersonnage(String s) {
		switch (s){
			case "alex": return alex;
			case "ryan": return ryan;
			case "slick": return slick;
		}
		if(s.contains("Gangster_")){
			int id = Integer.parseInt(s.charAt(s.length()-1)+"");
			if(id > nbGangsters){
				return null;
			}else{
				return gang.get(id);
			}
		}else{
			return null;
		}
	}
	@Override
	public int position(PersonnageI p, String pos) {
		if(p.getNom().equals("alex")){
			switch(pos){
				case "x": return alexX;
				case "y": return alexY;
				case "z": return alexZ;
			}
		}else if(p.getNom().equals("ryan")){
			switch(pos){
			case "x": return ryanX;
			case "y": return ryanY;
			case "z": return ryanZ;
			}
		}else if(p.getNom().equals("slick")){
			switch(pos){
			case "x": return slickX;
			case "y": return slickY;
			case "z": return slickZ;
			}
		}else if(p.getNom().contains("Gangster_")){
			int id = Integer.parseInt((p.getNom().charAt((p.getNom().length()-1))+""));
			if(id > nbGangsters){
				return -1;
			}else{
				switch(pos){
				case "x": return gangX.get(id);
				case "y": return gangY.get(id);
				case "z": return gangZ.get(id);
				}
			}
		}
		return -1;
	}
	@Override
	public int freeze(PersonnageI p) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean inRange(PersonnageI p1, PersonnageI p2) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void step(Commande c1, Commande c2) {
		// TODO Auto-generated method stub
		
	}
	
}
