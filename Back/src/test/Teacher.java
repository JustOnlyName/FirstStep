package test;

public class Teacher extends People {
	String school;
	String subject;
	int name;
	
	public Teacher() {
		super("", 12, 12, 12);
		System.out.println("teacher son constructor");
	}

	public static void say1() {
		
	}
	
	public static void say1(int name) {
		
	}
	
	public Teacher get(int i) {
		return this;
	}

	//���� People ���е�say() ����
	void say() {
		System.out.println("��һ�仰");
	}
	
	void lecturing() {
		System.out.println("Teach subject is�� "+subject);
	}
		
	@Override
	public String toString() {
		return "Teacher [school=" + school + ", subject=" + subject + ", name=" + name + ", age=" + age + ", height="
				+ height + ", money=" + money + "]";
	}

	public static void main(String[] args) {
		Teacher teacher = new Teacher();
		teacher.money = 10;
		teacher.school = "fdfd";
		People people = teacher;
		Teacher teacher2 = (Teacher)people;
		people.money = 20;
		people.age = 1;
		System.out.println(teacher);
		System.out.println(people);
		System.out.println(teacher2);
		
		
	}

}


