package senior.thread;

public class WindowTicketThread extends Thread {
	private static int ticket = 100;

	@Override
	public void run() {
		while (true) {
			synchronized (WindowTicketThread.class) {

				if (ticket > 0) {
					System.out.println(getName() + " 出售票：" + ticket);
					ticket--;
				} else {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		WindowTicketThread w1 = new WindowTicketThread();
		WindowTicketThread w2 = new WindowTicketThread();
		WindowTicketThread w3 = new WindowTicketThread();

		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");

		w1.start();
		w2.start();
		w3.start();
	}
}
