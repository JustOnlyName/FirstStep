package stream;

public class CopyFileTest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		String srcPath = "";  //�ַ��ļ����ֽ��ļ�����
		String destPath = "";  //��Ϊ�����Ǹ��ƣ���û���ڿ���̨�����������˹��Ľ�ɫ
		
		copyFile(srcPath, destPath);
		
		System.out.println("copy takes " + (System.currentTimeMillis() - start) + "time");
	}
	
	/**
	 * ָ��·�����ļ����Ƶ�ָ��·��
	 */
	public static void copyFile(String srcPath, String destPath) {
		//1. ��֮ǰ�� ��һ���е� file ���󣬸�Ϊʹ�ô���Ĳ���
		
		//2. ʹ���ֽ��� FileInputOutputStream ��
		
		//3. ʵ�ʸ��ƵĹ����У�byte[] buffer = new byte[1024]; ������1024
		
	}
}
