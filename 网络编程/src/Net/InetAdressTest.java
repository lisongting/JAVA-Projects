package Net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdressTest {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("127.0.0.1");
			System.out.println("本机是否可达："+ip.isReachable(2000));
			System.out.println(ip.getHostName());
			System.out.println(ip.getCanonicalHostName());
			System.out.println(ip.getAddress());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
