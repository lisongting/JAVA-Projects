package AboutNet;

import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) throws Exception{
		//��������������ȡ��Ӧ��InetAddressʵ��
		InetAddress ip = InetAddress.getByName("www.baidu.com");
		System.out.println("�ٶ��Ƿ�ɴ�:"+ip.isReachable(2000));
		System.out.println(ip.getHostAddress());
		
		InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
		System.out.println("�����Ƿ�ɴ�:"+local.isReachable(2000));
		System.out.println(local.getCanonicalHostName());
		//��ȡ��InetAddressʵ����Ӧ��ȫ�޶�����
	}

}
