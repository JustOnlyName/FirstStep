package senior.generic.exer;

public class Employee implements Comparable<Employee>{
	private String name;
	private int age;
	private MyDate brithday;

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

	public MyDate getBrithday() {
		return brithday;
	}

	public void setBrithday(MyDate brithday) {
		this.brithday = brithday;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", brithday=" + brithday + "]";
	}

	public Employee(String name, int age, MyDate brithday) {
		this.name = name;
		this.age = age;
		this.brithday = brithday;
	}

	public Employee() {
	}


	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.name);      //所以不需要像上面一样，先判断o 是不是Employee 对象
	}

}
