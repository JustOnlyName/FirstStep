package senior.generic;

import java.util.Arrays;

public class TestGeneric {
	public static void main(String[] args) {
		String s[] = {"aa","bb","cc","dd","ee"};
		Arrays.fill(s, "A");
		System.out.println(Arrays.toString(s));
	}
}

class MyCollection<T>{
	Object []objs = new Object[5];
	
	public void set(T obj,int index) {
		objs[index]=obj;
	}
	
	public Object get(int index) {
		return (T)objs[index];
	}
}