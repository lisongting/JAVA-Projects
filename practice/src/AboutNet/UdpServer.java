package AboutNet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
	public static final int PORT = 30000;
	private static final int DATA_LEN = 4096;
	byte[] inBuff = new byte[DATA_LEN];
	private DatagramPacket inPacket = new DatagramPacket(inBuff,inBuff.length);
	private DatagramPacket outPacket;
	String[] books = new String[] {"java����","java EE","android","Ajax"};
	
	public void init()throws IOException{
		try(
			DatagramSocket socket = new DatagramSocket(PORT))
		{
			for(int i =0;i<100;i++){
				//��ȡsocket�е�����,���������ݷ��뵽inPacket��װ��������
				socket.receive(inPacket);
				//�ж�inPacket.getData()��inBuff�Ƿ���ͬһ������
				System.out.println(inBuff==inPacket.getData());
				//�����յ�������ת�����ַ��������
				System.out.println(new String(inBuff,0,inPacket.getLength()));
				//���ַ���������ȡ��һ��Ԫ����Ϊ��������
				byte[] sendData = books[i%4].getBytes();
				//��ָ�����ֽ�������Ϊ��������,�Ըս��ܵ���DatagramePacket��ԴSocketAddress��ΪĿ��SocketAddress����DatagramPacket
				outPacket = new DatagramPacket(sendData,sendData.length,inPacket.getSocketAddress());
				socket.send(outPacket);
			}
		} 
		
	}
	public static void main(String[] args)throws IOException {
		new UdpServer().init();
	}

}
