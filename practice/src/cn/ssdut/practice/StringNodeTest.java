package cn.ssdut.practice;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
/**
 * 测试StringReaderDer和StringWriter用法
 * 16.8.5
 * @author LST
 *
 */
public class StringNodeTest {

	public static void main(String[] args) {
		String src = "vvvvxczxc\n"+"ffvxbbbxx\n"+"1531456fav\n";
		char[] buffer = new char[16];
		int hasread= 0;
		try(StringReader sr = new StringReader(src))
		{
			while((hasread=sr.read(buffer))>0){
				System.out.println(new String(buffer,0,hasread));
				}
		}catch (IOException ioe){
				ioe.printStackTrace();
			}
		
		try (StringWriter sw = new StringWriter())
		{
			sw.write("777777777\n");
			sw.write("111111111117\n");
			sw.write("8888888888\n");
			sw.write("5555555555\n");
			System.out.println("下面是sw字符串里面的内容");
			System.out.println(sw.toString());
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}

}
