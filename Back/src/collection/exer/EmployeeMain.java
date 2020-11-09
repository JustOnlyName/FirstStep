package collection.exer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class EmployeeMain {
	public static void main(String[] args) {
		new EmployeeMain().test2();
	}
	
	//使用自然排序
	public void test1() {
		TreeSet set = new TreeSet();
		set.add(new Employee("name",12,new MyDate(2020,1,1)));
		set.add(new Employee("name2",12,new MyDate(2020,1,1)));
		set.add(new Employee("name3",12,new MyDate(2020,1,1)));
		set.add(new Employee("name3",22,new MyDate(2020,1,1)));
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
	
	public void test2() {
		@SuppressWarnings("unchecked")
		TreeSet set = new TreeSet(new Comparator() {
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Employee && o2 instanceof Employee) {
					Employee e1 = (Employee) o1;
					Employee e2 = (Employee) o2;
					
					MyDate birthday1 = e1.getBrithday();
					MyDate birthday2 = e2.getBrithday();
					
					return birthday1.compareTo(birthday2);
				}
				throw new RuntimeException();
			}
		});
		
		set.add(new Employee("name",12,new MyDate(2019,1,1)));
		set.add(new Employee("name2",12,new MyDate(2018,1,1)));
		set.add(new Employee("name3",12,new MyDate(2017,1,1)));
		set.add(new Employee("name3",22,new MyDate(2017,2,1)));
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
