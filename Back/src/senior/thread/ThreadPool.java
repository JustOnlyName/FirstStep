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
		//1. 提供指定线程数量的线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		//2. 执行指定的线程操作，需要提供实现Runnable 接口或Callable 接口实现类的对象
		threadPool.execute(new ThreadPool());  //适用于Runnable
//		threadPool.submit();  //适用于Callable
		//3. 关闭连接池
		threadPool.shutdown();
	}
}
