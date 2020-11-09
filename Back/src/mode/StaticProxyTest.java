package mode;

public class StaticProxyTest {
	public static void main(String[] args) {
		Star star = new Proxy(new RealStar());
		star.confer();
		star.signContract();
		star.bookTicket();
		star.sing();
		star.collectMoney();
		
	}
}

interface Star{
	void confer();   //��̸
	
	void signContract();   //ǩ��ͬ
	
	void bookTicket();   //��Ʊ
	
	void sing();   //����
	
	void collectMoney();   //��Ǯ
}

//��������
class RealStar implements Star{

	@Override
	public void confer() {
		
	}

	@Override
	public void signContract() {
		
	}

	@Override
	public void bookTicket() {
		
	}

	@Override
	public void sing() {
		System.out.println("���ǣ�����");
	}

	@Override
	public void collectMoney() {
		
	}
}

//������
class Proxy implements Star{
	
	private Star realstar;
	
	public Proxy(Star realstar) {
		this.realstar = realstar;
	}
	
	@Override
	public void confer() {
		System.out.println("��������̸");
	}

	@Override
	public void signContract() {
		System.out.println("������ǩ��ͬ");
	}

	@Override
	public void bookTicket() {
		System.out.println("�����˶�Ʊ");
	}

	@Override
	public void collectMoney() {
		System.out.println("��������Ǯ");
	}

	@Override
	public void sing() {
		realstar.sing();
	}
}