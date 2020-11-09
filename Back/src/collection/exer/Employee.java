package collection.exer;

public class Employee implements Comparable{
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
	public int compareTo(Object o){
	    if(o instanceof Employee){
	        Employee person = (Employee)o;
	        return this.name.compareTo(person.name);   //按照姓名从小到大排列
	    }else{
	        throw new RuntimeException("输入的类型不匹配");
	    }
	}

}
