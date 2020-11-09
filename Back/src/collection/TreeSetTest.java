package collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSetTest x = new TreeSetTest();
		x.test1();
	}
	
	public void test1() {
		Comparator comparator = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Person && o2 instanceof Person) {
					Person p1 = (Person) o1;
					Person p2 = (Person) o2;
					return Integer.compare(p1.getAge(), p2.getAge());
				}else {
					throw new RuntimeException("输入的数据类型不匹配");
				}
			}
		};
		
		TreeSet treeSet = new TreeSet(comparator);
		
		treeSet.add(new Person("Jack",29));
		treeSet.add(new Person("Jack",22));
		treeSet.add(new Person("Tom",12));
		
		Iterator iterator = treeSet.iterator();
		while(iterator.hasNext()){
		    System.out.println(iterator.next());
		}
	}
	
}
