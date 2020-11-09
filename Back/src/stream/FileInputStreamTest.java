package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			//1. ���ļ�
			File file = new File("jdbc.properties");
			
			//2. ����
			fis = new FileInputStream(file);
			
			//3. ������
			byte[] buffer = new byte[5];
			int len;
			while((len = fis.read(buffer)) != -1) {
				String str = new String(buffer, 0, len);
				System.out.print(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//4. ����Դ
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
