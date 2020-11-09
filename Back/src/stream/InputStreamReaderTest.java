package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(new File("hello.txt"));
		//构造器多个，参数Charset 的值默认使用系统的字符集，或者自己添加实参
		InputStreamReader isr = new InputStreamReader(fis);
		//参数2 Charset 指明了字符集，这个字符集 字节转化为字符的。根据文件保存时的编码决定
		InputStreamReader isr1 = new InputStreamReader(fis, "UTF-8");
		
		char[] cbuffer = new char[10];
		int len;
		while((len = isr.read(cbuffer)) != -1) {
			String str = new String(cbuffer, 0, len);
			System.out.print(str); //输出到控制台
		}
		
		isr.close();
	}
}
