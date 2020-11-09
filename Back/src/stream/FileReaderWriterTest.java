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
			//1. 创建File 类对象，指明读入和写出的文件
			File srcFile = new File("jdbc.properties");
			File destFile = new File("hello.txt");
			
			//2. 创建输入流和输出流的对象
			fr = new FileReader(srcFile);
			fw = new FileWriter(destFile, false);
			
			//3. 数据的读入和写出操作
			char[] cbuffer = new char[5];
			int len;
			while((len = fr.read(cbuffer)) != -1) {
				fw.write(cbuffer, 0, len);  //方法，从cbuffer 的off 索引位置，取len 个元素
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4. 关闭流资源
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
