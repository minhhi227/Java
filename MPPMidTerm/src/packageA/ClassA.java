package packageA;

public abstract class ClassA {
	public static ClassA getInstance(String msg){
		if(msg=="1") return new Subclass1();
		else if(msg=="2") return new Subclass2();
		return null;
	}
}
