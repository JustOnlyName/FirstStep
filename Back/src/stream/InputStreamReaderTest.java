package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(new File("hello.txt"));
		//���������������Charset ��ֵĬ��ʹ��ϵͳ���ַ����������Լ����ʵ��
		InputStreamReader isr = new InputStreamReader(fis);
		//����2 Charset ָ�����ַ���������ַ��� �ֽ�ת��Ϊ�ַ��ġ������ļ�����ʱ�ı������
		InputStreamReader isr1 = new InputStreamReader(fis, "UTF-8");
		
		char[] cbuffer = new char[10];
		int len;
		while((len = isr.read(cbuffer)) != -1) {
			String str = new String(cbuffer, 0, len);
			System.out.print(str); //���������̨
		}
		
		isr.close();
	}
}
