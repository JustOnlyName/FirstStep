package stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	public static void main(String[] args) throws IOException {
		// 写出操作，file 指明的文件可以不存在
		//   当文件初次不存在时，会自动创建并写入内容
		//   当文件已经存在：
		//     当流使用的构造器中参数append 为false（默认）FileWriter(file, false) / FileWriter(file) ，会将文件覆盖
		//     当流使用的构造器 FileWriter(file, true) append 为true ，追加内容
		
		//1. 提供File 类的对象，指明写出到的文件
		File file = new File("jdbc.properties");
		
		//2. 提供FileWriter 对象，用于数据的写出
		FileWriter fw = new FileWriter(file);
		
		//3. 写出的具体操作
		fw.write("i have a dream!\n");
		fw.write("you need a dream too".toCharArray());
		
		//4. 流资源的关闭
		fw.close();
	}
}
