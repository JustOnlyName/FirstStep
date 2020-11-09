package singleton;

public class SingletonTest1 {
	public static void main(String[] args) {
		Bank bank1 = Bank.getInstance();
		Bank bank2 = Bank.getInstance();
		
		
	}
}

class Bank{
	//1. ˽�л��Ĺ�����
	//�����������������޷������������
	private Bank() {
		
	}
	
	//2. �ڲ�������Ķ���
	//4. �����޸ģ�Ҫ��˶���Ҳ��������Ϊ��̬��
	private static Bank instance = new Bank();
	
	//3. 2 ֮��Ҳ�������ò��ˣ���Ҫ�ṩpublic static ����
	//������Ķ���
	public static Bank getInstance() {
		return instance;
	}
}