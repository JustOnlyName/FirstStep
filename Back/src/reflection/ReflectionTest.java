package reflection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Properties;
import java.util.Random;

public class ReflectionTest {
	
	//��ѧ����֮ǰ���ܹ���Person ����ô����
	public static void main(String[] args) throws Exception {
		//1. ����Person �����
		Person p1=new Person("Main", 12);
		
		//2. ͨ�����󣬵������ڲ���Ա  ����
		p1.age=10;
		System.out.println(p1);;
		
		//3. Person ���ⲿ���޷�������˽�нṹ
		
		
		Class clazz = Person.class;
		
		ReflectionTest re=new ReflectionTest();
//		re.testReflectionConstructor(Person.class);
//		re.testReflectionField(clazz);
//		re.testDeclaredConstructor(clazz);
//		re.testDeclaredField(clazz);
//		re.testDeclaredMethod(clazz);
//		re.testClassforName();
//		re.getFields(clazz);
//		re.getDeclaredFields(clazz);
//		re.getDeclaredMethods(clazz);
//		re.setpublicField(clazz);
//		re.setDeclaredField(clazz);
		re.useMethod(clazz);
		
//		ClassLoader classLoader = ReflectionTest.class.getClassLoader();
//		Class clazz4 = classLoader.loadClass("reflection.Person");
		
	}
	
	//ѧϰ����֮���ܹ�������������
	//���䷽ʽ����Person ��Ķ���
	//clazz  ��Class �Ķ�����Person ���
	public void testReflectionConstructor(Class clazz) throws Exception {
		//����clazz ���Ի�õ� Person ��ĺܶ�����
//			clazz.getConstructor(String.class,Integer.class);
		//��õ���Constructor ���󣬸�ֵ�� ���� ����
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		
		//����˹����������ǾͿ��� ͨ�������������
//			constructor.newInstance("Tom",12);
		//��ֵ��������ĸ��� Object ���õ�ʵ��
		Object obj = constructor.newInstance("testReflectionConstructor",11);
		//�˴�����ʵ����֪��obj ��ʵ�ʵ��࣬���Խ���һ��ǿת
		//Ҳ���Բ�ǿת��ʹ��tostring()  ��������ʹ�õ���˭��toString() ����
		System.out.println(obj.toString());
	}
	
	//�� ͨ��������ö���������������
	public void testReflectionField(Class clazz) throws Exception {
		Field field = clazz.getField("age");
		Object obj = clazz.getConstructor(String.class,int.class).newInstance("testReflectionField",12);
		field.set(obj,10);
		System.out.println(obj.toString());
	}
	
	//���䷽ʽ ������
	public void testReflectionMethod(Class clazz) throws Exception {
		Object obj = clazz.getConstructor(String.class,int.class).newInstance("testReflectionMethod",13);

		Method method = clazz.getMethod("show");
		method.invoke(obj);
	}
	
	public void testDeclaredConstructor(Class clazz) throws Exception{
		//���� ˽�еĽṹ   
		Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
		declaredConstructor.setAccessible(true);
		Object obj = declaredConstructor.newInstance("testDeclaredConstructor");
		System.out.println(obj.toString());
	}
	
	public void testDeclaredField(Class clazz) throws Exception{
		//ֱ���޸� ʵ�������˽������
		Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class,int.class);
		declaredConstructor.setAccessible(true);
		Object obj = declaredConstructor.newInstance("�޸�ǰ",10);
		System.out.println(obj);
		Field field = clazz.getDeclaredField("name");   //�������Ϊ ˽�����Ա�����
		field.setAccessible(true);
		field.set(obj, "testDeclaredField");
		System.out.println(obj);
	}
	
	public void testDeclaredMethod(Class clazz) throws Exception{
		//����˽�з���   showNation
		Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class,int.class);
		declaredConstructor.setAccessible(true);
		Object obj = declaredConstructor.newInstance("�޸�ǰ",10);
		System.out.println(obj);
		Method method = clazz.getDeclaredMethod("showNation", String.class);
		method.setAccessible(true);
		method.invoke(obj, "China");
		System.out.println(obj);
	}
	
	public void test() {
		int a[] = new int[10];
		int b[] = new int[100];
		System.out.println(a==b);
		Class c1 = a.getClass();
		Class c2 = b.getClass();
		System.out.println(c1==c2);
	}
	
	public void testClassLoaderproperties() throws Exception {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("jdbc.properties");
		properties.load(fis);
		
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		System.out.println(user+password);
		
//		Properties properties = new Properties();
//		ClassLoader classLoader = ReflectionTest.class.getClassLoader();
//		//�����ķ�ʽ��ȡһ����Դ  ����Դλ�ò��ڹ����£�����Ĭ���ڵ�ǰ���̵�src ��
//		InputStream is = classLoader.getResourceAsStream("jdbc.properties");
//		properties.load(is);
	}
	
	public void testClassforName() {
		for(int i = 0 ;i<100;i++) {
			int num = new Random().nextInt(3);  //ֻ�ܻ��0 1 2
			String classPath="";
			switch(num) {
				case 0:
					classPath="java.util.Date";
					break;
				case 1:
					classPath = "java.lang.Object";
					break;
				case 2:
					classPath="reflection.Person";
					break;
			}
			
			try {
				Object obj = getClassforNameInstance(classPath);
				System.out.println(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ����һ��ָ����Ķ���
	 * @param classPath ָ�����ȫ����
	 */
	public Object getClassforNameInstance(String classPath) throws Exception{
		Class clazz =  Class.forName(classPath);
		return clazz.newInstance();
	}
	
	/**
	 * ��ȡ����public �͵�����
	 * ��� �и��࣬����Ҳ�и��࣬����ѭ���� �����漰���ĸ��� �ͱ���
	 * public ���͵� �������͡���������ȡ
	 * @param clazz clazz ��ָ����
	 */
	public void getFields(Class clazz) {
		Field fields[] = clazz.getFields();
		for(Field field:fields) {
//			System.out.println(field);
		}
	}
	
	/**
	 * ��ȡ������ ����������ص����Զ�ӦȨ�ޡ����͡�������
	 * ������ ����
	 */
	public void getDeclaredFields(Class clazz) {
		Field fields[] = clazz.getFields();
		for(Field field:fields) {
			//1. Ȩ�����η�
			int modifier = field.getModifiers();
			System.out.println(modifier);
			//���ﷵ�ص���int �������庬����Ҫ��Դ�����˽�
			//Ҳ����ʹ��Modifier ��toString(int modifier) ��������ת����Ȩ������
			System.out.print(Modifier.toString(modifier)+'\t');
			
			//2. ��������
			Class type = field.getType();
			System.out.print(type.getName()+'\t');
			
			//3. ������
			String fieldName = field.getName();
			System.out.println(fieldName);
			System.out.println();
		}
	}
	
	public void getDeclaredMethods(Class clazz) {
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for(Method method : declaredMethods) {
			//��ȡ������ע��
			Annotation annotations[] = clazz.getAnnotations();
			
			//Ȩ�����η�
			int modifiers = method.getModifiers();
			
			System.out.print(method.getReturnType().getName()+"\t");
			
			System.out.print(method.getName()+"(");
			
			Class[] parameterTypes = method.getParameterTypes();
			if(!(parameterTypes == null && parameterTypes.length==0)) {
				for(int i =0;i<parameterTypes.length;i++) {
					if(i==parameterTypes.length-1) {
						System.out.print(parameterTypes[i].getName()+"args_"+i);
						break;
					}
					System.out.println(parameterTypes[i].getName()+" args_"+i+",");
				}
			    System.out.print(")");
			}
			
			System.out.println();
			
			Class[] exceptionTypes = method.getExceptionTypes();
			if(!(exceptionTypes == null && exceptionTypes.length==0)) {
				
			}
		}
	}
	
	/**
	 * �����õ�
	 * @param clazz
	 */
	public void setpublicField(Class clazz) throws Exception {
		//1. ��������ʱ��Ķ���
		Object obj = clazz.newInstance();
		
		//2. ��ȡָ��������  ������ public ��
		Field field = clazz.getField("age");
		
		/*3. ����d��ǰ���Ե�ֵ
		 * set()  ����
		 * param1: ָ�������ĸ����������
		 * param2: ��������ֵ����Ϊ����
		 */
		field.set(obj,100);
		
		/*
		 * ������set()  Ҳ��get()  ��ȡ��ǰ����ֵ
		 * param: ��ȡ�Ķ���
		 */
		System.out.println(field.get(obj));
	}
	
	public void setDeclaredField(Class clazz) throws Exception{
		//1. ��������ʱ��Ķ���
		Object obj = clazz.newInstance();
		
		//2. ��ȡָ��������
		Field declaredfield = clazz.getDeclaredField("name");
		declaredfield.setAccessible(true);
		declaredfield.set(obj, "setDeclaredField");
		System.out.println(declaredfield.get(obj));
		
	}
	
	public void useMethod(Class clazz) throws Exception{
		//1. ��������ʱ��Ķ���
		Object obj = clazz.newInstance();
		
		/*
		 * 2. ��ȡָ����ĳ������
		 * getDeclaredMethod ()
		 * param1: ָ������ȡ����������
		 * param2: ��Ϊ���صĿ��ܴ��ڣ�ָ����ȡ���������β��б������������
		 */
		Method declaredMethod = clazz.getDeclaredMethod("showNation", String.class);
		
		declaredMethod.setAccessible(true);
		/*
		 * ���õ���˼ invoke
		 * param1: �����ĵ����ߣ��ĸ�����
		 * param2: �������βθ�ֵ��ʵ��
		 * invoke() �����ķ���ֵ��Ϊ��Ӧ���е��õķ����ķ���ֵ
		 */
		System.out.println(declaredMethod.invoke(obj, "China"));
		
		System.out.println("**static method**");
		
		Method declaredMethod2 = clazz.getDeclaredMethod("showDesc");
		declaredMethod2.setAccessible(true);
		declaredMethod2.invoke(clazz);
	}
	
	
	
}
