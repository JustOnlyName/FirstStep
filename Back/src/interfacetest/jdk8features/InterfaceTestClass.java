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
		method3();   //���������Լ���method3 ����
		super.method3();   //���ø����method3 ����
		InterfaceTestA.super.method3();   //���ýӿ��е�method3 ����
		InterfaceTestB.super.method3();
	}
}