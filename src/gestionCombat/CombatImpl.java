package gestionCombat;

import java.util.ArrayList;
import java.util.Random;

import gangster.GangsterI;
import gangster.GangsterImpl;
import personnage.PersonnageI;
import personnage.PersonnageImpl;
import terrain.TerrainI;
import terrain.TerrainImpl;

public class CombatImpl implements CombatI {

	private int length;
	private int height;
	private int width;
	private int nbGangsters;

	private TerrainI terrain;
	private PersonnageI ryan;
	private PersonnageI alex;
	private GangsterI slick;
	private ArrayList<GangsterI> gang;
	private Commande lastCommandRyan;
	private Commande lastCommandAlex;

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


	private int ryanF;
	private int alexF;
	private int slickF;
	private ArrayList<Integer> gangF;


	public CombatImpl(int x , int y , int z){
		init(x,y,z);
	}

	@Override
	public void init(int x, int y, int z) { //x-> length y-> height z->width


		length = x;
		height = y;
		width = z;
		this.terrain = new TerrainImpl(length, height, width);
		nbGangsters = (int) (x * z * 0.3); //30% du territoire est peuplé de vil méchants

		alex = new PersonnageImpl("alex",5,6,5,50);
		ryan = new PersonnageImpl("ryan",5,5,5,50);
		slick =  new GangsterImpl("slick");
		gang = new ArrayList<GangsterI>();
		gangF = new ArrayList<Integer>();
		gangX = new ArrayList<Integer>();
		gangY = new ArrayList<Integer>();
		gangZ = new ArrayList<Integer>();

		for(int i = 0 ; i < nbGangsters ; i++){
			gang.add(new GangsterImpl("Scumbag"));
			gangF.add(0);
			Random r = new Random();
			int l,h,w;
			l = r.nextInt(x);
			h = r.nextInt(y);
			w = r.nextInt(z);

			while(l <= 5 || terrain.getBlocCoord(l, h, w).isPit()){ //probably better way to do this
				l = r.nextInt(x);
				h = r.nextInt(y);
				w = r.nextInt(z);
			}
			gangX.add(l);
			gangY.add(h);
			gangZ.add(w);

		}
		//how do u want to save the freeze. //good enough
		ryanX = 0;
		ryanY = 0;
		ryanZ = 0;

		alexX = 0;
		alexY = 1;
		alexZ = 0;

		slickX = x-1;
		slickY = 0;
		slickZ = 0;

		ryanF = 0;
		alexF = 0;
		slickF = 0;
	}

	@Override
	public Commande lastCommand(PersonnageI p) {
		if(p.getNom().equals("alex")){
			return lastCommandAlex;
		}else{
			return lastCommandRyan;
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
		if(p.getNom().equals("alex")){
			return alexF;
		}else if(p.getNom().equals("ryan")){
			return ryanF;
		}else if(p.getNom().equals("slick")){
			return slickF;
		}else if(p.getNom().contains("Gangster_")){
			int id = Integer.parseInt((p.getNom().charAt((p.getNom().length()-1))+""));
			if(id > nbGangsters){
				return -1;
			}else{
				return gangF.get(id);
			}
		}
		return 0;
	}
	@Override
	public boolean inRange(PersonnageI p1, PersonnageI p2) {
		int x1 = 0;
		int y1 = 0;
		int z1 = 0;
		int x2 = 0;
		int y2 = 0;
		int z2 = 0;


		if(p1.getNom().equals("alex")){
			x1 = alexX;
			y1 = alexY;
			z1 = alexZ;
		}else if(p1.getNom().equals("ryan")){
			x1 = ryanX;
			y1 = ryanY;
			z1 = ryanZ;
		}else if(p1.getNom().equals("slick")){
			x1 = slickX;
			y1 = slickY;
			z1 = slickZ;
		}else if(p1.getNom().contains("Gangster_")){
			int id = Integer.parseInt((p1.getNom().charAt((p1.getNom().length()-1))+""));
			if(id > nbGangsters){
				return false;
			}else{
				x1 = gangX.get(id);
				y1 = gangY.get(id);
				z1 = gangZ.get(id);
			}
		}

		if(p2.getNom().equals("alex")){
			x2 = alexX;
			y2 = alexY;
			z2 = alexZ;
		}else if(p2.getNom().equals("ryan")){
			x2= ryanX;
			y2 = ryanY;
			z2 = ryanZ;
		}else if(p2.getNom().equals("slick")){
			x2 = slickX;
			y2 = slickY;
			z2 = slickZ;
		}else if(p2.getNom().contains("Gangster_")){
			int id = Integer.parseInt((p2.getNom().charAt((p2.getNom().length()-1))+""));
			if(id > nbGangsters){
				return false;
			}else{
				x2 = gangX.get(id);
				y2 = gangY.get(id);
				z2 = gangZ.get(id);
			}
		}

		if(x1 == x2 && y1 == y2 && ((z1 == z2+1) || (z1+1 == z2))){
			return true;
		}else if(x1 == x2 && z1 == z2 && ((y1 == y2+1) || (y1+1 == y2))){
			return true;
		}else if(z1 == z2 && y1 == y2 && ((x1 == x2+1) || (x1+1 == x2))){
			return true;
		}else if(z1 == z2 && ((x1 == x2+1) || (x1+1 == x2)) && ((y1 == y2+1) || (y1+1 == y2))){
			return true;
		}else if(x1 == x2 && ((z1 == z2+1) || (z1+1 == z2)) && ((y1 == y2+1) || (y1+1 == y2))){
			return true;
		}else if(y1 == y2 && ((x1 == x2+1) || (x1+1 == x2)) && ((z1 == z2+1) || (z1+1 == z2))){
			return true;
		}else{
			return false;
		}
	}



	@Override
	public void step(Commande alex, Commande ryan) {

		if(alexF == 0){
			switch (alex) {
				case LEFT:
						alexX = Math.max(alexX-1, 0);
					break;

				case DOWN:
						alexZ = Math.max(alexZ-1, 0);
					break;

				case UP:
						alexZ = Math.min(alexZ+1, width-1);
					break;

				case RIGHT:
						alexX = Math.min(alexX+1, length-1);
					break;

				case JUMP_UP:
					//Jump is broken...
					break;
				case JUMP_LEFT:
					break;
				case JUMP_RIGHT:
					break;
				case JUMP_DOWN:
					break;

				case KICK:
						/*check if smo in range and kickit*/
					break;

				case PICKUP:
					if(terrain.getBlocCoord(alexX, alexY, alexZ).hasTreasure())
						this.alex.ramasser(terrain.getBlocCoord(alexX, alexY, alexZ).getTreasure());
					break;

				case THROW:
					this.alex.jeter();
					break;
			}
		}
		if(ryanF==0){
			switch (ryan) {
			case LEFT:
				ryanX = Math.max(ryanX-1, 0);
				break;
			case DOWN:
				ryanZ = Math.max(ryanZ-1, 0);
				break;
			case UP:
				ryanZ = Math.min(ryanZ+1, width-1);
				break;
			case RIGHT:
				ryanX = Math.min(ryanX+1, length-1);
				break;

			case JUMP_UP:
				break;
			case JUMP_LEFT:
				break;
			case JUMP_RIGHT:
				break;
			case JUMP_DOWN:
				break;

			case KICK:
				break;

			case PICKUP:
				if(terrain.getBlocCoord(ryanX, ryanY, ryanZ).hasTreasure())
					this.alex.ramasser(terrain.getBlocCoord(ryanX, ryanY, ryanZ).getTreasure());
				break;

			case THROW:
					this.ryan.jeter();
				break;
			}
		}

		//Others Moves...


	}

}
