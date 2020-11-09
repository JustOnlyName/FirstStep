package test;

public class Demo {
	public static void main(String[] args) {
		Master ma=new Master();
		ma.feed(new Animal(), new Food());
		ma.feed(new Cat(),new Fish());
		ma.feed(new Dog(), new Bone());
	}
}

class Food{
	public String getFood() {
		return "ʳ��";
	}
}

class Fish extends Food{
	public String getFood() {
		return "��";
	}
}

class Bone extends Food{
	public String getFood() {
		return "��ͷ";
	}
}

class Animal {
	public void eat(Food f) {
		System.out.println("����һֻ������ڳ�"+f.getFood());
	}
}

class Cat extends Animal{
	public void eat(Food f) {
		System.out.println("����һֻè�����ڳ�"+f.getFood());
	}
}
	
class Dog extends Animal{
	public void eat(Food f) {
		System.out.println("����һֻ�������ڳ�"+f.getFood());
	}
	
}

class Master {
	public void feed(Animal a,Food f) {
		a.eat(f);
	}
}