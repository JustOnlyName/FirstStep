package senior.generic.exer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class EmployeeMain {
	public static void main(String[] args) {
		new EmployeeMain().test1();
	}
	
	//使用自然排序
	public void test1() {
//		TreeSet set = new TreeSet();
		TreeSet<Employee> set = new TreeSet<Employee>();
		set.add(new Employee("name",12,new MyDate(2020,1,1)));
		set.add(new Employee("name2",12,new MyDate(2020,1,1)));
		set.add(new Employee("name3",12,new MyDate(2020,1,1)));
		set.add(new Employee("name3",22,new MyDate(2020,1,1)));
		
//		Iterator iterator = set.iterator();
		Iterator<Employee> iterator = set.iterator();
		while(iterator.hasNext()) {
			Employee next = iterator.next();
			System.out.println(next);
		}
		
	}
	
	public void test2() {
		@SuppressWarnings("unchecked")
		TreeSet<Employee> set = new TreeSet<Employee>(new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2) {
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
