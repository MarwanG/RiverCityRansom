package gestionCombat;

import java.util.ArrayList;
import java.util.Random;

import object.Type;

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
	public void step(Commande ca, Commande cr) {
		printStep(ca,cr);
		
		boolean slickRange = inRange(alex.getPerso(), slick.getPerso());
		boolean scumRange = false;
		PersonnageI scum= null;

		for(int i=0;i<nbGangsters && scumRange == false;i++){
			scumRange = inRange(alex.getPerso(), gang.get(i).getPerso());
			scum = gang.get(i).getPerso();
		}

		if(!alex.isFrozen()){
			switch (ca) {
				case LEFT:
						if(slickRange || scumRange){
							getKicked(alex);
							alex.setFreeze(3);
						}
						else{
							alex.setX(Math.max(alex.getX()-1, 0));
						}
					break;

				case DOWN:
						if(slickRange || scumRange){
							getKicked(alex);
							alex.setFreeze(3);
						}
						else{
							alex.setZ(Math.max(alex.getZ()-1, 0));
						}
					break;
				case UP:
					if(slickRange || scumRange){
						getKicked(alex);
						alex.setFreeze(3);
					}
					else{
						alex.setZ(Math.min(alex.getZ()+1, width-1));
					}
					break;

				case RIGHT:
					if(slickRange || scumRange){
						getKicked(alex);
						alex.setFreeze(3);
					}
					else{
						alex.setX(Math.min(alex.getX()+1, length-1));
					}
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
						if(slickRange)
						{
							slick.getPerso().retraitHP(alex.getPerso().getForce());
							break;
						}
						if(scumRange)
						{
							scum.retraitHP(alex.getPerso().getForce());
						}
					break;

				case PICKUP:
					if(terrain.getBlocCoord(alex.getX(), alex.getY(), alex.getZ()).hasTreasure())
					{
						if(terrain.getBlocCoord(alex.getX(), alex.getY(), alex.getZ()).getTreasure().getType() == Type.Usable)
							alex.getPerso().ramasser(terrain.getBlocCoord(alex.getX(), alex.getY(), alex.getZ()).getTreasure());
						else
							alex.getPerso().depotsMoney(terrain.getBlocCoord(alex.getX(), alex.getY(), alex.getZ()).getTreasure().getValue());
					}
					break;

				case THROW:
					this.alex.getPerso().jeter();
					break;
			}
		} else
		{
			alex.decFreeze();
		}
		
		slickRange = inRange(ryan.getPerso(), slick.getPerso());
		scumRange = false;
		scum=null;

		for(int i=0;i<nbGangsters && scumRange == false;i++){
			scumRange = inRange(ryan.getPerso(), gang.get(i).getPerso());
			scum = gang.get(i).getPerso();
		}

		if(!ryan.isFrozen()){
			switch (ca) {
				case LEFT:
						if(slickRange || scumRange){
							getKicked(ryan);
							ryan.setFreeze(3);
						}
						else{
							ryan.setX(Math.max(ryan.getX()-1, 0));
						}
					break;

				case DOWN:
						if(slickRange || scumRange){
							getKicked(ryan);
							ryan.setFreeze(3);
						}
						else{
							ryan.setZ(Math.max(ryan.getZ()-1, 0));
						}
					break;
				case UP:
					if(slickRange || scumRange){
						getKicked(ryan);
						ryan.setFreeze(3);
					}
					else{
						ryan.setZ(Math.min(ryan.getZ()+1, width-1));
					}
					break;

				case RIGHT:
					if(slickRange || scumRange){
						getKicked(ryan);
						ryan.setFreeze(3);
					}
					else{
						ryan.setX(Math.min(ryan.getX()+1, length-1));
					}
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
						if(slickRange)
						{
							slick.getPerso().retraitHP(ryan.getPerso().getForce());
							break;
						}
						if(scumRange)
						{
							scum.retraitHP(ryan.getPerso().getForce());
						}
					break;

				case PICKUP:
					if(terrain.getBlocCoord(ryan.getX(), ryan.getY(), ryan.getZ()).hasTreasure())
					{
						if(terrain.getBlocCoord(ryan.getX(), ryan.getY(), ryan.getZ()).getTreasure().getType() == Type.Usable)
							ryan.getPerso().ramasser(terrain.getBlocCoord(ryan.getX(), ryan.getY(), ryan.getZ()).getTreasure());
						else
							ryan.getPerso().depotsMoney(terrain.getBlocCoord(ryan.getX(), ryan.getY(), ryan.getZ()).getTreasure().getValue());
					}
					break;

				case THROW:
					this.ryan.getPerso().jeter();
					break;
			}
		} else
		{
			ryan.decFreeze();
		}



	}

	private void printStep(Commande ca,Commande cr) {
		
		System.out.println(ca);
		System.out.println("Alex: X:"+alex.getX()+" Y:"+alex.getY()+" Z:"+alex.getZ() + " HP:"+alex.getPerso().getHp());
		
		System.out.println(cr);
		System.out.println("Ryan: X:"+ryan.getX()+" Y:"+ryan.getY()+" Z:"+ryan.getZ()+" HP:"+ryan.getPerso().getHp());
		
		System.out.println("Slick: X:"+slick.getX()+" Y:"+slick.getY()+" Z:"+slick.getZ());
		
	}

	public PersonnageI getRyan(){
		return ryan.getPerso();
	}
	
	public PersonnageI getAlex(){
		return alex.getPerso();
	}
	
	public PersonnageI getSlick(){
		return slick.getPerso();
	}

	private void getKicked(StatusWrapperI perso) {
		Commande dir = perso.getDirection();
				
		switch(dir){
			case DOWN:
				perso.setZ(Math.max(0,perso.getZ()-3));
				break;
			case UP:
				perso.setZ(Math.min(width-1,perso.getZ()+3));
				break;
			case RIGHT:
				perso.setX(Math.max(0, perso.getX()-3));
				break;
			case LEFT:
				perso.setX(Math.min(length-1,perso.getX()-3));
				break;
			
			default:
				return;
		}
		
	}

}
