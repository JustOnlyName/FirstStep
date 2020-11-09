package prepare_interview;

class Value {
	public int i = 15;
}

public class Test {
	public static void main(String[] args) {
		new Test().first();
	}

	private void first() {
		int i = 5;
		Value v = new Value();
		v.i = 25;
		second(v, i);
		System.out.println(v.i);
	}

	private void second(Value v, int i) {
		i = 0;
		v.i = 20;
		Value val = new Value();
		v = val;
		System.out.println(v.i + " " + i);
	}
}
