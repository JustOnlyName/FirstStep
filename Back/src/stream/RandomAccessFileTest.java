package stream;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) throws IOException {
		//���������������Դ����ȡ�ļ���λ�����֣�Ҳ���Դ���File ����
		RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
		raf1.seek(3);
		raf1.write("xyz".getBytes());
		raf1.close();
	}
}
