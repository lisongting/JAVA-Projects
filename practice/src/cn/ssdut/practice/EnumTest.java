package cn.ssdut.practice;
/**
 * ����ö����
 * 2016.7.24
 * @author LST
 *
 */

public class EnumTest {
	public void jugde(SeasonEnum s){
		switch(s){
		case SPRING:
			System.out.println("����");
			break;
		case SUMMER:
			System.out.println("����");
			break;
		case FALL:
			System.out.println("����");
			break;
		case WINTER:
			System.out.println("����");
			break;
			
		}
	}
	public static void main(String[] args) {
		for(SeasonEnum s:SeasonEnum.values()){
			System.out.println(s);
			
		}
		
		new EnumTest().jugde(SeasonEnum.FALL);
	}

}
