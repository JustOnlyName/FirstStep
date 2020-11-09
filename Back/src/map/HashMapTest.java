package map;

import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

public class HashMapTest {
	public static void main(String[] args) throws Exception {
		new HashMapTest().test4();
	}
	
	public void test1() {
		Map map = new HashMap();
		/*
		 * put(Object key,Object value)
		 */
		map.put("AA",123);   //一般情况下，key-value 数据类型并不严格要求
		map.put(45,12);   //通常实际开发情况下，key String   value  Integer
		map.put("AA",33);
		System.out.println(map);
		
		Set keySet = map.keySet();
		Iterator iterator = keySet.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
		
		System.out.println();
		
		Set entrySet = map.entrySet();
		Iterator iterator2 = entrySet.iterator();
		while (iterator2.hasNext()) {
			Object object = iterator2.next();
			Map.Entry entry = (Map.Entry)object;
			System.out.println(entry.getKey()+"---->"+entry.getValue());
		}
	}
	
	public void test2() {
		Person p1 = new Person("Tom", 23);
		Person p2 = new Person("Jerry", 22);
		Person p3 = new Person("Jack", 20);
		Person p4 = new Person("Rose", 18);
		
		//value 可以赋予实际意义，如成绩
		Map map = new TreeMap();
		map.put(p1, 88);
		map.put(p2, 98);
		map.put(p3, 76);
		map.put(p4, 100);
		
		Set entrySet = map.entrySet();
		Iterator iterator2 = entrySet.iterator();
		while (iterator2.hasNext()) {
		    Object object = iterator2.next();
		    Map.Entry entry = (Map.Entry)object;   //强转为Map 内部接口Entry ，可以使用操作key value 的方法
		    System.out.println(entry.getKey()+"---->"+entry.getValue());
		}
	}
	
	public void test3() throws Exception {
		Properties pros = new Properties();
		FileInputStream fis = new FileInputStream("jdbc.properties");
		pros.load(fis);   //加载流对应的文件
		String name = pros.getProperty("name");
		String password= pros.getProperty("password");
		System.out.println("name="+name+",passwor="+password);
	}
	
	public void test4() {
		List list = new ArrayList();
		list.add(12);
		list.add(23);
		list.add(34);
		list.add(45);

		List list2 = new ArrayList();
		Collections.copy(list2, list);
		System.out.println(list2);
		
		List synchronizedList = Collections.synchronizedList(list);
	}
}
