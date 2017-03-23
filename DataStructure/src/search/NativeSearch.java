package search;

//朴素匹配算法，也叫BF匹配算法或暴力匹配算法
//将文本串一位一位地与模式串进行对比，如果中途有一位不相同，
//则将文本串的下标后移一位，再重新从模式串的第一位开始进行对比
//该算法效率低
public class NativeSearch {
	public static int nativeSearch(String pattern,String text){
		int plen = pattern.length();	
		int tlen = text.length();
		int t = 0;//标记text的下标
		if(tlen<plen || tlen==0 || plen==0){
			return -1;
		}
		while(t<tlen){
			int p=0;
			int count=0;//count用来标记匹配成功了几个字符
			while(p<plen){
				//为了体现匹配的过程，因此没有直接使用text.indexOf(pattern)
				if(pattern.charAt(p)==text.charAt(t)){
					p++;t++;count++;
				}else{
					//如果中途有一位没有匹配成功
					p = 0;
					count =0;
					break;
				}
				//匹配成功,count的值和模式串长度相等
				if(count == plen){
					//返回刚好匹配到的位置索引
					return t - plen;
				}
			}
			t++;
		}
		return -1;
	}
	public static void main(String[] args) {
		String pattern = "abbc";
		String text = "abbdmnerabcdabbcdbccc";
		System.out.println(text.indexOf(pattern));
		System.out.println("朴素匹配到的位置是："+nativeSearch(pattern,text));
	}
	/**[运行结果]
	 * 12
	 * 朴素匹配到的位置是：12
	 */
}
