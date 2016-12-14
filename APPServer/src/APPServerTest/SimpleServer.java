package APPServerTest;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class SimpleServer {
	private JSONArray jsonArray;
	public void startServer()throws Exception{
		InetAddress inetAddress =InetAddress.getLocalHost();
		ServerSocket ss = new ServerSocket(30000);
		System.out.println("Server已启动");
		while (true){
			Socket s  = ss.accept();
			System.out.println("已连接一个客户端,接入时间："+getTime());
			String ip = s.getInetAddress().toString();
			System.out.println("客户端ip地址是："+ip);
			DataInputStream dis =  new DataInputStream(s.getInputStream());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] by = new byte[4096];
			int hasRead;
			while((hasRead = dis.read(by))!=-1){
				baos.write(by,0,hasRead);
			}
			String strInputstream = new String(baos.toByteArray());
			System.out.println("接收到json数据的长度是："+strInputstream.length());
			jsonArray = new JSONArray(strInputstream);
			int length = jsonArray.length();
			System.out.println("通讯录中联系人共有："+length+"位。");
			for(int i=0;i<length;i++){
				JSONObject jsonObj = null;
				jsonObj = jsonArray.getJSONObject(i);
				String name = (String) jsonObj.getString("name");
				String phone = (String)jsonObj.get("phone");
				System.out.print("name："+name+"  phone："+phone);
				System.out.println();
			}
			s.close();
		}
	}
	public static void main(String[] args){
		SimpleServer server = new SimpleServer();
		try{
			server.startServer();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public String getTime(){
		Date date = new Date();
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy--MM--dd HH:mm:ss");
		String str = sdf.format(date);
		return str;
	}
}
