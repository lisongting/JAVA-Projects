package Search;

import java.util.ArrayList;

/**
 * 16.8.28
 * @author Administrator
 *
 */
public class Matcher {
	
	//(brute force)BF匹配算法，也叫朴素匹配算法和暴力匹配算法******************************************************
	//将文本串一位一位地与模式串进行对比，如果中途有一位不相同，则将文本串的下标后移一位，再重新从模式串的第一位开始进行对比
	public int NaiveStrMatch(String pattern,String text){//输入文本串text和要匹配的模式串pattern
		int t=0;//标记text的下标
		int tlen = text.length();
		int plen = pattern.length();
		if(tlen<plen||plen==0||tlen==0)
			return -1;
		while(t<tlen){
			int p=0;
			int count=0;
			while(p<plen){
				if(text.charAt(t)==pattern.charAt(p)&&count<plen){
					p++;t++;count++;//如果有相同的元素则count++,表示成功匹配了count个元素
				}
				else{
					p=0;//如果中途有一位没有匹配成功，则把模式串的下标p重新置为0
					count =0;//把count的值也清零
					break;
				}
				if(count==plen)//当匹配成功了count个元素，说明已找到模式串
					return t-plen;//返回刚好匹配到时的位置
			}
			t++;
		}
		return -1;//运行完这个循环依然没有返回值，则说明匹配失败
	}
	//朴素匹配算法***************************************************************************
	
	//KMP算法******************************************************************************
	//得到模式串的next数组
	public int[] getNext(String pattern){
		char[] p = pattern.toCharArray();
		int[] next = new int[p.length];
		next[0] = -1;
		int j=0;
		int k=-1;
		//根据已知的前j位推测出第j+1位
		while(j<p.length-1){
			if(k==-1||p[j]==p[k]){
					next[++j] = ++k;
			}
			else{
				k = next[k];
			}
		}
		return next;
	}
	
	public int KMPMatch(String pattern,String text){
		int[] next = getNext(pattern);
		int t=0;//text的下标
		int p=0;//pattern的下标
		int plen = pattern.length();
		int tlen = text.length();
		while(p<plen&&t<tlen){
			if(p==-1||pattern.charAt(p)==text.charAt(t)){//如果文本串和模式串的某一位匹配相同，则p和t都加一
				t++;p++;
			}
			else
				p = next[p];//如果匹配不同，则把p的位置移动到next[]数组指定的位置上去
		}
		if(p==plen)//如果模式串完全匹配,则返回所在位置的下标
			return t-plen;
		else
			return -1;
	}
	//KMP算法********************************************************************************
	
	//网上的一个sunday算法*****************************************************************************
	public int SundayMatch(String pattern,String text){
		int t=0;//text的下标
		int p=0;//pattern的下标
		int plen = pattern.length();
		int tlen = text.length();
		int findCount=0;
		int start =0;
		int moveNum = 0;
		ArrayList<Integer> index = new ArrayList<>();//这个ArrayList里面存放的应该是找到匹配目标串的所有下标
		if(plen>tlen||plen==0||tlen==0){
			return -1;
		}
		return 0;
		
	}
	//sunday算法*****************************************************************************
	
	public static void main(String[] args) {
		String text = "ababcdabbabababad";
		String pattern = "abababa";
		int result;
		ArrayList<Integer> al= new ArrayList<Integer>();
		//result = new Matcher().NaiveStrMatch(pattern, text);
		//result = new Matcher().KMPMatch(pattern, text);
		al = new Matcher().SundayMatch(pattern, text);
		System.out.println(al.get(1));
		//System.out.println(result);
		
	}

}
