package gestionCombat;

import java.util.ArrayList;

import org.omg.CORBA.INTERNAL;

import object.Type;

import gangster.GangsterImpl;
import personnage.PersonnageI;
import personnage.PersonnageImpl;
import statuswrapper.StatusWrapperI;
import statuswrapper.StatusWrapperImpl;
import terrain.TerrainI;
import terrain.TerrainImpl;

public class CombatImpl implements CombatI {

	private static int step = 0;
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
	
		nbGangsters = (int) (x * z * 0.3); //30% du territoire est peuple de vil méchants

		alex = new StatusWrapperImpl(new PersonnageImpl("alex",5,6,5,50),0,0,0,Commande.RIGHT);
		ryan = new StatusWrapperImpl(new PersonnageImpl("ryan",5,6,5,50),0,0,1,Commande.RIGHT);
		slick =new StatusWrapperImpl(new GangsterImpl("slick"),x-1,0,0,Commande.LEFT);
		gang = new ArrayList<StatusWrapperI>();

		
		for(int i = 5; i<length-1;i++){
			for(int j=width-1;j>=0;j--){
				if(terrain.getBlocCoord(i, 0, j).isEmpty())
					gang.add(new StatusWrapperImpl(new GangsterImpl("Scumbag"),i,0,j,Commande.LEFT));
					
			}
		}
		

	}

	@Override
	public boolean inRange(StatusWrapperI p1, StatusWrapperI p2) {
		int x1 = 0;
		int y1 = 0;
		int z1 = 0;
		int x2 = 0;
		int y2 = 0;
		int z2 = 0;


			x1 = p1.getX();
			y1 = p1.getY();
			z1 = p1.getZ();

		
			x2 = p2.getX();
			y2 = p2.getY();
			z2 = p2.getZ();
			

		if(x1 == x2 && y1 == y2 && ((z1 == z2+1) || (z1+1 == z2))){
			return true;
		}else if(z1 == z2 && y1 == y2 && ((x1 == x2+1) || (x1+1 == x2))){
			return true;
		}else{
			return false;
		}
	}



	@Override
	public void step(Commande ca, Commande cr) {
		printStep(ca,cr);
		
		boolean slickRange = inRange(alex, slick);
		boolean scumRange = false;
		StatusWrapperI scum= null;
	

		for(int i=0;i<nbGangsters && scumRange == false;i++){
			scumRange = inRange(alex, gang.get(i));
			scum = gang.get(i);
			
		}

		if(!alex.isFrozen() && !alex.getPerso().youDeadMan()){
			switch (ca) {
				case LEFT:
						if(slickRange || scumRange){
							getKicked(alex,((slickRange)?slick:scum));
						}
						else{
							alex.setX(Math.max(alex.getX()-1, 0));
						}
					break;

				case DOWN:
						if(slickRange || scumRange){
							getKicked(alex,((slickRange)?slick:scum));
													}
						else{
							alex.setZ(Math.max(alex.getZ()-1, 0));
						}
					break;
				case UP:
					if(slickRange || scumRange){
						getKicked(alex,((slickRange)?slick:scum));
											}
					else{
						alex.setZ(Math.min(alex.getZ()+1, width-1));
					}
					break;

				case RIGHT:
					if(slickRange || scumRange){
						getKicked(alex,((slickRange)?slick:scum));
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
							getKicked(slick, alex);
							break;
						}
						if(scumRange)
						{
							getKicked(scum, alex);
							break;
						
						}
						System.out.println("Alex Kicked in the void, what a loser");
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
		} 
		
		slickRange = inRange(ryan, slick);
		scumRange = false;
		scum=null;

		for(int i=0;i<nbGangsters && scumRange == false;i++){
			scumRange = inRange(ryan, gang.get(i));
			scum = gang.get(i);
		}

		if(!ryan.isFrozen() && !ryan.getPerso().youDeadMan()){
			switch (cr) {
				case LEFT:
						if(slickRange || scumRange){
							getKicked(ryan,((slickRange)?slick:scum));
							
						}
						else{
							ryan.setX(Math.max(ryan.getX()-1, 0));
						}
					break;

				case DOWN:
						if(slickRange || scumRange){
							getKicked(ryan,((slickRange)?slick:scum));
							
						}
						else{
							ryan.setZ(Math.max(ryan.getZ()-1, 0));
						}
					break;
				case UP:
					if(slickRange || scumRange){
						getKicked(ryan,((slickRange)?slick:scum));
						
					}
					else{
						ryan.setZ(Math.min(ryan.getZ()+1, width-1));
					}
					break;

				case RIGHT:
					if(slickRange || scumRange){
						getKicked(ryan,((slickRange)?slick:scum));
						
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
						getKicked(slick, ryan);
						break;
					}
					if(scumRange)
					{
						getKicked(scum, ryan);
						break;
					}
					System.out.println("Ryan Kicked in the void, what a loser");
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
		} 
		
		alex.decFreeze();
		ryan.decFreeze();
		slick.decFreeze();
		
		for(int i=0;i<gang.size();i++)
			gang.get(i).decFreeze();

		/*Check for pit*/
		if(!alex.getPerso().youDeadMan() && terrain.getBlocCoord(alex.getX(), alex.getY(), alex.getZ()).isPit()){
			alex.getPerso().retraitHP(Integer.MAX_VALUE); 
			System.out.println("Alex fell in a pit and died miserabily");
		}
		if(!ryan.getPerso().youDeadMan() && terrain.getBlocCoord(ryan.getX(), ryan.getY(), ryan.getZ()).isPit()){
			ryan.getPerso().retraitHP(Integer.MAX_VALUE); 
			System.out.println("ryan fell in a pit and died miserabily");
		}
		if(!slick.getPerso().youDeadMan() && terrain.getBlocCoord(slick.getX(), slick.getY(), slick.getZ()).isPit()){
			slick.getPerso().retraitHP(Integer.MAX_VALUE); 
			System.out.println("slick fell in a pit and died miserabily");
		}
		
		for(int i=0;i<gang.size();i++){
			if(!gang.get(i).getPerso().youDeadMan() && terrain.getBlocCoord(gang.get(i).getX(), gang.get(i).getY(), gang.get(i).getZ()).isPit()){
				gang.get(i).getPerso().retraitHP(Integer.MAX_VALUE); 
				System.out.println("A Scumbag fell in a pit and died miserabily");
			}
		}
		step++;
	}

	private void printStep(Commande ca,Commande cr) {
		
		System.out.println("========-"+step+"-=======");
		
		System.out.println("Alex: X:"+alex.getX()+" Y:"+alex.getY()+" Z:"+alex.getZ() + " HP:"+alex.getPerso().getHp());
		System.out.println("Ryan: X:"+ryan.getX()+" Y:"+ryan.getY()+" Z:"+ryan.getZ()+" HP:"+ryan.getPerso().getHp());
		System.out.println("Slick: X:"+slick.getX()+" Y:"+slick.getY()+" Z:"+slick.getZ());
		System.out.println("========-COMMANDS-========");
		System.out.println("Alex does: "+ca);
		System.out.println("Ryan does: "+cr);
		System.out.println("==========--Stuff Happening:==========");
		
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

	private void getKicked(StatusWrapperI kicked,StatusWrapperI kicking) {
		
		if(kicking.isFrozen())
		{
			System.out.println(kicking.getPerso().getNom()+" cannot kicked, he is frozen");
			return;
		}
		
		Commande dir = kicked.getDirection();
		System.out.println(kicked.getPerso().getNom()+"  gets KICKED IN THE CROTCH by "+kicking.getPerso().getNom());
		switch(dir){
			case DOWN:
				kicked.setZ(Math.max(0,kicked.getZ()-3));
				break;
			case UP:
				kicked.setZ(Math.min(width-1,kicked.getZ()+3));
				break;
			case RIGHT:
				kicked.setX(Math.max(0, kicked.getX()-3));
				break;
			case LEFT:
				kicked.setX(Math.min(length-1,kicked.getX()-3));
				break;
			
			default:
				return;
		}
		kicked.getPerso().retraitHP(kicking.getPerso().getForce());
		kicked.setFreeze(3);
		
		
	}

}
