package CCFPractice;

import java.util.Scanner;
/**
 * ����n��������ʾһ���̵�����n��������������ĳ��֮ǰ������������������һ�����������٣������һ��Ϊ�۵㣬
 * ���������֮ǰ���������ٶ���һ��������������Ҳ����һ��Ϊ�۵㡣�������춼�����۵㡣
 * �����ʽ
�������һ����������ʾ�۵���ֵ�������
	��������
	7
	5 4 1 2 3 6 4
	�������
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
