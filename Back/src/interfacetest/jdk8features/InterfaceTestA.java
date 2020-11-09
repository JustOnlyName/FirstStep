package interfacetest.jdk8features;

public interface InterfaceTestA {
    //静态方法
    public static void method1(){
        System.out.println("static method");
    }
    //默认方法
    public default void method2(){
        System.out.println("interfaceA default method2");
    }
    //默认方法
    default void method3(){
        System.out.println("interfaceA default method3");
    }
}

interface InterfaceTestB{
	default void method3() {
		System.out.println("interfaceB default method");
	}
}
