package senior.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool implements Runnable{
	
	@Override
	public void run() {
		for(int i = 0;i<100;i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		//1. �ṩָ���߳��������̳߳�
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		//2. ִ��ָ�����̲߳�������Ҫ�ṩʵ��Runnable �ӿڻ�Callable �ӿ�ʵ����Ķ���
		threadPool.execute(new ThreadPool());  //������Runnable
//		threadPool.submit();  //������Callable
		//3. �ر����ӳ�
		threadPool.shutdown();
	}
}
