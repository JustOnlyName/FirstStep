package senior.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//1. 创建实现Callable 接口的实现类
public class ThreadCallable implements Callable {
	// 2. 实现call() 方法，将此线程需要执行的操作声明在call() 中
	@Override
	public Object call() throws Exception {
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// 3. 创建Callable 接口实现类的对象
		ThreadCallable tc = new ThreadCallable();
		// 4. 将此实现类的对象作为参数传递到FutureTask 构造器中，创建FutureTask 对象
		FutureTask futureTask = new FutureTask(tc);
		// 5. 将FutureTask 对象作为参数传递到Thread 类的构造器中，创建Thread 对象，并start
		new Thread(futureTask).start();

		try {
			// 6. 想获取返回值才需要，
			Object sum = futureTask.get();
			System.out.println(sum);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
