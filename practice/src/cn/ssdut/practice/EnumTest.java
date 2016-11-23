package cn.ssdut.practice;
/**
 * 测试枚举类
 * 2016.7.24
 * @author LST
 *
 */

public class EnumTest {
	public void jugde(SeasonEnum s){
		switch(s){
		case SPRING:
			System.out.println("春天");
			break;
		case SUMMER:
			System.out.println("夏天");
			break;
		case FALL:
			System.out.println("秋天");
			break;
		case WINTER:
			System.out.println("冬天");
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
