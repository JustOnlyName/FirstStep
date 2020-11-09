package inheritance;

public class StaticFun {
	public static void main(String[] args) {
		StaticFun sf = new StaticFun();
		try {
			Object clone = sf.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Father {
	public static String getName() {
		return "Father";
	}
}

class Child extends Father{
	
	public Child() {
		
	}
	public static String getName() {
		return "Child";
	}
}