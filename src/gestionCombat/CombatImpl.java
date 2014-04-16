package gestionCombat;

import java.util.ArrayList;
import java.util.Random;

import gangster.GangsterI;
import gangster.GangsterImpl;
import personnage.PersonnageI;
import personnage.PersonnageImpl;
import statuswrapper.StatusWrapperI;
import statuswrapper.StatusWrapperImpl;
import terrain.TerrainI;
import terrain.TerrainImpl;

public class CombatImpl implements CombatI {

	private int length;
	private int height;
	private int width;
	private int nbGangsters;

	private StatusWrapperI ryan;
	private StatusWrapperI alex;
	private StatusWrapperI slick;
	private ArrayList<StatusWrapperI> gang;

	private TerrainI terrain;



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

		alex = new StatusWrapperImpl(new PersonnageImpl("alex",5,6,5,50),0,0,0,Commande.RIGHT);
		ryan = new StatusWrapperImpl(new PersonnageImpl("ryan",5,6,5,50),0,0,1,Commande.RIGHT);
		slick =new StatusWrapperImpl(new GangsterImpl("slick"),x-1,0,0,Commande.LEFT);
		gang = new ArrayList<StatusWrapperI>();

		for(int i = 0 ; i < nbGangsters ; i++){
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
			gang.add(new StatusWrapperImpl(new GangsterImpl("Scumbag"),l,h,w,Commande.LEFT));

		}
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
			x1 = alex.getX();
			y1 = alex.getY();
			z1 = alex.getZ();

		}else if(p1.getNom().equals("ryan")){
			x1 = ryan.getX();
			y1 = ryan.getY();
			z1 = ryan.getZ();

		}else if(p1.getNom().equals("slick")){
			x1 = slick.getX();
			y1 = slick.getY();
			z1 = slick.getZ();

		}else if(p1.getNom().contains("Gangster_")){
			int id = Integer.parseInt((p1.getNom().charAt((p1.getNom().length()-1))+""));
			if(id > nbGangsters){
				return false;
			}else{
				x1 = gang.get(id).getX();
				y1 = gang.get(id).getY();
				z1 = gang.get(id).getZ();
			}
		}

		if(p2.getNom().equals("alex")){
			x2 = alex.getX();
			y2 = alex.getY();
			z2 = alex.getZ();
		}else if(p2.getNom().equals("ryan")){
			x2= ryan.getX();
			y2 = ryan.getY();
			z2 = ryan.getZ();
		}else if(p2.getNom().equals("slick")){
			x2 = slick.getX();
			y2 = slick.getY();
			z2 = slick.getZ();
		}else if(p2.getNom().contains("Gangster_")){
			int id = Integer.parseInt((p2.getNom().charAt((p2.getNom().length()-1))+""));
			if(id > nbGangsters){
				return false;
			}else{
				x2 = gang.get(id).getX();
				y2 = gang.get(id).getY();
				z2 = gang.get(id).getZ();
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

		boolean slickRange = inRange(recupPersonnage("alex"), recupPersonnage("slick"));
		boolean scumRange = false;

		for(int i=0;i<nbGangsters && scumRange == false;i++){
			scumRange = inRange(recupPersonnage("alex"), recupPersonnage("Gangster_"+i));
		}

		if(alex.isFrozen()){
			switch (alex) {
				case LEFT:
						if(slickRange || scumRange){
							getKicked("alex",lastCommandAlex);
						}
						else{
							alexX = Math.max(alexX-1, 0);
						}
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
						this.alex.ramasser(terrain.getBlocCoord(alexX, alexY, alexZ).getTreasure());//check if money ...
					break;

				case THROW:
					this.alex.jeter();
					break;
			}

			}else{

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



	@Override
	public Commande lastCommand(PersonnageI p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonnageI recupPersonnage(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int position(PersonnageI p, String pos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int freeze(PersonnageI p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
