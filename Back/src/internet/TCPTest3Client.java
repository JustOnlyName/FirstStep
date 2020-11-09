package internet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * ��3��
 * �ӿͻ��˷����ļ����ͻ��ˣ�����˱��浽���ء�
 * �����ء����ͳɹ������ͻ���
 * ���ر���Ӧ����
 */
public class TCPTest3Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(new File("img1.jpg"));

		byte[] buffer = new byte[1024];
		int len;
		while ((len = fis.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}

		//�ر�һ�����ݵ����
		socket.shutdownOutput();
		
		// �������Է����������ݣ�����ʾ�ڿ���̨�ϡ������Ź���Դ
		InputStream is = socket.getInputStream();

		// ��������Լ��ڲ���һ���ֽ����飬��ȡ������ֱ�ӷŽ�ȥ
		// �������Լ����ݣ�PS�������ڴ��������������Ҫ������������
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		byte[] buffer1 = new byte[20]; //ע������buffer1
		int len1;
		while ((len1 = is.read(buffer1)) != -1) { //ע������buffer1
			baos.write(buffer1, 0, len1);
		}
		System.out.println(baos.toString());

		baos.close();
		is.close();
		fis.close();
		os.close();
		socket.close();
	}
}
