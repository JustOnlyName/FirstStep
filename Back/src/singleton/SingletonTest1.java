package singleton;

public class SingletonTest1 {
	public static void main(String[] args) {
		Bank bank1 = Bank.getInstance();
		Bank bank2 = Bank.getInstance();
		
		
	}
}

class Bank{
	//1. 私有化的构造器
	//这样，在其他类中无法创建该类对象
	private Bank() {
		
	}
	
	//2. 内部创建类的对象
	//4. 回来修改，要求此对象也必须声明为静态的
	private static Bank instance = new Bank();
	
	//3. 2 之后也在外面用不了，需要提供public static 方法
	//返回类的对象
	public static Bank getInstance() {
		return instance;
	}
}