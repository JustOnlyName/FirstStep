package stream;

import java.io.File;

/**
 * 1. File ���һ�����󣬴���һ���ļ���һ���ļ�Ŀ¼
 * 2. File ��������java.io ����
 */
public class FileTest {
	/**
	 * ����File �����
	 * 
	 * ʹ�ù�������ʽ
	 * 
	 * File(File parent, String child) 
		�Ӹ�����·��������·�����ַ��������µ� Fileʵ����  
	
	 * File(String pathname) 
		ͨ����������·�����ַ���ת��Ϊ����·�����������µ� Fileʵ����  
	
	 * File(String parent, String child) 
		�Ӹ�·�����ַ�������·�����ַ��������µ� Fileʵ���� 
	 */
	
	public static void main(String[] args) {
		//������1
		File file1 = new File("d:\\Desktop\\2.txt"); //����·��
		File file2 = new File("hello.txt"); //���·�����������������project �İ������λ��
		
		//��ͬ�Ĳ���ϵͳ������� / \ �ָ�����ͬ
		//���������Լ�ûע�⵽��ʹ���ĸ��ھ���ϵͳ������
		//ʹ��File ��ĳ��� 
		//File.separator ��̬ʹ��ϵͳ�ķָ���
		File file3 = new File("d:" + File.separator + "Desktop" + File.separator + "linux_vpn_softEther.txt");
		
		File file4 = new File("d:\\Desktop"); //Ŀ¼
		
		
		//������2
		File file5 = new File("d:", "Desktop");
		
		//������3
		File file6 = new File(file5, "hi.txt");
	}
}
