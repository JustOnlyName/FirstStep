package stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferInputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			//1. ���ļ�
			File srcFile = new File("img1.jpg");
			File destFile = new File("img3.jpg");
			
			//2. ����
			//2.1 ���ļ���
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(destFile);
			//2.2 �컺����
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			//3. ���Ƶ�ϸ��
			byte[] buffer = new byte[10];
			int len;
			while((len = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4. ��Դ�ر� 4����
			//�ȹر����������ٹر��ڲ����
			if(bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//�ر��������ͬʱ���ڲ���Ҳ���Զ��Ľ��йرա������ڴ������ֶ��رգ����Ժ���
//		fos.close();
//		fis.close();
		}
	}
}
