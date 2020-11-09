package stream;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) throws IOException {
		//两个构造器，可以传入读取文件的位置名字，也可以传入File 对象
		RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
		raf1.seek(3);
		raf1.write("xyz".getBytes());
		raf1.close();
	}
}
