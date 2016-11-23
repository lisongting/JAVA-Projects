package cn.ssdut.practice;
/**
 * Join方法对其他线程造成阻塞，运行调用join的线程知道结束，再去运行其他线程
 * 对应的，有yield方法，该方法是阻塞调用者线程，去执行其他线程
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
