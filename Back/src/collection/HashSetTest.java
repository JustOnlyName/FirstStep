package collection;

import java.util.HashSet;

public class HashSetTest {
	public static void main(String[] args) {
		int n = 10;
		int m;
		System.out.println((m=n)<40);
		System.out.println(m);
		new HashSetTest().test1();
	}

	private void test1() {
		HashSet hashSet = new HashSet();
		Person p1 = new Person("AA",1001);
		Person p2 = new Person("BB", 1002);
		
		hashSet.add(p1);
		hashSet.add(p2);
		System.out.println(hashSet);
		p1.setName("CC");
		hashSet.remove(p1);
		System.out.println(hashSet);
		hashSet.add(new Person("CC",1001));
		System.out.println(hashSet);
		hashSet.add(new Person("AA",1001));
		System.out.println(hashSet);
	}
}
