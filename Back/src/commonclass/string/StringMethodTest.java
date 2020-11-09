package commonclass.string;

public class StringMethodTest {
	public static void main(String[] args) {
		String s1 = "HelloWorld";
		String s2 = "HelloWorld";
		System.out.println(s1.length());
		System.out.println(s2.isEmpty());
		
		s1 = s1.replace("l", "w");
		System.out.println(s1);
		String s3 = s1.replaceAll("\\d*", ".");
		System.out.println(s3);
	}
}
