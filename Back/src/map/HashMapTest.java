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
		map.put("AA",123);   //һ������£�key-value �������Ͳ����ϸ�Ҫ��
		map.put(45,12);   //ͨ��ʵ�ʿ�������£�key String   value  Integer
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
		
		//value ���Ը���ʵ�����壬��ɼ�
		Map map = new TreeMap();
		map.put(p1, 88);
		map.put(p2, 98);
		map.put(p3, 76);
		map.put(p4, 100);
		
		Set entrySet = map.entrySet();
		Iterator iterator2 = entrySet.iterator();
		while (iterator2.hasNext()) {
		    Object object = iterator2.next();
		    Map.Entry entry = (Map.Entry)object;   //ǿתΪMap �ڲ��ӿ�Entry ������ʹ�ò���key value �ķ���
		    System.out.println(entry.getKey()+"---->"+entry.getValue());
		}
	}
	
	public void test3() throws Exception {
		Properties pros = new Properties();
		FileInputStream fis = new FileInputStream("jdbc.properties");
		pros.load(fis);   //��������Ӧ���ļ�
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
