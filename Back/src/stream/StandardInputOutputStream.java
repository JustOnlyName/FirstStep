package stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 标准的输入输出流
 * System.in : 默认从键盘
 * System.out : 默认从控制台
 */
public class StandardInputOutputStream {
	public static void main(String[] args) {
		//System 类的 setIn(InputStream in) / setOut(PrintStream out)  方法重新指定输入和输出的流
		
		//从键盘读取字符串，要求将读取到的整行字符串转成大写输出。
		//然后继续进行输入操作
		//直至输入 "e" 或 "exit" 退出程序
		
		//方式一：Scanner 实现 next() 方法一行字符串
		
		
		//方式二：System.in --> 转换流 -->  BufferedReader 的readLine() 一行字符串
		
	}
	
	public static void test2() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		while(true) {
			String data = br.readLine();
			if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
				System.out.println("程序结束");
				break;
			}
			String upperCase = data.toUpperCase();
			System.out.println(upperCase);
		}
		
		br.close();
	}
}
