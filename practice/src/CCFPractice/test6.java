package CCFPractice;

import java.util.Scanner;
/**
 * ���ڼ��㣬����һ����ݺ����֣�������ǵڼ��¼���
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
