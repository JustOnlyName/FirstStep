package interfacetest;

public class Abstract_Interface_ABC {
	public static void main(String[] args) {
		AA a=new CC();
		BB b=(BB)a;
	}
}

interface AA {
	public void method1();
}

interface BB extends AA{
	public void method2();
}

class CC implements AA,BB{
	public void method1() {
		
	}
	
	public void method2() {
		
	}
}
