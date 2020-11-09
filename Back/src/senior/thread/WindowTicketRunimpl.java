package senior.thread;

public class WindowTicketRunimpl implements Runnable {

	private int ticket = 100;
//	Object obj = new Object();

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				if (ticket > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":ÂôÆ±£¬ºÅ" + ticket);
					ticket--;
				} else {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		WindowTicketRunimpl w = new WindowTicketRunimpl();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);

		t1.setName("´°¿Ú1");
		t2.setName("´°¿Ú2");
		t3.setName("´°¿Ú3");

		t1.start();
		t2.start();
		t3.start();
	}
}
