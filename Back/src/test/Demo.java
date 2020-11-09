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
		return "食物";
	}
}

class Fish extends Food{
	public String getFood() {
		return "鱼";
	}
}

class Bone extends Food{
	public String getFood() {
		return "骨头";
	}
}

class Animal {
	public void eat(Food f) {
		System.out.println("我是一只动物，正在吃"+f.getFood());
	}
}

class Cat extends Animal{
	public void eat(Food f) {
		System.out.println("我是一只猫，正在吃"+f.getFood());
	}
}
	
class Dog extends Animal{
	public void eat(Food f) {
		System.out.println("我是一只狗，正在吃"+f.getFood());
	}
	
}

class Master {
	public void feed(Animal a,Food f) {
		a.eat(f);
	}
}