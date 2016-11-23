package CCFPractice;

import java.util.Scanner;
/**
 * 日期计算，给定一个年份和数字，输出这是第几月几日
 * @author Administrator
 *
 */
public class test6 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year = input.nextInt();
		int days = input.nextInt();
		int[] m = {31,28,31,30,31,30,31,31,30,31,30,31};
		if((year%400==0)||(year%4==0 && year%100!=0))
			m[1] = 29;
		int day=-1;
		int i;
		for(i=0;i<12;i++){
			day = days-m[i];
			if(day<=0){
				break;
			}
			days = day;
		}
		System.out.println(i+1);
		System.out.println(day+m[i]);
		
	}

}
