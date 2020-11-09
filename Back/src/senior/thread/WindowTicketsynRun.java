package senior.thread;

public class WindowTicketsynRun implements Runnable {
	private int ticket = 100;

	@Override
	public synchronized void run() {
		while (true) {
			show();
		}
	}
	
	private synchronized void show() {
		if (ticket > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":��Ʊ����" + ticket);
			ticket--;
		}
	}

	public static void main(String[] args) {
		WindowTicketsynRun w = new WindowTicketsynRun();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);

		t1.setName("����1");
		t2.setName("����2");
		t3.setName("����3");

		t1.start();
		t2.start();
		t3.start();
	}
}
