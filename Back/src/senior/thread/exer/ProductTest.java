package senior.thread.exer;

/**
 * ������ 1. �Ƿ��Ƕ��߳����� �ǣ��������̡߳��������߳� 
 * 2. �Ƿ��̰߳�ȫ���� �ǣ����������ǵ�Ա����Ʒ 
 * 3. ��ν���̰߳�ȫ���� ͬ������ 
 * 4. ͨ�� �����ߣ���Ʒ����>20 wait
 */

class Clerk {
	private int productCount = 0;

	// ������Ʒ
	public synchronized void produceProduct() {
		if (productCount < 20) {
			productCount++;
			System.out.println(Thread.currentThread().getName() + "��ʼ������ " + productCount + " ����Ʒ");
			notify();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// ���Ѳ�Ʒ
	public synchronized void consumeProduct() {
		if (productCount > 0) {
			System.out.println(Thread.currentThread().getName() + "��ʼ���ѵ� " + productCount + " ����Ʒ");
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
 * ������
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
 * ������
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
		producer.setName("������");

		Consumer consumer = new Consumer(clerk);
		consumer.setName("������1");
		Consumer consumer2 = new Consumer(clerk);
		consumer2.setName("������2");
		
		producer.start();
		consumer.start();
		consumer2.start();
	}
}
