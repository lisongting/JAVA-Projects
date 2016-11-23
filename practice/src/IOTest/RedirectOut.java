package IOTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
/**
 * 测试重定向标准输出
 * @author LST
 *
 */
public class RedirectOut {

	public static void main(String[] args) {
		try(
		PrintStream ps = new PrintStream(new FileOutputStream("out.txt"))){
			System.setOut(ps);//把标准输出重定位到ps输出流
			System.out.println("普通字符串");
			System.out.println("5124f6ayyy1");
			System.out.println("yyy1");
			
			System.out.println(new RedirectOut());
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
