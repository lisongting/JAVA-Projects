package cn.ssdut.practice;
/**
 * Join�����������߳�������������е���join���߳�֪����������ȥ���������߳�
 * ��Ӧ�ģ���yield�������÷����������������̣߳�ȥִ�������߳�
 * @author LST
 *
 */
public class JoinDemo extends Thread {

	public void run(){
		for(int i=0;i<50;i++){
			System.out.println("JoinDemo......"+i);
		}
	}
	public static void main(String[] args) {
		JoinDemo JD = new JoinDemo();
		Thread t = new Thread(JD);
		t.start();
		for(int i=0;i<50;i++){
			if(i==30){
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("main.........."+i);
		}
	}
	
}
