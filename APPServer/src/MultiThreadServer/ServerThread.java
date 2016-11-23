package MultiThreadServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;


/**
 * ģ�ⰲ׿C/S�ṹ��������  �ķ�������
 * @author Administrator
 *
 */
public class ServerThread implements Runnable {
	Socket s = null;
	BufferedReader br = null;
	public ServerThread(Socket s )throws IOException{
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
	}
	
	public void run() {
		String content =null;
		while((content =readFromClient())!=null){
			System.out.println("�յ����Կͻ��˵�����:"+content);
			//����socketList�е�ÿ��socket
			//�����������ݷ��͸�ÿ��socket
			for(Iterator<Socket> it = MyServer.socketList.iterator();it.hasNext();){
				Socket s = it.next();
				try{
					OutputStream os = (OutputStream) s.getOutputStream();
					os.write((content+"\n").getBytes("utf-8"));//�Ѵӿͻ��˽��յ�������д��socket��,���͸�ÿһ��Socket
				}catch(IOException e){
					e.printStackTrace();
					it.remove();
					System.out.println(MyServer.socketList);
				}
			}
		}
	}
	
	public String readFromClient(){
		try{
			return br.readLine();
		}catch(IOException e){
			e.printStackTrace();
			MyServer.socketList.remove(s);
		}
		return null;
	}

}
