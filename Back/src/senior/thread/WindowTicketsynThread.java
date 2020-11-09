package senior.thread;

public class WindowTicketsynThread extends Thread {
	private static int ticket = 100;

	@Override
	public void run() {
		while (true) {
			show();
		}
	}
	
	private static synchronized void show() {
		if (ticket > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " 出售票：" + ticket);
			ticket--;
		} 
	}

	public static void main(String[] args) {
		WindowTicketsynThread w1 = new WindowTicketsynThread();
		WindowTicketsynThread w2 = new WindowTicketsynThread();
		WindowTicketsynThread w3 = new WindowTicketsynThread();

		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");

		w1.start();
		w2.start();
		w3.start();
	}
}
