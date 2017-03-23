package search;

import java.util.Arrays;

public class KMPSearch {
	//朴素匹配算法低效：当模式串与文本进行匹配时，如果出现中途有一位匹配失败
	//便将模式串右移一位，用模式串的第一位与原来匹配的起点的后一位进行匹配
	//下面方法用来得到模式串的next数组next数组描述的是每个字符对应的*最长公共前后缀*
	//当模式串与文本进行匹配时，当匹配到某一位不匹配时，由next数组
	//可得知模式串应该后移的位数，从而避免像朴素匹配算法一样的低效匹配
	public static int[] getNext(String pattern){
		char[] p = pattern.toCharArray();
		int[] next = new int[p.length];
		next[0] = -1;
		int left = -1;//left作为前缀的索引
		int right = 0;//right作为后缀的索引
		//根据已知前right位推测出第right+1位
		while(right<p.length-1){
			//left等于-1表示初始时候的进入条件
			if(left==-1||p[right]==p[left]){
				right++;left++;
				next[right] = left;
			}else{
				left = next[left];
			}
		}
		return next;
	}
	
	public static int kmpSearch(String pattern,String text){
		int[] next = getNext(pattern);
		System.out.println("next数组为："+Arrays.toString(next));
		int t = 0;//text的下标
		int p = 0;//pattern的下标
		int plen = pattern.length();
		int tlen = text.length();
		while(p<plen && t<tlen){
			//如果在某一位匹配到，则p和t都加一
			if(p==-1||pattern.charAt(p)==text.charAt(t)){
				p++;t++;
			}else{
				//如果没有匹配到，则按照next数组进行移位
				p = next[p];
			}
		}
		//如果匹配成功，则返回所在位置的下标
		if(plen == p){
			return t - plen;
		}else{
			return -1;
		}		
	}
	
	public static void main(String[] args) {
		String pattern = "ababaaaba";
		String text = "abacaaababaaabaabaabb";
		System.out.println(text.indexOf(pattern));
		System.out.println("KMP算法查找到的位置是："+kmpSearch(pattern,text));
	}
	/**
	 6
	next数组为：[-1, 0, 0, 1, 2, 3, 1, 1, 2]
	KMP算法查找到的位置是：6
	 */
}
