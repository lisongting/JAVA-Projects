package CCFPractice;

import java.util.Scanner;
/**
 * 给定n个整数表示一个商店连续n天的销售量。如果某天之前销售量在增长，而后一天销售量减少，则称这一天为折点，
 * 反过来如果之前销售量减少而后一天销售量增长，也称这一天为折点。其他的天都不是折点。
 * 输出格式
　　输出一个整数，表示折点出现的数量。
	样例输入
	7
	5 4 1 2 3 6 4
	样例输出
	2
 * @author LST
 *
 */
public class test2 {
	public static void main(String[] args) {
		int sum = 0;
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int [] array = new int[number];
		for(int i=0;i<number;i++){
			array[i] = input.nextInt();
		}
		for(int i=1;i<number-1;i++){
			if(array[i-1]<array[i]&&array[i+1]<array[i])
					sum++;				
			else if(array[i-1]>array[i]&&array[i+1]>array[i])
					sum++;
		}
		System.out.println(sum);			
	}
}
