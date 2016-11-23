package AboutNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
/**
 * 模拟客户端/服务器模式
 * 26.8.8
 * @author LST
 *
 */
public class ServerThread implements Runnable{
	Socket s = null;
	BufferedReader br = null;
	
	public ServerThread(Socket s)throws IOException{
		this.s = s;
		//初始化该Socket对应的输入流
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	@Override
	public void run() {
		try{
			String content = null;
			while((content=readFromClient())!=null){
				//遍历socketList中的每一个Socket
				//将读到的内容向每个Socket发送一次
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
			MyServer.socketList.remove(s);//删除该Socket
		}
		return null;
	}
	
}
