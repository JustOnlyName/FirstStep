package internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPTestSender {
	public static void main(String[] args) throws IOException {
		//һ�㲻�ڴ˶���������ָ���Է���IP ��port ���������ݱ���д
		DatagramSocket udpSocket = new DatagramSocket();
		
		byte[] data = "����UDP ��ʽ���͵�����".getBytes();
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		DatagramPacket udpPacket = new DatagramPacket(data, 0, data.length, inet, 9090);
		
		udpSocket.send(udpPacket);
		udpSocket.close();
	}
}
