package map;

public class Person implements Comparable{
	String name;
	int age;

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

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	//姓名从大到小，年龄从小到大
	@Override
	public int compareTo(Object o) {
		if(o instanceof Person) {
			Person p = (Person) o;
			int compare = -this.name.compareTo(p.getName());
			if(compare!=0) {
				return compare;
			}else {
				return Integer.compare(this.age, p.getAge());
			}
		}else {
			throw new RuntimeException();
		}
	}

	
}
