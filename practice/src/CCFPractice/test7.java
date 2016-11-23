package CCFPractice;
/**
 * 输入的第一行包含一个整数n，表示数列中整数的个数。
　　第二行包含n个整数a1, a2, …, an，表示给定的数列，相邻的整数之间用一个空格分隔。
输出格式
　　输出一个整数，表示给定的数列有多个段。
样例输入
8
8 8 8 0 12 12 8 0
样例输出
5
 */
import java.util.Scanner;

public class test7 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] array = new int[n];
		int num;
		int part =0;
		for(int i=0;i<n;i++)
			array[i] = input.nextInt();
		
		for(int i=0;i<n;i++){
			if(i==0)
				part++;
			else
				if(array[i]!=array[i-1])
				part++;
		}
		System.out.println(part);
	}

}
