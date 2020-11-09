package stream;

public class CopyFileTest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		String srcPath = "";  //字符文件或字节文件均可
		String destPath = "";  //因为仅仅是复制，并没有在控制台读出来，搬运工的角色
		
		copyFile(srcPath, destPath);
		
		System.out.println("copy takes " + (System.currentTimeMillis() - start) + "time");
	}
	
	/**
	 * 指定路径下文件复制到指定路径
	 */
	public static void copyFile(String srcPath, String destPath) {
		//1. 把之前的 第一步中的 file 对象，改为使用传入的参数
		
		//2. 使用字节流 FileInputOutputStream 的
		
		//3. 实际复制的过程中，byte[] buffer = new byte[1024]; 常用数1024
		
	}
}
