package cn.ssdut.practice;

public class EuclideanAlgorithm {

	public static int[] Euclidean(int a,int b){
		int[] rst = new int[3];
		int a0=a; int b0=b; int t0=0;
		int t=1;  int s0=1; int s=0;
		int q = a0/b0; int r = a0-q*b0;//ำเสý
		while(r>0){
			int temp = t0-q*t;
			t0 = t;
			t = temp;
			temp = s0-q*s;
			s0 = s;
			s = temp;
			a0 = b0;
			b0 = r;
			q = a0/b0;
			r = a0-q*b0;
		}
		r = b0;
		rst[0]=r;
		rst[1]=s;
		rst[2]=t;
		return rst;
	}
	public static void main(String[] args) {
		int a = 93;int b =57;
		int r[] = Euclidean(93,57);
		System.out.println("r  = "+r[0]);
		System.out.println("s  = "+r[1]);
		System.out.println("t  = "+r[2]);

	}

}
