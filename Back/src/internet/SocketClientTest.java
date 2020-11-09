package internet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientTest {
	public static void main(String[] args) {
		Socket socket = null;
		OutputStream os = null;
		
		try {
			InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
			socket = new Socket(inetAddress, 8899);
			
			os = socket.getOutputStream();
			os.write("你好，这里是客户端mmmm".getBytes());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(os != null)
				try {
					os.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			
			if(socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
