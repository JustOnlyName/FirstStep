package internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getByName("192.168.43.178");
			System.out.println(inetAddress);
			
			//��Ҫhosts �� dns ��ѯ�������ip
			InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
			System.out.println(inetAddress2);
			
			//��ȡ����ip
			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println(localHost);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
