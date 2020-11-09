package stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	public static void main(String[] args) throws IOException {
		// д��������file ָ�����ļ����Բ�����
		//   ���ļ����β�����ʱ�����Զ�������д������
		//   ���ļ��Ѿ����ڣ�
		//     ����ʹ�õĹ������в���append Ϊfalse��Ĭ�ϣ�FileWriter(file, false) / FileWriter(file) ���Ὣ�ļ�����
		//     ����ʹ�õĹ����� FileWriter(file, true) append Ϊtrue ��׷������
		
		//1. �ṩFile ��Ķ���ָ��д�������ļ�
		File file = new File("jdbc.properties");
		
		//2. �ṩFileWriter �����������ݵ�д��
		FileWriter fw = new FileWriter(file);
		
		//3. д���ľ������
		fw.write("i have a dream!\n");
		fw.write("you need a dream too".toCharArray());
		
		//4. ����Դ�Ĺر�
		fw.close();
	}
}
