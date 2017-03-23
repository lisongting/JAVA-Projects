package nowcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * 牛客网的一道机考题
 * 目的：将输入的ip地址进行排序，剔除不正确的ip地址，然后将剩余的进行排序并输出
 * 输入：
 * 80.1.1.1
 * 90.1.1.1
 * 180.1.1.1
 * 190.1.1.1
 * 200.1.1.1
 * 应输出：
 * 
 * @author Administrator
 *
 */
public class Main {
	public class IP{
		public String special;
		public int a;
		public int b;
		public int c;
		public int d;
		public IP(int a,int b,int c,int d){
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			if(isEffective()){
				if(a>=0&&a<=127){
					special = "A";
				}else if(a>=128 && a<=191){
					special = "B";
				}else if(a>=192&&a<=223){
					special = "C";
				}else if(a>=224&&a<=239){
					special = "D";
				}else if(a>=240&&a<=255){
					special = "E";
				}else{
					special = "NO";
				}
			}else{
				special = "NO";
			}
		}
		public boolean isEffective(){
			if(a>255 || b>255 ||c>255||d>255){
				return false;
			}else if(a<0||b<0||c<0||d<0){
				return false;
			}else {
				return true;
			}
		}
		public String toString(){
			return a+"."+b+"."+c+"."+d;
		}
		public boolean equals(IP t){
			if(t==null){
				return false;
			}
			if(t.a==this.a && t.b==this.b&&t.c== this.c&&t.d ==this.d){
				return true;
			}
			
			return false;
		}
		public boolean biggerThan(IP t){
			if(!t.isEffective()){
				return true;
			}
			if(this.a>t.a){
				return true;	
			}else if(this.a==t.a){
				if(this.b>t.b){
					return true;
				}else if(this.b==t.b){
					if(this.c>t.c){
						return true;
					}else if(this.c==t.c){
						if(this.d>t.d){
							return true;
						}else if(this.d==t.d){
							return false;
						}else{
							return false;
						}
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] ips = new String[5];
		int[][] matric = new int[5][4];
		Main main = new Main();
		Main.IP ip0,ip1,ip2,ip3,ip4;
		int t=0;
		while(t<5){
			ips[t++] = sc.next();
		}
		String[][] str2 = new String[5][4];
		String mm = new String("\\.");
		str2[0] = ips[0].split("\\.");
		str2[1] = ips[1].split("\\.");
		str2[2] = ips[2].split("\\.");
		str2[3] = ips[3].split("\\.");
		str2[4] = ips[4].split("\\.");
		for(int i=0;i<5;i++){
			for(int j=0;j<4;j++){
				matric[i][j] = Integer.parseInt(str2[i][j]);
			}
		}
		ip0 = main.new IP(matric[0][0],matric[0][1],matric[0][2],matric[0][3]);
		ip1 = main.new IP(matric[1][0],matric[1][1],matric[1][2],matric[1][3]);
		ip2 = main.new IP(matric[2][0],matric[2][1],matric[2][2],matric[2][3]);
		ip3 = main.new IP(matric[3][0],matric[3][1],matric[3][2],matric[3][3]);
		ip4 = main.new IP(matric[4][0],matric[4][1],matric[4][2],matric[4][3]);
		IP[] ipArr = new IP[5];
		int size = 0;
		if(ip0.isEffective()){
			ipArr[0] = ip0;			
			size++;
		}
		if(ip1.isEffective()){
			ipArr[1] = ip1;			
			size++;
		}
		if(ip2.isEffective()){
			ipArr[2] = ip2;	
			size++;
		}
		if(ip3.isEffective()){
			ipArr[3] = ip3;	
			size++;
		}
		if(ip4.isEffective()){
			ipArr[4] = ip4;	
			size++;
		}
		IP[] result = main.sort(ipArr,size); 
		
		List<IP> A = new ArrayList<>();
		List<IP> B = new ArrayList<>();
		List<IP> C = new ArrayList<>();
		List<IP> D = new ArrayList<>();
		List<IP> E = new ArrayList<>();
		for(int i=0;i<result.length;i++){
			if(result[i].special=="A"){
				A.add(result[i]);
			}else if(result[i].special=="B"){
				B.add(result[i]);
			}else if(result[i].special=="C"){
				C.add(result[i]);
			}else if(result[i].special=="D"){
				D.add(result[i]);
			}else if(result[i].special=="E"){
				E.add(result[i]);
			}
		}
		
		if(A.size()>0)
		System.out.println("A:"+A.toString());
		if(B.size()>0)
		System.out.println("B:"+B.toString());
		if(C.size()>0)
		System.out.println("C:"+C.toString());
		if(D.size()>0)
		System.out.println("D:"+D.toString());
		if(E.size()>0)
		System.out.println("E:"+E.toString());
		
		
	}
	
	public IP[] sort(IP[] ipArr,int size){
		//最简单的冒泡排序啊
		for(int i=0;i<size-1;i++){
			for(int j=0;j<size-i-1;j++){
				if(ipArr[i].biggerThan(ipArr[i+1])){
					IP tmp = ipArr[i];
					ipArr[i] = ipArr[i+1];
					ipArr[i+1] = tmp;
				}
			}
		}
		return ipArr;
	}
}
