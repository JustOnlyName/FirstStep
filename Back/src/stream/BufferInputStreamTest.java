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
			//1. 造文件
			File srcFile = new File("img1.jpg");
			File destFile = new File("img3.jpg");
			
			//2. 造流
			//2.1 造文件流
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(destFile);
			//2.2 造缓冲流
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			//3. 复制的细节
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
			//4. 资源关闭 4个流
			//先关闭外层的流，再关闭内层的流
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
			//关闭外层流的同时，内层流也会自动的进行关闭。关于内存流的手动关闭，可以忽略
//		fos.close();
//		fis.close();
		}
	}
}
