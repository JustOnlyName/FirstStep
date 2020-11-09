package test;

public class InstanceofDemo {
	public static void main(String[] args) {
		SuperClass superObj = new SuperClass();
		SonClass sonObj = new SonClass();

		if (superObj instanceof SonClass) {
			SonClass sonObj1 = (SonClass) superObj;
		} else {
			System.out.println("无法向下转换");
		}

		superObj = sonObj;
		if (superObj instanceof SonClass) {
			SonClass sonObj2 = (SonClass) superObj;
			System.out.println(sonObj2.equals(sonObj));
		} else {
			System.out.println("父类变量引用子类实例，无法转换");
		}

		label: for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 10; j++) {
				if (j % 4 == 0)
					continue label;
				System.out.print(j);
			}
			System.out.println();

		}
	}
}

class SuperClass {
}

class SonClass extends SuperClass {
}