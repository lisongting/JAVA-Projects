package APPServerTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(30000);
		while (true){
			Socket s  = ss.accept();
//			OutputStream os = s.getOutputStream();
//			os.write("�յ����Է��������ʺ�<�������>".getBytes("utf-8"));
//			os.close();
			InputStream inputStream =  s.getInputStream();
			InputStreamReader inputSReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(inputSReader);
			String ip = s.getInetAddress().toString();
			String tmp ;
			System.out.println(ip);
			while((tmp=reader.readLine())!=null){
				System.out.println("app��������Ϣ��"+tmp+",app��ip��+"+ip);;
			}
			s.close();
		}
	}

}
