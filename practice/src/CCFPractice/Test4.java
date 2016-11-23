package CCFPractice;

import java.util.Scanner;
/**
 * 出现次数最多的数
 * @author LST
 *
 */
public class Test4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] numbers =new int[num];
		int [] count = new int[10001];
		for(int i=0;i<10001;i++){
			count[i]=0;
		}
		for(int i=0;i<num;i++){
			numbers[i] = input.nextInt();
			count[numbers[i]]++;
		}
		int maxCount=0;
		for(int i=0;i<10001;i++){
			if(count[i]>maxCount){
				maxCount = count[i];
			}
		}
		int min=10000;
		for(int i=0;i<10001;i++){
			if((count[i]==maxCount)&&(min>i)){
				min =i;
			}
		}
		System.out.println(min);
	}

}
