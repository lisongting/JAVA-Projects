package nowcode;

import java.util.Arrays;
/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author Administrator
 *
 */
public class Main7 {
	public  void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		if(array==null||array.length==0){
			return;
		}
		int tmp =0 ;
		int len = array.length;
		for(int i=0;i<len;i++){
			tmp ^=array[i];
		}
		
		int index = findFirstBits(tmp);
		for(int i=0;i<len;i++){
			if(isBit(array[i],index)){
				num1[0] ^=array[i];
			}else{
				num2[0] ^=array[i];
			}
		}
    }
	public int findFirstBits(int val){
		int indexBit = 0;
		while(((val&1)==0) && (indexBit)<8*4){
			val = val >>1;
			indexBit++;
		}
		return indexBit;
	}
	
	public boolean isBit(int num,int indexBit){
		num = num>>indexBit;
		return (num & 1)==1;
	}
	public static void main(String[] args) {
		int[] re = new int[1];
		int[]re2 = new int[1];
		int[]test = new int[]{2,4,3,6,3,2,5,5};
		System.out.println(re[0]);
		System.out.println(re2[0]);
	}

}
