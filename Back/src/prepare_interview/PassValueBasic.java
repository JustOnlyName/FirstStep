package prepare_interview;

public class PassValueBasic {
//	public static void main(String[] args) {
//		StringBuffer string = new StringBuffer("hello");
//		System.out.println("before test():" + string);
//		test(string);
//		System.out.println("after test():" + string);
//	}
//
//	private static void test(StringBuffer string) {
//		string = new StringBuffer("world");
//	}
	
	
	public static void main(String[] args) {
		String string = "hello";
		test(string);
		System.out.println(string);
	}

	private static void test(String string) {
		string += "world";
		System.out.println(string);
	}
}
