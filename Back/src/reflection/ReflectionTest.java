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
	
	//在学反射之前，能够对Person 类怎么操作
	public static void main(String[] args) throws Exception {
		//1. 创建Person 类对象
		Person p1=new Person("Main", 12);
		
		//2. 通过对象，调用其内部成员  方法
		p1.age=10;
		System.out.println(p1);;
		
		//3. Person 类外部，无法调用其私有结构
		
		
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
	
	//学习反射之后，能够做到上述操作
	//反射方式创建Person 类的对象
	//clazz  是Class 的对象，是Person 类的
	public void testReflectionConstructor(Class clazz) throws Exception {
		//有了clazz 可以获得到 Person 类的很多内容
//			clazz.getConstructor(String.class,Integer.class);
		//获得到是Constructor 对象，赋值给 这种 对象
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		
		//获得了构造器，我们就可以 通过构造器造对象
//			constructor.newInstance("Tom",12);
		//赋值给所有类的父类 Object 引用的实例
		Object obj = constructor.newInstance("testReflectionConstructor",11);
		//此处我们实际上知道obj 类实际的类，可以进行一下强转
		//也可以不强转，使用tostring()  方法看看使用的是谁的toString() 方法
		System.out.println(obj.toString());
	}
	
	//此 通过反射调用对象所创建的属性
	public void testReflectionField(Class clazz) throws Exception {
		Field field = clazz.getField("age");
		Object obj = clazz.getConstructor(String.class,int.class).newInstance("testReflectionField",12);
		field.set(obj,10);
		System.out.println(obj.toString());
	}
	
	//反射方式 调方法
	public void testReflectionMethod(Class clazz) throws Exception {
		Object obj = clazz.getConstructor(String.class,int.class).newInstance("testReflectionMethod",13);

		Method method = clazz.getMethod("show");
		method.invoke(obj);
	}
	
	public void testDeclaredConstructor(Class clazz) throws Exception{
		//调用 私有的结构   
		Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
		declaredConstructor.setAccessible(true);
		Object obj = declaredConstructor.newInstance("testDeclaredConstructor");
		System.out.println(obj.toString());
	}
	
	public void testDeclaredField(Class clazz) throws Exception{
		//直接修改 实例对象的私有属性
		Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class,int.class);
		declaredConstructor.setAccessible(true);
		Object obj = declaredConstructor.newInstance("修改前",10);
		System.out.println(obj);
		Field field = clazz.getDeclaredField("name");   //这里参数为 私有属性变量名
		field.setAccessible(true);
		field.set(obj, "testDeclaredField");
		System.out.println(obj);
	}
	
	public void testDeclaredMethod(Class clazz) throws Exception{
		//调用私有方法   showNation
		Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class,int.class);
		declaredConstructor.setAccessible(true);
		Object obj = declaredConstructor.newInstance("修改前",10);
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
//		//以流的方式获取一个资源  但资源位置不在工程下，而是默认在当前工程的src 下
//		InputStream is = classLoader.getResourceAsStream("jdbc.properties");
//		properties.load(is);
	}
	
	public void testClassforName() {
		for(int i = 0 ;i<100;i++) {
			int num = new Random().nextInt(3);  //只能获得0 1 2
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
	 * 创建一个指定类的对象
	 * @param classPath 指定类的全类名
	 */
	public Object getClassforNameInstance(String classPath) throws Exception{
		Class clazz =  Class.forName(classPath);
		return clazz.newInstance();
	}
	
	/**
	 * 获取类中public 型的属性
	 * 如果 有父类，父类也有父类，依次循环将 所有涉及到的父类 和本类
	 * public 类型的 变量类型、变量名获取
	 * @param clazz clazz 所指的类
	 */
	public void getFields(Class clazz) {
		Field fields[] = clazz.getFields();
		for(Field field:fields) {
//			System.out.println(field);
		}
	}
	
	/**
	 * 获取本类中 所有属性相关的属性对应权限、类型、变量名
	 * 不包含 父类
	 */
	public void getDeclaredFields(Class clazz) {
		Field fields[] = clazz.getFields();
		for(Field field:fields) {
			//1. 权限修饰符
			int modifier = field.getModifiers();
			System.out.println(modifier);
			//这里返回的是int 数，具体含义需要到源码中了解
			//也可以使用Modifier 类toString(int modifier) 方法进行转换成权限名称
			System.out.print(Modifier.toString(modifier)+'\t');
			
			//2. 数据类型
			Class type = field.getType();
			System.out.print(type.getName()+'\t');
			
			//3. 变量名
			String fieldName = field.getName();
			System.out.println(fieldName);
			System.out.println();
		}
	}
	
	public void getDeclaredMethods(Class clazz) {
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for(Method method : declaredMethods) {
			//获取声明的注解
			Annotation annotations[] = clazz.getAnnotations();
			
			//权限修饰符
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
	 * 不常用的
	 * @param clazz
	 */
	public void setpublicField(Class clazz) throws Exception {
		//1. 创建运行时类的对象
		Object obj = clazz.newInstance();
		
		//2. 获取指定的属性  必须是 public 的
		Field field = clazz.getField("age");
		
		/*3. 设置d当前属性的值
		 * set()  方法
		 * param1: 指明设置哪个对象的属性
		 * param2: 将此属性值设置为多少
		 */
		field.set(obj,100);
		
		/*
		 * 有设置set()  也有get()  获取当前属性值
		 * param: 获取的对象
		 */
		System.out.println(field.get(obj));
	}
	
	public void setDeclaredField(Class clazz) throws Exception{
		//1. 创建运行时类的对象
		Object obj = clazz.newInstance();
		
		//2. 获取指定的属性
		Field declaredfield = clazz.getDeclaredField("name");
		declaredfield.setAccessible(true);
		declaredfield.set(obj, "setDeclaredField");
		System.out.println(declaredfield.get(obj));
		
	}
	
	public void useMethod(Class clazz) throws Exception{
		//1. 创建运行时类的对象
		Object obj = clazz.newInstance();
		
		/*
		 * 2. 获取指定的某个方法
		 * getDeclaredMethod ()
		 * param1: 指明、获取方法的名称
		 * param2: 因为重载的可能存在，指明获取到方法的形参列表各参数的类型
		 */
		Method declaredMethod = clazz.getDeclaredMethod("showNation", String.class);
		
		declaredMethod.setAccessible(true);
		/*
		 * 调用的意思 invoke
		 * param1: 方法的调用者，哪个对象
		 * param2: 给方法形参赋值的实参
		 * invoke() 方法的返回值即为对应类中调用的方法的返回值
		 */
		System.out.println(declaredMethod.invoke(obj, "China"));
		
		System.out.println("**static method**");
		
		Method declaredMethod2 = clazz.getDeclaredMethod("showDesc");
		declaredMethod2.setAccessible(true);
		declaredMethod2.invoke(clazz);
	}
	
	
	
}
