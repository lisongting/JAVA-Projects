package CCFPractice;

import java.util.Scanner;
/**
 * ISBN����
 * @author LST
 *
 */
public class Main1 {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String s = input.next();
		String[] ss = s.split("-");
		int one = Integer.parseInt(ss[0]);
		int three = Integer.parseInt(ss[1]);
		int five = Integer.parseInt(ss[2]);
		char identify = ss[3].charAt(0);
		char tmp;
		tmp = new Main1().compute(one,three,five);
		if(tmp==identify){
			System.out.println("Right");
		}
		else{
			System.out.print(ss[0]+'-'+ss[1]+'-'+ss[2]+'-'+tmp);
		}
	}
	public char compute(int one,int three,int five){
		char c;
		int t1 = three/100;
		int t2 = (three-t1*100)/10;
		int t3 = three-t1*100-t2*10;
		int f1 = five/10000;
		int f2 = (five-f1*10000)/1000;
		int f3 = (five-f1*10000-f2*1000)/100;
		int f4 = (five-f1*10000-f2*1000-f3*100)/10;
		int f5 = five-f1*10000-f2*1000-f3*100-f4*10;
		int t = (one*1+t1*2+t2*3+t3*4+f1*5+f2*6+f3*7+f4*8+f5*9)%11;
		if(t==10){
			c = 'X';
		}
		else
		{
			c = (char)(t+48);
		}
		return c;
	}
}
/*ÿһ����ʽ�����ͼ�鶼��һ��ISBN������֮��Ӧ��ISBN�����9λ���֡�1λʶ�����3λ�ָ�������涨��ʽ�硰x-xxx-xxxxx-x�������з��š�-���Ƿָ����������ϵļ��ţ������һλ��ʶ���룬����0-670-82162-4����һ����׼��ISBN�롣ISBN�����λ���ֱ�ʾ�鼮�ĳ������ԣ�����0����Ӣ���һ���ָ�����-��֮�����λ���ִ�������磬����670����ά�������磻�ڶ����ָ�֮�����λ���ִ�������ڳ�����ı�ţ����һλΪʶ���롣
����ʶ����ļ��㷽�����£�
������λ���ֳ���1���ϴ�λ���ֳ���2�����Դ����ƣ������õĽ��mod 11�����õ�������Ϊʶ���룬�������Ϊ10����ʶ����Ϊ��д��ĸX������ISBN����0-670-82162-4�е�ʶ����4�������õ��ģ���067082162��9�����֣��������ң��ֱ����1��2������9������ͣ���0��1+6��2+����+2��9=158��Ȼ��ȡ158 mod 11�Ľ��4��Ϊʶ���롣
������д�����ж������ISBN������ʶ�����Ƿ���ȷ�������ȷ����������Right��������������������ȷ��ISBN���롣*/
