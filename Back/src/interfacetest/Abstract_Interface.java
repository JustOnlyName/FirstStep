package interfacetest;

public class Abstract_Interface {
	public void test(A a) {
		a.doSth();
	}
	public static void main(String[] args) {
		Abstract_Interface demo = new Abstract_Interface();
		A a = new B();
		demo.test(a);
	}
}

interface A{
	public int doSth();
}

class B implements A{
	public int doSth() {
		System.out.println("This is B");
		return 1;
	}
}