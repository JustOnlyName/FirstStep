package interfacetest;

public class ImplementsDemo {
	public static void main(String[] args) {
		SataHdd sh1=new SegatzHdd();
		SataHdd sh2=new SamsangHdd();
	}
}

interface SataHdd{
	public static final int CONNECT_LINE=4;
	public void writeData(String data);
	public String readData() ;
}

interface fixHdd{
	String address="Beijing ";
	boolean doFix();
}

class SegatzHdd implements SataHdd,fixHdd{
	public String readData() {
		return "data";
	}

	public boolean doFix() {
		return true;
	}

	public void writeData(String data) {
		System.out.println("write complete");
	}
}

class SamsangHdd implements SataHdd{
	public void writeData(String data) {
		
	}

	public String readData() {
		return null;
	}
}