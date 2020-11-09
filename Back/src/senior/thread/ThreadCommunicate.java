package senior.thread;

class Number implements Runnable{

	private int number = 1;
	private Object obj = new Object();
	
	@Override
	public void run() {
		while(true) {
			synchronized (obj) {
				obj.notify();
				
				if (number <= 100) {
					System.out.println(Thread.currentThread().getName() + ":" + number);
					number++;
					
					try {
						//ʹ�õ���wait() �������߳̽�����ɫ״̬
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				} else {
					break;
				}
			}
		}
	}
	
}

public class ThreadCommunicate {
	public static void main(String[] args) {
		Number number = new Number();
		Thread t1 = new Thread(number);
		Thread t2 = new Thread(number);
		
		t1.setName("�߳�1");
		t2.setName("�߳�2");
		
		t1.start();
		t2.start();
	}
}
