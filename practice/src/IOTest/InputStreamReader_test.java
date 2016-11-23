package IOTest;
/**
 * c测试InputStreamReader类：将字节输入流转化为字符输入流
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
				System.out.println("输入内容为："+line);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
