package internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPTestSender {
	public static void main(String[] args) throws IOException {
		//一般不在此对象构造器中指定对方的IP 和port ，而在数据报中写
		DatagramSocket udpSocket = new DatagramSocket();
		
		byte[] data = "我是UDP 方式发送的数据".getBytes();
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		DatagramPacket udpPacket = new DatagramPacket(data, 0, data.length, inet, 9090);
		
		udpSocket.send(udpPacket);
		udpSocket.close();
	}
}
