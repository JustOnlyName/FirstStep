package senior.generic;

public class GenericTest {
	public static void main(String[] args) {
		Point2<Integer,Integer> p1=new Point2<Integer,Integer>();
		p1.setX(10);
		p1.setY(10);
		int x =p1.getX();
		int y = p1.getY();
		System.out.println("This point is : "+x+","+y);
		
		Point2<Double,String> p2 = new Point2<Double,String>();
		p2.setX(5.4);
		p2.setY("dong10");
		double m = p2.getX();
		String n = p2.getY();
		System.out.println("This point 2 is :"+m+","+n);
	}
}

class Point2<T1,T2>{
	T1 x;
	T2 y;
	
	public T1 getX() {
		return x;
	}
	
	public void setX(T1 x) {
		this.x = x;
	}
	
	public T2 getY() {
		return y;
	}
	
	public void setY(T2 y) {
		this.y = y;
	}
}