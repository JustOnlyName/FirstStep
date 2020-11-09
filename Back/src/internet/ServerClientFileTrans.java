package internet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class ServerClientFileTrans {
	/*
	 * 客户端发送文件给服务端，服务端将文件保存在本地
	 */
	
	public void server() throws IOException {
		ServerSocket ss = new ServerSocket(8899);
		Socket socket = ss.accept();
		InputStream is = socket.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("img2.jpg"));

		byte[] buffer = new byte[5];
		int len;
		while ((len = is.read(buffer)) != -1) {
			fos.write(buffer, 0, len);
		}
		
		fos.close();
		is.close();
		socket.close();
		ss.close();
	}
	
	public void client() throws IOException {
		Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(new File("img1.jpg"));
		
		byte[] buffer = new byte[1024];
		int len;
		while((len = fis.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		
		fis.close();
		os.close();
		socket.close();
	}
	
}
