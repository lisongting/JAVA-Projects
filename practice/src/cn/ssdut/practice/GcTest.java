package cn.ssdut.practice;
/**
 * �����������ջ���
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
		System.out.println("��������Gc�������Դ");
	}

}
