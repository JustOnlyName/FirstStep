package test;

public class People {
	String name;
	int age;
	int height;
	int money;
	
	public People() {
		super();
		System.out.println("people father constructor");
	}

	public People(String name, int age, int height, int money) {
		System.out.println("people father with param constructor");
		this.name = name;
		this.age = age;
		this.height = height;
		this.money = money;
	}

	public Object get(int i) {
		return 1;
	}

	void say() {
		System.out.println("name is :"+name+",age is :"+age+",height is :"+height);
	}
	
	public int getMoney() {
		return money;
	}
	
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + ", height=" + height + ", money=" + money + "]";
	}

	public static void main(String[] args) {
		int m=50;
		Integer obj=new Integer(m);   //手动装箱
		int n = obj.intValue();   //手动拆箱
		System.out.println("n= "+n);
		
		Integer obj1=new Integer(50);
		System.out.println("obj 等价于obj1?"+obj.equals(obj1));
		
		m=50;
		obj=m;   //自动装箱
		n=obj;   //自动拆箱
		System.out.println("n="+n);
		
		System.out.println("obj 等价于obj1?"+obj.equals(obj1));
	}

}
