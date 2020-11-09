package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInput_OutputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			//
			File srcFile = new File("img1.jpg");
			File destFile = new File("img2.jpg");
			
			//
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(destFile);
			//
			byte[] buffer = new byte[5];
			int len;
			while ((len = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//
			if(fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
}
