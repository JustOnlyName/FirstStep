package innerclass;

public class Instanceof {
	public static void main(String[] args) {
		Animal obj = new Animal();
		if(obj instanceof Object) 
			System.out.println("I am a Object.");
		if(obj instanceof People)
			System.out.println("I am a People");
		if(obj instanceof Teacher)
			System.out.println("I am a Teacher");
		if(obj instanceof Cat)
			System.out.println("I am a Cat");
		
		obj = new Teacher();
		if(obj instanceof Object) 
			System.out.println("I am a Object.");
		if(obj instanceof People)
			System.out.println("I am a People");
		if(obj instanceof Teacher)
			System.out.println("I am a Teacher");
		if(obj instanceof Cat)
			System.out.println("I am a Cat");
		
		obj = new Cat();
		if(obj instanceof Object) 
			System.out.println("I am a Object.");
		if(obj instanceof People)
			System.out.println("I am a People");
		if(obj instanceof Teacher)
			System.out.println("I am a Teacher");
		if(obj instanceof Cat)
			System.out.println("I am a Cat");
	}
}

class Animal{}
class People extends Animal{}
class Teacher extends People{}
class Cat extends Animal{}