package object;

public class ObjectImpl implements ObjectI {
	
	String nom;
	Type type;
	int power;
	int value;
	public ObjectImpl(String nom, Type type, int power, int value) {
		super();
		
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
	
	
	
}