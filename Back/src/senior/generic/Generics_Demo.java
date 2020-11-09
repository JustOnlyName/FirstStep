package senior.generic;

public class Generics_Demo {
	public static void main(String[] args) {
		Point<Integer,Integer> p1=new Point<Integer,Integer>();
		p1.setX(20);
		p1.setY(10);
		p1.printPoint(p1.getX(), p1.getY());
		
		Point<Double,String> p2=new Point<Double,String>();
		p2.setX(20.1);
		p2.setY("¶«¾­0¡ã");
		p2.printPoint(p2.getX(), p2.getY());
	}
}

class Point<T1,T2>{
	T1 x;
	T2 y;
	
	public Object getX() {
		return x;
	}
	
	public void setX(T1 x) {
		this.x = x;
	}
	
	public Object getY() {
		return y;
	}
	
	public void setY(T2 y) {
		this.y = y;
	}
	
	public <V1,V2> void printPoint(V1 x,V2 y) {
		V1 m=x;
		V2 n=y;
		System.out.println("This point is :"+m+','+n);
	}
}