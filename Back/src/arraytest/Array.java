package arraytest;

import test.People;

public class Array {
	String name;
	int age;
	
	Array(){
		
	}
	
	Array(String name,int age){
		this.age=age;
		this.name=name;
	}
	
	public void test() {
		int j = 1;
		int k =0;
		if (j==1){
			k =1;
			System.out.println(k);
		}
		System.out.println(k);
	}
	
	double test(int a) {
		return 1.0;
	}
	
	public static void main(String[] args) {
		Array a = new Array();
		System.out.println(a.age+a.name);
		a.test();
	}
}
