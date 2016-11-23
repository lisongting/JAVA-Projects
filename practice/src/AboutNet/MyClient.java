package AboutNet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
/**
 * ģ��ͻ���/������ģʽ
 * 26.8.8
 * @author LST
 *
 */
public class MyClient {

	public static void main(String[] args) throws Exception{
		Socket s = new Socket("127.0.0.1",30000);
		//����ClientThread�̲߳��϶�ȡ���Է�����������
		new Thread(new ClientThread(s)).start();
		PrintStream ps = new PrintStream(s.getOutputStream());
		String line = null;
		//���϶�ȡ���̵�����
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		while((line=br.readLine())!=null){
			//���û��ļ������������д��Socket��Ӧ�������
			ps.print(line);
		}
	}

}
