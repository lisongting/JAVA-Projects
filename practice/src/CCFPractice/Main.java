package CCFPractice;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.next();
		char[] c = s.toCharArray();
		int sum =0;
		for(int i=0;i<c.length;i++){
			Integer itg = new Integer(c[i]-48);
			/*
			 * 构造器Interger(int value)构造一个新分配的 Integer 对象，它表示指定的 int 值。char[i]里面存的是ascII码*/
			sum +=itg;
		}
		System.out.println(sum);
	}

}
/*
 * 给定一个十进制整数n，输出n的各位数字之和
 * 样例输入
	20151220
	样例输出
	13
	样例说明
　　20151220的各位数字之和为2+0+1+5+1+2+2+0=13。*/
