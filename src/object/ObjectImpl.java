package object;

import java.util.Random;

public class ObjectImpl implements ObjectI {

	String nom;
	Type type;
	int power;
	int value;
	public ObjectImpl(String nom, Type type, int i) {
		super();
		init(nom,type,i);
	}
	@Override
	public void init(String s, Type t, int i) {
		this.nom = s;
		this.type = t;
		if(t == Type.Usable){
			this.power = i;
			this.value = 0;
		}else{
			this.value = i;
			this.power = 0;
		}
	}
	@Override
	public String getNom() {
		return nom;
	}
	@Override
	public Type getType() {

		return type;
	}
	@Override
	public int getPower() {
		return power;
	}
	@Override
	public int getValue() {
		return value;
	}

	public static ObjectImpl randomObjectCreator(){
		Random r = new Random();
		Type t = (r.nextDouble()>0.5)?Type.Sellable:Type.Usable;
		int val = (int) ((r.nextGaussian()+10)+(r.nextDouble()*r.nextInt(10)));
		return new ObjectImpl("Object", t, val);
	}



}
