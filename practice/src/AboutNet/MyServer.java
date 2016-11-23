package AboutNet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 模拟客户端/服务器模式
 * 26.8.8
 * @author LST
 *
 */
public class MyServer {
	//定义保存所有Socket的ArrayList,并将其包装成线程安全的
	public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());
	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(30000);
		while(true){
			Socket s = ss.accept();//此行代码将会阻塞,将一直等待别人的连接
			socketList.add(s);
			//每当客户端连接后便启动一个ServerThread线程为该客户端服务
			new Thread(new ServerThread(s)).start();
		}
	}

}
