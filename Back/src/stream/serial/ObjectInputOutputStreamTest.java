package stream.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*
		 * 序列化过程：将内存中的Java 对象保存到磁盘中或通过网络传输出去
		 * 使用ObjectOutputStream 实现
		 */
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
		oos.writeObject(new String("beijing is holy"));
		oos.flush(); //刷新操作
		oos.close();
		
		/**
		 * 反序列化过程：将磁盘文件中的对象还原为内存中的一个java 对象
		 */
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
		Object obj = ois.readObject();
		System.out.println((String) obj);
		ois.close();
	}
}
