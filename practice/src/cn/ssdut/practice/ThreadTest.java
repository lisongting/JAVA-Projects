package cn.ssdut.practice;
/**
 * �ü̳�Thread�ķ������Զ��߳�
 * @author LST
 *
 */
public class ThreadTest extends Thread {
	private int i=0;
	public void run(){
		for(;i<10;i++){
			System.out.println(getName()+" "+i);
		}
	}
	public static void main(String[] args) {
		for(int j=0;j<20;j++){
			System.out.println(Thread.currentThread().getName()+" "+j);
			if(j==15){
				new ThreadTest().start();//������������һ���߳�
				//new ThreadTest().start();//�����������ڶ����߳�
			}
		}
	}
}
