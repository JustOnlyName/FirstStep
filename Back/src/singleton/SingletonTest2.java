package singleton;

public class SingletonTest2 {
	public static void main(String[] args) {
		Order order1 = Order.getInstance();
		Order order2 = Order.getInstance();
		System.out.println(order1 == order2);
	}
	
	
}

//����ʽ
class Order{
	//1. ˽�л���Ĺ�����
	private Order() {
		
	}
	
	//2. ��Ȼ�Ǵ�������������û������new��ֻ������ǰ�����û�г�ʼ��
	//4. �˶���Ҳ��������Ϊstatic ��
	private static Order instance = null;
	
	//3. ����public static �ķ��ص�ǰ�����ķ���
	public static Order getInstance() {
		if(instance == null)
			instance = new Order();
		return instance;
	}
}

class Bank1{
	private Bank1() {

	}
	
	public static final Bank1 instance = new Bank1();
}