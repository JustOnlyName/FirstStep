package stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ��׼�����������
 * System.in : Ĭ�ϴӼ���
 * System.out : Ĭ�ϴӿ���̨
 */
public class StandardInputOutputStream {
	public static void main(String[] args) {
		//System ��� setIn(InputStream in) / setOut(PrintStream out)  ��������ָ��������������
		
		//�Ӽ��̶�ȡ�ַ�����Ҫ�󽫶�ȡ���������ַ���ת�ɴ�д�����
		//Ȼ����������������
		//ֱ������ "e" �� "exit" �˳�����
		
		//��ʽһ��Scanner ʵ�� next() ����һ���ַ���
		
		
		//��ʽ����System.in --> ת���� -->  BufferedReader ��readLine() һ���ַ���
		
	}
	
	public static void test2() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		while(true) {
			String data = br.readLine();
			if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
				System.out.println("�������");
				break;
			}
			String upperCase = data.toUpperCase();
			System.out.println(upperCase);
		}
		
		br.close();
	}
}
