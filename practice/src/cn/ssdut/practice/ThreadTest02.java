package cn.ssdut.practice;
/**
 * 用继承Runnable接口的方法实现多线程
 * 3步骤!
 * @author LST
 *
 */
public class ThreadTest02 implements Runnable{
	private int i=0;
	public void run(){
		for(i=0;i<10;i++){
			System.out.println("ThreadTest02在运行"+i);
		}
	}
	public static void main(String[] args) {
		ThreadTest02 test = new ThreadTest02(); //1.创建真实角色
		Thread T = new Thread(test);			//2.Thread代理 +真实角色的引用
		T.start();                				//3.线程启动
		for(int j=0;j<10;j++){
			System.out.println(Thread.currentThread().getName()+" "+j);
		}
	}
}
