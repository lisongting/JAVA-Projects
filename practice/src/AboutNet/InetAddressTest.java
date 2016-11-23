package AboutNet;

import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) throws Exception{
		//根据主机名来获取对应的InetAddress实例
		InetAddress ip = InetAddress.getByName("www.baidu.com");
		System.out.println("百度是否可达:"+ip.isReachable(2000));
		System.out.println(ip.getHostAddress());
		
		InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
		System.out.println("本机是否可达:"+local.isReachable(2000));
		System.out.println(local.getCanonicalHostName());
		//获取该InetAddress实例对应的全限定域名
	}

}
