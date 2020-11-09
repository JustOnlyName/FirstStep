package internet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ��3��
 * �ӿͻ��˷����ļ����ͻ��ˣ�����˱��浽���ء�
 * �����ء����ͳɹ������ͻ���
 * ���ر���Ӧ����
 */
public class TCPTest3Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8899);
		Socket socket = ss.accept();
		InputStream is = socket.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("img2.jpg"));

		byte[] buffer = new byte[5];
		int len;
		while ((len = is.read(buffer)) != -1) {
			fos.write(buffer, 0, len);
		}

		System.out.println("image is done");
		
		// �������˸���ͻ��˷���
		OutputStream os = socket.getOutputStream();
		os.write("��ã���Ƭ���յ�".getBytes());

		fos.close();
		is.close();
		socket.close();
		ss.close();
	}
}
