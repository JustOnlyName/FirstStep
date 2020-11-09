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
 * 例3：
 * 从客户端发送文件给客户端，服务端保存到本地。
 * 并返回“发送成功”给客户端
 * 并关闭相应连接
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

		//关闭一下数据的输出
		socket.shutdownOutput();
		
		// 接收来自服务器的数据，并显示在控制台上。不急着关资源
		InputStream is = socket.getInputStream();

		// 这个流类自己内部有一个字节数组，获取的内容直接放进去
		// 不够会自己扩容（PS：不会内存溢出？）。不需要烦恼乱码问题
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		byte[] buffer1 = new byte[20]; //注意这里buffer1
		int len1;
		while ((len1 = is.read(buffer1)) != -1) { //注意这里buffer1
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
