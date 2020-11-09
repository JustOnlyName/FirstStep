package senior.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//1. ����ʵ��Callable �ӿڵ�ʵ����
public class ThreadCallable implements Callable {
	// 2. ʵ��call() �����������߳���Ҫִ�еĲ���������call() ��
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
		// 3. ����Callable �ӿ�ʵ����Ķ���
		ThreadCallable tc = new ThreadCallable();
		// 4. ����ʵ����Ķ�����Ϊ�������ݵ�FutureTask �������У�����FutureTask ����
		FutureTask futureTask = new FutureTask(tc);
		// 5. ��FutureTask ������Ϊ�������ݵ�Thread ��Ĺ������У�����Thread ���󣬲�start
		new Thread(futureTask).start();

		try {
			// 6. ���ȡ����ֵ����Ҫ��
			Object sum = futureTask.get();
			System.out.println(sum);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
