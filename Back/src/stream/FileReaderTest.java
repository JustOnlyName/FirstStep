package stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			//1. ��ʾ�ļ����ݣ�����Ҫʵ����File ����ָ�����������ĸ��ļ�
			File file = new File("jdbc.properties");
			
			//2. �����������ж�ȡ�ļ������ݡ��ṩ�������
			fr = new FileReader(file);
			
			//3. ���ݵĶ������
			//read() �����ض����һ���ַ���Ӧ��ascii �룬������ int �������ԣ�char�� ǿת��
			//�ﵽ�ļ�ĩβʱ������-1
			int read = fr.read();
			while(read != -1) {
				System.out.print((char)read);
				read = fr.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4. ���Ĺرղ����������ֶ�����
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
