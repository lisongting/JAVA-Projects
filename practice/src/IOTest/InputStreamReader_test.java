package IOTest;
/**
 * c����InputStreamReader�ࣺ���ֽ�������ת��Ϊ�ַ�������
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_test {

	public static void main(String[] args) {
		try{
			InputStreamReader reader = new InputStreamReader(System.in);
			
			BufferedReader br = new BufferedReader(reader);
			String line = null;
			while((line = br.readLine()) != null){
				if(line.equals("exit")){
					System.exit(1);
				}
				System.out.println("��������Ϊ��"+line);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
