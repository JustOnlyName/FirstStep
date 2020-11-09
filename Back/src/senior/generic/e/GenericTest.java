package senior.generic.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest {
	public static void main(String[] args) {
		new GenericTest().test3();
	}
	
	public void test() {
		ArrayList list = new ArrayList();
		//添加学生成绩  -->  int 型
		list.add(89);
		list.add(22);
		list.add(90);
		//问题一：类型不安全，编译、运行阶段都不报错
		list.add("Tom");
		
		for(Object score:list) {
			//混进来的 "Tom" 字符串类型，强转时，可能出现ClassCastException 
			int stuScore = (int) score;
			System.out.println(stuScore);
		}
	}
	
	private void test1() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(89);
		arrayList.add(22);
		arrayList.add(90);
		ArrayList<?> arrayList2 = null; 
		arrayList2 = arrayList;
	}
	
	public void print(List<?> list) {
		Iterator<?> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public void test3() {
		List<? extends Person> list1 = null;
		List<? super Person> list2 = null;
		
		List<Student> list3 = new ArrayList<Student>();
		List<Person> list4 = new ArrayList<Person>();
		List<Object> list5 = new ArrayList<Object>();
		
		list4.add(new Person());
		
		//读取数据
		list1 = list3;
		Person person = list1.get(0);
		Object object = list1.get(0);
		
		list2 = list4;
		Object object2 = list2.get(0);
		list2.add(new Student());
		list2.add(new Person());
		
		
	}
}

