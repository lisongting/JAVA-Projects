package nowcode;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author Administrator
 *
 */
public class Main8 {
    public static int Add(int num1,int num2) {
    	System.out.println("num1:"+Integer.toBinaryString(num1));
    	System.out.println("num2:"+Integer.toBinaryString(num2));
        while(num2!=0){
        	System.out.println();
        	int tmp = num1^num2;
        	num2 = (num1 & num2)<<1;
        	num1 = tmp;
        	System.out.println("num1:"+Integer.toBinaryString(num1));
        	System.out.println("num2:"+Integer.toBinaryString(num2));
        }
        return num1;
    }
	public static void main(String[] args) {
		 System.out.println(Add(5,7));
	}

}
