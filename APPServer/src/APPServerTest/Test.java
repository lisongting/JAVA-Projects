package APPServerTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress address;
		try {
			address = InetAddress.getLocalHost();
			String hostName = address.getHostName();
			String hostAddress = address.getHostAddress();
			byte[] bytes = address.getAddress();
			System.out.println(hostName);
			System.out.println(hostAddress);
			System.out.println(bytes);
			for(byte b:bytes){
				System.out.print("  "+b);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
