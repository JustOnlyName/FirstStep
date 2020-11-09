package senior.thread.exer;

class Account{
	private double balance;

	public Account(double balance) {
		this.balance = balance;
	}
	
	//��Ǯ�ķ���
	public synchronized void deposit(double atm) {
		if(atm > 0) {
			balance+=atm;
			System.out.println(Thread.currentThread().getName()+"��Ǯ�ɹ������Ϊ"+balance);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Customer extends Thread{
	
	private Account acct = null;
	
	public Customer(Account acct ) {
		this.acct = acct;
	}
	
	@Override
	public void run() {
		for(int i =0;i<3;i++) {
			acct.deposit(1000);
		}
	}
}

public class ThreadBankAccountexer {
	public static void main(String[] args) {
		Account acct = new Account(0);
		Customer c1 = new Customer(acct);
		Customer c2 = new Customer(acct);
		
		c1.setName("��");
		c2.setName("��");
		
		c1.start();
		c2.start();
	}
}