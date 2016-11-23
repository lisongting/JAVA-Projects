package cn.ssdut.practice;
/**
 * 测试垃圾回收机制
 * 2016.7.24
 * @author LST
 *
 */
public class GcTest {

	public static void main(String[] args) {
		for(int i=0;i<4;i++){
			new GcTest();
			System.gc();
		}
	}
	public void finalize(){
		System.out.println("正在清理Gc对象的资源");
	}

}
