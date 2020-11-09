package senior.generic;

public class Interface_Abstract_ABC {
	public static void main(String[] args) {
		B b=new C();
		A a=(A)b;
	}
}

abstract class A{
	public abstract void method1();
}

abstract class B extends A{
	public abstract void method2();
}

class C extends B{
	public void method2() {
		
	}

	public void method1() {
		
	}
}