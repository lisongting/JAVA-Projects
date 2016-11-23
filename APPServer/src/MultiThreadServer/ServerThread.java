package MultiThreadServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;


/**
 * 模拟安卓C/S结构多人聊天  的服务器端
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
			System.out.println("收到来自客户端的数据:"+content);
			//遍历socketList中的每个socket
			//将读到的内容发送给每个socket
			for(Iterator<Socket> it = MyServer.socketList.iterator();it.hasNext();){
				Socket s = it.next();
				try{
					OutputStream os = (OutputStream) s.getOutputStream();
					os.write((content+"\n").getBytes("utf-8"));//把从客户端接收到的数据写到socket中,发送给每一个Socket
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
