package internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UPDTestReceiver {
	public static void main(String[] args) throws IOException {
		//��Ϊ�ǽ��նˣ���Ҫ������������ָ���˿ں�
		DatagramSocket udpSocket = new DatagramSocket(9090);
		
		byte[] buffer = new byte[100];
		DatagramPacket udpPacket = new DatagramPacket(buffer, 0, buffer.length);
		udpSocket.receive(udpPacket);
		
		System.out.println(new String(udpPacket.getData(), 0, udpPacket.getLength()));
		
	}
}
