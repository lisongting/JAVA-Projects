package cn.ssdut.practice;
/**
 * ���lambda���ʽ
 * 2016.7.24
 * @author LST
 *
 */
interface Eatable{
	void taste();
}
interface Flyable {
	void fly(String weather);
}
interface Addable{
	int add(int a,int b);
}

public class LambdaQs {
	public void eat(Eatable e){
		System.out.println(e);
		e.taste();
	}
	public void drive (Flyable f){
		System.out.println("���ڼ�ʻ��"+f);
		f.fly("������");
	}
	public void test(Addable add){
		System.out.println("5 + 3 = " +add.add(5, 3));
	}
	public static void main(String[] args) {
		LambdaQs lq=new LambdaQs(); 
		lq.eat(()->System.out.println("ƻ��ζ������"));
		lq.drive(weather->
				{
					System.out.println("����������"+weather);	
					System.out.println("����ƽ��");
				});
		lq.test((a,b)->a+b);
	}

}
