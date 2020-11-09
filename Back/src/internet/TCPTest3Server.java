package internet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 例3：
 * 从客户端发送文件给客户端，服务端保存到本地。
 * 并返回“发送成功”给客户端
 * 并关闭相应连接
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
		
		// 服务器端给予客户端反馈
		OutputStream os = socket.getOutputStream();
		os.write("你好，照片已收到".getBytes());

		fos.close();
		is.close();
		socket.close();
		ss.close();
	}
}
