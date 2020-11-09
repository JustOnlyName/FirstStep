package stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest {
	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;
		
		try {
			//1. ����File �����ָ�������д�����ļ�
			File srcFile = new File("jdbc.properties");
			File destFile = new File("hello.txt");
			
			//2. ������������������Ķ���
			fr = new FileReader(srcFile);
			fw = new FileWriter(destFile, false);
			
			//3. ���ݵĶ����д������
			char[] cbuffer = new char[5];
			int len;
			while((len = fr.read(cbuffer)) != -1) {
				fw.write(cbuffer, 0, len);  //��������cbuffer ��off ����λ�ã�ȡlen ��Ԫ��
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4. �ر�����Դ
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(fr != null) {
				try {
					fr.close();
				} catch (Exception e2) {
				}
			}
		}
		
	}
}
