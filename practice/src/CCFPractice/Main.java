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
			 * ������Interger(int value)����һ���·���� Integer ��������ʾָ���� int ֵ��char[i]��������ascII��*/
			sum +=itg;
		}
		System.out.println(sum);
	}

}
/*
 * ����һ��ʮ��������n�����n�ĸ�λ����֮��
 * ��������
	20151220
	�������
	13
	����˵��
����20151220�ĸ�λ����֮��Ϊ2+0+1+5+1+2+2+0=13��*/
