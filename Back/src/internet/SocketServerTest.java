package internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {
	public static void main(String[] args) throws IOException {
		//1. �����������˵�ServerSocket ��ָ���Լ��Ķ˿ں�
		ServerSocket ss = new ServerSocket(8899);
		//2. ����accept() ��ʶ���տͻ��˷�����socket
		Socket socket = ss.accept();
		//3. ��ȡ/����ͻ��˷�����������
		InputStream is = socket.getInputStream();
		
		//4. ��ȡ�����е�����
		//������ķ�ʽһ�����������
//		byte[] buffer = new byte[1024];
//		int len;
//		while((len = is.read(buffer)) != -1) {
//			String str = new String(buffer, 0, len);
//			System.out.print(str);
//		}
		
		//����ʹ��ת������ʽ��
	    InputStreamReader isr = new InputStreamReader(is, "UTF-8");

	    char[] cbuffer = new char[10];
	    int len;
	    while((len = isr.read(cbuffer)) != -1) {
	        String str = new String(cbuffer, 0, len);
	        System.out.print(str);
	    }
	    
	    isr.close();
	    is.close();
	    socket.close();
	    ss.close();
	}
}
