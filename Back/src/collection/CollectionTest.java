package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import senior.generic.Person;

public class CollectionTest {
	public static void main(String[] args) {
		Collection collection = new ArrayList();
		
		/*
		 * add(Object e) 将元素e 添加到集合collection 中
		 */
		collection.add("aa");
		collection.add(12);//自动装箱，Object 类型对象
		collection.add(new String("Tom"));
		collection.add(new Person("Tom",12));
		
		/*
		 * size() 获取添加的元素的个数
		 */
//		System.out.println(collection.size());
		
		/*
		 * addAll(Collection c) 将collection 集合中元素添加到当前集合中 
		 */
		Collection collection2 = new ArrayList();
		collection2.add(456);
		collection2.addAll(collection);
		
		/*
		 * isEmpty() 判断当前集合是否有元素
		 */
		
		/*
		 * contains(Object obj) 判断当前集合中是否包含对象obj
		 */
		System.out.println(collection.contains(12));
		System.out.println(collection.contains(new String("Tom")));
		System.out.println(collection.contains(new Person("Tom",12)));
		
		
		/*
		 * Arrays 工具类的asList(Object ... args) 工具方法，通过可变形参，返回一个列表
		 */
		collection = Arrays.asList(123,45);
		
		/*
		 * 先找是否存在obj 对象，找到返回true，未找到返回false
		 */
		boolean remove = collection.remove(123);
		
		List<String> asList = Arrays.asList(new String[] {"AA","BB","CC"});
		
		
		Iterator iterator = collection.iterator();
		
		/*
		 * next() 方法
		 */
		iterator.next();
		for(int i = 0;i<collection.size();i++) {
			System.out.println(iterator.next());
		}
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
