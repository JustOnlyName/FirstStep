package interfacetest.jdk8features;

public interface InterfaceTestA {
    //��̬����
    public static void method1(){
        System.out.println("static method");
    }
    //Ĭ�Ϸ���
    public default void method2(){
        System.out.println("interfaceA default method2");
    }
    //Ĭ�Ϸ���
    default void method3(){
        System.out.println("interfaceA default method3");
    }
}

interface InterfaceTestB{
	default void method3() {
		System.out.println("interfaceB default method");
	}
}
