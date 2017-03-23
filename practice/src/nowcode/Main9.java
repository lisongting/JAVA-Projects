package nowcode;
/**
 * 实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但是与"aa.a"和"ab*a"均不匹配
 * @author Administrator
 *
 */
public class Main9 {
    public boolean match(char[] str, char[] pattern)
    {
       if(str==null || pattern == null){
    	   return false;
       }
       int sIndex = 0;
       int pIndex = 0;
       return matchCore(str,sIndex,pattern,pIndex);
    }
    public boolean matchCore(char[] str,int sIndex,char[] pattern,int pIndex){
    	//有效性检验，str从头到尾，pattern到尾，匹配成功
    	if(sIndex == str.length && pIndex==pattern.length){
    		return true;
    	}
    	//patter先到尾，匹配失败
    	if(sIndex !=str.length && pIndex==pattern.length){
    		return false;
    	}
    	//模式第二个是*,且字符串第1个与模式第1个匹配，分3种匹配模式，如果不匹配，则模式后移2位
    	if(pIndex+1 < pattern.length && pattern[pIndex+1]=='*'){
    		if((sIndex != str.length && pattern[pIndex] == str[sIndex])||
    				(pattern[pIndex] == '.' && sIndex != str.length)){
    			return matchCore(str, sIndex, pattern, pIndex + 2)//模式后移2，视为x*匹配0个字符
    					||matchCore(str, sIndex + 1, pattern, pIndex + 2)//视为模式匹配1个字符
    					||matchCore(str, sIndex + 1, pattern, pIndex);//*匹配1个，再匹配str中的下一个
    		}else{
    			return matchCore(str, sIndex, pattern, pIndex + 2);
    		}
    	}
    	//模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
    	if ((sIndex != str.length && pattern[pIndex] == str[sIndex]) || (pattern[pIndex] == '.' && sIndex != str.length)) {
    		return matchCore(str, sIndex + 1, pattern, pIndex + 1);
    	}
    	return false;
    }
	public static void main(String[] args) {
		

	}

}
