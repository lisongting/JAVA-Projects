package IOTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
/**
 * �����ض����׼���
 * @author LST
 *
 */
public class RedirectOut {

	public static void main(String[] args) {
		try(
		PrintStream ps = new PrintStream(new FileOutputStream("out.txt"))){
			System.setOut(ps);//�ѱ�׼����ض�λ��ps�����
			System.out.println("��ͨ�ַ���");
			System.out.println("5124f6ayyy1");
			System.out.println("yyy1");
			
			System.out.println(new RedirectOut());
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
