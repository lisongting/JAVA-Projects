package AboutNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
/**
 * ģ��ͻ���/������ģʽ
 * 26.8.8
 * @author LST
 *
 */
public class ServerThread implements Runnable{
	Socket s = null;
	BufferedReader br = null;
	
	public ServerThread(Socket s)throws IOException{
		this.s = s;
		//��ʼ����Socket��Ӧ��������
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	@Override
	public void run() {
		try{
			String content = null;
			while((content=readFromClient())!=null){
				//����socketList�е�ÿһ��Socket
				//��������������ÿ��Socket����һ��
				for(Socket s:MyServer.socketList){
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.println(content);
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public String readFromClient(){
		try{
			return br.readLine();
		}catch(IOException e){
			MyServer.socketList.remove(s);//ɾ����Socket
		}
		return null;
	}
	
}
