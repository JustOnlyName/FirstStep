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
		 * add(Object e) ��Ԫ��e ��ӵ�����collection ��
		 */
		collection.add("aa");
		collection.add(12);//�Զ�װ�䣬Object ���Ͷ���
		collection.add(new String("Tom"));
		collection.add(new Person("Tom",12));
		
		/*
		 * size() ��ȡ��ӵ�Ԫ�صĸ���
		 */
//		System.out.println(collection.size());
		
		/*
		 * addAll(Collection c) ��collection ������Ԫ����ӵ���ǰ������ 
		 */
		Collection collection2 = new ArrayList();
		collection2.add(456);
		collection2.addAll(collection);
		
		/*
		 * isEmpty() �жϵ�ǰ�����Ƿ���Ԫ��
		 */
		
		/*
		 * contains(Object obj) �жϵ�ǰ�������Ƿ��������obj
		 */
		System.out.println(collection.contains(12));
		System.out.println(collection.contains(new String("Tom")));
		System.out.println(collection.contains(new Person("Tom",12)));
		
		
		/*
		 * Arrays �������asList(Object ... args) ���߷�����ͨ���ɱ��βΣ�����һ���б�
		 */
		collection = Arrays.asList(123,45);
		
		/*
		 * �����Ƿ����obj �����ҵ�����true��δ�ҵ�����false
		 */
		boolean remove = collection.remove(123);
		
		List<String> asList = Arrays.asList(new String[] {"AA","BB","CC"});
		
		
		Iterator iterator = collection.iterator();
		
		/*
		 * next() ����
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
