package MultiThreadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {
	public static ArrayList<Socket> socketList = new ArrayList<>();//静态变量,从属于类
	public static void main(String[] args)throws IOException {
		ServerSocket ss = new ServerSocket(30000);
		while(true){
			Socket s = ss.accept();
			socketList.add(s);
			new Thread(new ServerThread(s)).start();
		}
	}

}
