package stream;

import java.io.File;

/**
 * 1. File 类的一个对象，代表一个文件或一个文件目录
 * 2. File 类声明在java.io 包下
 */
public class FileTest {
	/**
	 * 创建File 类对象
	 * 
	 * 使用构造器方式
	 * 
	 * File(File parent, String child) 
		从父抽象路径名和子路径名字符串创建新的 File实例。  
	
	 * File(String pathname) 
		通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。  
	
	 * File(String parent, String child) 
		从父路径名字符串和子路径名字符串创建新的 File实例。 
	 */
	
	public static void main(String[] args) {
		//构造器1
		File file1 = new File("d:\\Desktop\\2.txt"); //绝对路径
		File file2 = new File("hello.txt"); //相对路径，相对于整个工程project 的包里面的位置
		
		//不同的操作系统，里面的 / \ 分隔符不同
		//怎样减少自己没注意到该使用哪个于具体系统的问题
		//使用File 类的常量 
		//File.separator 动态使用系统的分隔符
		File file3 = new File("d:" + File.separator + "Desktop" + File.separator + "linux_vpn_softEther.txt");
		
		File file4 = new File("d:\\Desktop"); //目录
		
		
		//构造器2
		File file5 = new File("d:", "Desktop");
		
		//构造器3
		File file6 = new File(file5, "hi.txt");
	}
}
