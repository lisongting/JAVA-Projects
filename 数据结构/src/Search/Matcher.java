package Search;

import java.util.ArrayList;

/**
 * 16.8.28
 * @author Administrator
 *
 */
public class Matcher {
	
	//(brute force)BFƥ���㷨��Ҳ������ƥ���㷨�ͱ���ƥ���㷨******************************************************
	//���ı���һλһλ����ģʽ�����жԱȣ������;��һλ����ͬ�����ı������±����һλ�������´�ģʽ���ĵ�һλ��ʼ���жԱ�
	public int NaiveStrMatch(String pattern,String text){//�����ı���text��Ҫƥ���ģʽ��pattern
		int t=0;//���text���±�
		int tlen = text.length();
		int plen = pattern.length();
		if(tlen<plen||plen==0||tlen==0)
			return -1;
		while(t<tlen){
			int p=0;
			int count=0;
			while(p<plen){
				if(text.charAt(t)==pattern.charAt(p)&&count<plen){
					p++;t++;count++;//�������ͬ��Ԫ����count++,��ʾ�ɹ�ƥ����count��Ԫ��
				}
				else{
					p=0;//�����;��һλû��ƥ��ɹ������ģʽ�����±�p������Ϊ0
					count =0;//��count��ֵҲ����
					break;
				}
				if(count==plen)//��ƥ��ɹ���count��Ԫ�أ�˵�����ҵ�ģʽ��
					return t-plen;//���ظպ�ƥ�䵽ʱ��λ��
			}
			t++;
		}
		return -1;//���������ѭ����Ȼû�з���ֵ����˵��ƥ��ʧ��
	}
	//����ƥ���㷨***************************************************************************
	
	//KMP�㷨******************************************************************************
	//�õ�ģʽ����next����
	public int[] getNext(String pattern){
		char[] p = pattern.toCharArray();
		int[] next = new int[p.length];
		next[0] = -1;
		int j=0;
		int k=-1;
		//������֪��ǰjλ�Ʋ����j+1λ
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
		int t=0;//text���±�
		int p=0;//pattern���±�
		int plen = pattern.length();
		int tlen = text.length();
		while(p<plen&&t<tlen){
			if(p==-1||pattern.charAt(p)==text.charAt(t)){//����ı�����ģʽ����ĳһλƥ����ͬ����p��t����һ
				t++;p++;
			}
			else
				p = next[p];//���ƥ�䲻ͬ�����p��λ���ƶ���next[]����ָ����λ����ȥ
		}
		if(p==plen)//���ģʽ����ȫƥ��,�򷵻�����λ�õ��±�
			return t-plen;
		else
			return -1;
	}
	//KMP�㷨********************************************************************************
	
	//���ϵ�һ��sunday�㷨*****************************************************************************
	public int SundayMatch(String pattern,String text){
		int t=0;//text���±�
		int p=0;//pattern���±�
		int plen = pattern.length();
		int tlen = text.length();
		int findCount=0;
		int start =0;
		int moveNum = 0;
		ArrayList<Integer> index = new ArrayList<>();//���ArrayList�����ŵ�Ӧ�����ҵ�ƥ��Ŀ�괮�������±�
		if(plen>tlen||plen==0||tlen==0){
			return -1;
		}
		return 0;
		
	}
	//sunday�㷨*****************************************************************************
	
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
