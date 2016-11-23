package AboutNet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * ģ��ͻ���/������ģʽ
 * 26.8.8
 * @author LST
 *
 */
public class MyServer {
	//���屣������Socket��ArrayList,�������װ���̰߳�ȫ��
	public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());
	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(30000);
		while(true){
			Socket s = ss.accept();//���д��뽫������,��һֱ�ȴ����˵�����
			socketList.add(s);
			//ÿ���ͻ������Ӻ������һ��ServerThread�߳�Ϊ�ÿͻ��˷���
			new Thread(new ServerThread(s)).start();
		}
	}

}
