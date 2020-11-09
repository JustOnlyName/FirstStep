package interfacetest.exer;

public class Attrib_impl_extends extends B implements A {
	public void pX() {
//		System.out.println(x);
		System.out.println(super.x);
		System.out.println(A.x);
	}

	public static void main(String[] args) {
		new Attrib_impl_extends().pX();
	}
}

interface A {
	int x = 0;
}

class B {
	int x = 1;
}