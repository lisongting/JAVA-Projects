package CCFPractice;
/**
 * ����ĵ�һ�а���һ������n����ʾ�����������ĸ�����
�����ڶ��а���n������a1, a2, ��, an����ʾ���������У����ڵ�����֮����һ���ո�ָ���
�����ʽ
�������һ����������ʾ�����������ж���Ρ�
��������
8
8 8 8 0 12 12 8 0
�������
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
