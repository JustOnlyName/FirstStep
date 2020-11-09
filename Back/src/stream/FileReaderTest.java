package stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			//1. 显示文件内容，首先要实例化File 对象，指明操作的是哪个文件
			File file = new File("jdbc.properties");
			
			//2. 操作流，进行读取文件的内容。提供具体的流
			fr = new FileReader(file);
			
			//3. 数据的读入过程
			//read() ：返回读入的一个字符对应的ascii 码，即返回 int 数，可以（char） 强转。
			//达到文件末尾时，返回-1
			int read = fr.read();
			while(read != -1) {
				System.out.print((char)read);
				read = fr.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4. 流的关闭操作。必须手动进行
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
