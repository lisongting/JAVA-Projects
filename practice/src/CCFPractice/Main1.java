package CCFPractice;

import java.util.Scanner;
/**
 * ISBN号码
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
/*每一本正式出版的图书都有一个ISBN号码与之对应，ISBN码包括9位数字、1位识别码和3位分隔符，其规定格式如“x-xxx-xxxxx-x”，其中符号“-”是分隔符（键盘上的减号），最后一位是识别码，例如0-670-82162-4就是一个标准的ISBN码。ISBN码的首位数字表示书籍的出版语言，例如0代表英语；第一个分隔符“-”之后的三位数字代表出版社，例如670代表维京出版社；第二个分隔之后的五位数字代表该书在出版社的编号；最后一位为识别码。
　　识别码的计算方法如下：
　　首位数字乘以1加上次位数字乘以2……以此类推，用所得的结果mod 11，所得的余数即为识别码，如果余数为10，则识别码为大写字母X。例如ISBN号码0-670-82162-4中的识别码4是这样得到的：对067082162这9个数字，从左至右，分别乘以1，2，…，9，再求和，即0×1+6×2+……+2×9=158，然后取158 mod 11的结果4作为识别码。
　　编写程序判断输入的ISBN号码中识别码是否正确，如果正确，则仅输出“Right”；如果错误，则输出是正确的ISBN号码。*/
