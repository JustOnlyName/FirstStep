package senior.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable {

	public int ticket = 100;

	// 1. 创建ReentrantLock 对象，构造参数 boolean ，true 时
	// 将所有线程公平对待，FIFO。不写默认false
	private ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		while (true) {
			try {
				// 2. 调用lock() 方法
				lock.lock();

				if (ticket > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
					ticket--;
				} else {
					break;
				}
			} catch (Exception e) {

			} finally {
				// 3. 调用解锁方法 unlock()
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		LockTest lt = new LockTest();
		Thread t1 = new Thread(lt);
		Thread t2 = new Thread(lt);
		Thread t3 = new Thread(lt);

		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");

		t1.start();
		t2.start();
		t3.start();
	}
}
