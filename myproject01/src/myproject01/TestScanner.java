package myproject01;
import java.util.Scanner;

public class TestScanner {
	public static void test01()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("������һ������");
		int a = s.nextInt();
		System.out.println("��������һ������");
		int b = s.nextInt();
		int c = a+b;
		System.out.println("��Ϊ"+c);
	}
	public static void main(String args[])
	{
		test01();
	
	}
}
