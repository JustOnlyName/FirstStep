package internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {
	public static void main(String[] args) throws IOException {
		//1. 创建服务器端的ServerSocket ，指明自己的端口号
		ServerSocket ss = new ServerSocket(8899);
		//2. 调用accept() 标识接收客户端发来的socket
		Socket socket = ss.accept();
		//3. 获取/读入客户端发来的输入流
		InputStream is = socket.getInputStream();
		
		//4. 读取流当中的数据
		//有问题的方式一，会出现乱码
//		byte[] buffer = new byte[1024];
//		int len;
//		while((len = is.read(buffer)) != -1) {
//			String str = new String(buffer, 0, len);
//			System.out.print(str);
//		}
		
		//考虑使用转换流方式二
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
