package commonclass.string;

public class StringHeapConstant {
	
	String str = new String("good");
	char[] ch = {'t','e','s','t'};
	
	public void change(String str, char ch[]) {
		str = "test ok";
		ch[0] = 'b';
	}
	
	public static void main(String[] args) {
		StringHeapConstant shc = new StringHeapConstant();
		shc.change(shc.str, shc.ch);
		System.out.println(shc.str + shc.ch);
		
		String s1 = "java";
		String s2 = "hadoop";

		String s3 = "javahadoop";
		String s4 = "java" + "hadoop";
		String s5 = s1 + "hadoop";
		String s6 = "java" + s2;
		String s7 = s1 + s2;

		System.out.println(s3 == s4);// true
		System.out.println(s3 == s5);// false
		System.out.println(s3 == s6);// false
		System.out.println(s3 == s7);// false
		System.out.println(s5 == s6);// false
		System.out.println(s5 == s7);// false
		System.out.println(s6 == s7);// false

		String s8 = s5.intern();
		System.out.println(s3 == s8);

		String s = "0";
		for (int i = 1; i <= 5; i++) {
			s += i;
		}
		System.out.println(s);
	}
	
	
}
