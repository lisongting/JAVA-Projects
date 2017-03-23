package nowcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int base = 26;
		//停留次数
		int move = n-m+1;
		int couple = (m+1)/2;
		int blank = n-m;
		//对称元素
		int f1 =1;
		//滑动
		int f2 =1;
		//空格
		int f3 = 1;
		for(int i=0;i<blank;i++){
			f3 = f3*base;
		}
		for(int i=0;i<couple;i++){
			f1 = f1*base;
		}
		for(int i=0;i<move;i++){
			f2 = f2*base;
		}
		long result = f1*f2*f3;
		long result = f1*f3*move;
		System.out.println(result);
	}
	/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		int m = sc.nextInt();
		int n = 0;
		for(long i=min;i<=max;i++){
			if(i % m==0){
				n++;
			}
		}
		System.out.println(n);

	}*/
	
	/*
	 * 
	 * ArrayList<char[]> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] mark = new int[n];
		String[] strArr = new String[n];
		for(int i=0;i<n;i++){
			strArr[i] = sc.nextLine();
		}
		for(int i=0;i<n;i++){
			char[] tmpCharArr = strArr[i].toCharArray();
			Arrays.sort(tmpCharArr);
			list.add(tmpCharArr);
		}
		int result = list.size();
		for(int i=0;i<n-1;i++){
			if(mark[i]==11){
				continue;
			}
			char[] tmp = list.get(i);
			int len = tmp.length;
			for(int j=i+1;j<n;j++){
				char[] tmp2 = list.get(j);
				if(tmp.length==len){
					for(int k=0;k<len;k++){
						if(tmp[k]==tmp2[k]){
							if(k==len-1){
								mark[j] = 11;
								result--;
							}
							continue;
						}else{
							break;
						}
						
					}
				}else{
					continue;
				}
			}
		}
		System.out.println(result);
		*/
}
