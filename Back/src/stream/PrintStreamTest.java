package stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("test.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//������ӡ�����������Ϊ�Զ�ˢ��ģʽ��д�뻻�з����ֽ�'\n' ʱ����ˢ�������������
		PrintStream ps = new PrintStream(fos, true);
		if(ps != null) { //�ѱ�׼�����������̨������ĳ��ļ�
			System.setOut(ps);
		}
		
		for(int i = 0; i <= 255; i++) { //���ASCII �ַ�
			System.out.print((char) i);
			if(i % 50 == 0) {
				System.out.println();
			}
		}
		
		if(ps != null) {
			ps.close();
		}
	}
}