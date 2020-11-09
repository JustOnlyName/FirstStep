package inheritance;

public class Test {
	public static void main(String[] args) {
		ClassA a = new ClassB();
		a.printValue();
		ClassB classb = new ClassB();
		classb.printValue();
		ClassA classa = (ClassA)classb;
		classa.printValue();
	}
}

class ClassA{
	public void printValue() {
		System.out.println("classA");
	}
}

class ClassB extends ClassA {
	public void printValue() {
		System.out.println("classB");
	}
}