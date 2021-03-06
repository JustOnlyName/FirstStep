package senior.generic;

public class Person {
	private String name;
	public int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	private Person(String name) {
		this.name = name;
	}

	public Person() {
		System.out.println("Person()");
	}
	
	@Override
	public String toString() {
		return "Person {name=" + name + ", age=" + age + "}";
	}

	public void show() {
		System.out.println("你好，我是人");
	}

	private String showNation(String nation) {
		System.out.println("My COUNTRY IS " + nation);
		return nation;
	}
	
	private static void showDesc() {
		System.out.println("我是一个可爱的人");
	}
}
