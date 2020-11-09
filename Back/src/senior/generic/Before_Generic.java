package senior.generic;

public class Before_Generic {
	public static void main(String[] args) {
		Point1 point1 = new Point1();
		
		point1.setX(10);
		point1.setY(20);
		System.out.println("This point is :"+point1.getX()+","+point1.getY());
		
		Point1 point2 = new Point1();
		point2.setX("dong108");
		point2.setY(20.5);
		System.out.println("This point is :"+point2.getX()+","+point2.getY());
	}	
}

class Point1{
	Object x=0;
	Object y=0;
	
	public Object getX() {
		return x;
	}
	
	public void setX(Object x) {
		this.x = x;
	}
	
	public Object getY() {
		return y;
	}
	
	public void setY(Object y) {
		this.y = y;
	}
}