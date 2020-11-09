package stream.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*
		 * ���л����̣����ڴ��е�Java ���󱣴浽�����л�ͨ�����紫���ȥ
		 * ʹ��ObjectOutputStream ʵ��
		 */
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
		oos.writeObject(new String("beijing is holy"));
		oos.flush(); //ˢ�²���
		oos.close();
		
		/**
		 * �����л����̣��������ļ��еĶ���ԭΪ�ڴ��е�һ��java ����
		 */
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
		Object obj = ois.readObject();
		System.out.println((String) obj);
		ois.close();
	}
}
