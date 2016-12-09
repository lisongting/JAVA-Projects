package APPServerTest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(30000);
		while (true){
			Socket s  = ss.accept();
			OutputStream os = s.getOutputStream();
			os.write("收到来自服务器的问候<国庆快乐>".getBytes("utf-8"));
			os.close();
			s.close();
		}
	}

}
