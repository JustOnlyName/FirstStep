package senior.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable {

	public int ticket = 100;

	// 1. ����ReentrantLock ���󣬹������ boolean ��true ʱ
	// �������̹߳�ƽ�Դ���FIFO����дĬ��false
	private ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		while (true) {
			try {
				// 2. ����lock() ����
				lock.lock();

				if (ticket > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "��Ʊ��" + ticket);
					ticket--;
				} else {
					break;
				}
			} catch (Exception e) {

			} finally {
				// 3. ���ý������� unlock()
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		LockTest lt = new LockTest();
		Thread t1 = new Thread(lt);
		Thread t2 = new Thread(lt);
		Thread t3 = new Thread(lt);

		t1.setName("����1");
		t2.setName("����2");
		t3.setName("����3");

		t1.start();
		t2.start();
		t3.start();
	}
}
