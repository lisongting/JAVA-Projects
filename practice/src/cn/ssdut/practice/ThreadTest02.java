package cn.ssdut.practice;
/**
 * �ü̳�Runnable�ӿڵķ���ʵ�ֶ��߳�
 * 3����!
 * @author LST
 *
 */
public class ThreadTest02 implements Runnable{
	private int i=0;
	public void run(){
		for(i=0;i<10;i++){
			System.out.println("ThreadTest02������"+i);
		}
	}
	public static void main(String[] args) {
		ThreadTest02 test = new ThreadTest02(); //1.������ʵ��ɫ
		Thread T = new Thread(test);			//2.Thread���� +��ʵ��ɫ������
		T.start();                				//3.�߳�����
		for(int j=0;j<10;j++){
			System.out.println(Thread.currentThread().getName()+" "+j);
		}
	}
}
