package interfacetest.jdk8features;

public class InterfaceTestClass{
	public static void main(String[] args) {
		SubClass s = new SubClass();
		s.method3();
	}
}

class SuperClass{
	public void method3() {
		System.out.println("superclass method3");
	}
}

class SubClass extends SuperClass implements InterfaceTestA,InterfaceTestB{

	@Override
	public void method3() {
		System.out.println("subclass: method3");
	}
	
	public void myMethod() {
		method3();   //调用子类自己的method3 方法
		super.method3();   //调用父类的method3 方法
		InterfaceTestA.super.method3();   //调用接口中的method3 方法
		InterfaceTestB.super.method3();
	}
}