package senior.thread.exer;

/**
 * 分析： 1. 是否是多线程问题 是，生产者线程、消费者线程 
 * 2. 是否线程安全问题 是，共享数据是店员、产品 
 * 3. 如何解决线程安全问题 同步机制 
 * 4. 通信 生产者，产品数量>20 wait
 */

class Clerk {
	private int productCount = 0;

	// 生产产品
	public synchronized void produceProduct() {
		if (productCount < 20) {
			productCount++;
			System.out.println(Thread.currentThread().getName() + "开始生产第 " + productCount + " 个产品");
			notify();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 消费产品
	public synchronized void consumeProduct() {
		if (productCount > 0) {
			System.out.println(Thread.currentThread().getName() + "开始消费第 " + productCount + " 个产品");
			productCount--;
			if(productCount<10)
				notify();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

/**
 * 生产者
 */
class Producer extends Thread {
	private Clerk clerk;

	public Producer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		while(true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.produceProduct();
		}
	}
}

/**
 * 消费者
 */
class Consumer extends Thread {
	private Clerk clerk;

	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.consumeProduct();
		}
	}
}

public class ProductTest {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();

		Producer producer = new Producer(clerk);
		producer.setName("生产者");

		Consumer consumer = new Consumer(clerk);
		consumer.setName("消费者1");
		Consumer consumer2 = new Consumer(clerk);
		consumer2.setName("消费者2");
		
		producer.start();
		consumer.start();
		consumer2.start();
	}
}
