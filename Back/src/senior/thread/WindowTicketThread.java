package senior.thread;

public class WindowTicketThread extends Thread {
	private static int ticket = 100;

	@Override
	public void run() {
		while (true) {
			synchronized (WindowTicketThread.class) {

				if (ticket > 0) {
					System.out.println(getName() + " ����Ʊ��" + ticket);
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

		w1.setName("����1");
		w2.setName("����2");
		w3.setName("����3");

		w1.start();
		w2.start();
		w3.start();
	}
}
