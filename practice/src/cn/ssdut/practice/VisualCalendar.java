package cn.ssdut.practice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 可视化日历程序
 * 加深对calendar类的理解
 * 2016 6 29
 * @author LST
 *
 */
public class VisualCalendar {
	public static void main(String[] args) {
		System.out.println("请按照格式输入一个日期，格式如2016-6-30");
		Scanner input = new Scanner(System.in);
		String temp = input.next();
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		//这个try-catch 看不懂
		try{
		Date date = format.parse(temp);
		Calendar calendar = new GregorianCalendar(); 
		calendar.setTime(date);		
		
		int today = calendar.get(Calendar.DATE);
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		calendar.set(calendar.DATE,1);
		
		int DayofWeek = calendar.get(calendar.DAY_OF_WEEK);//这一天是周几
		
		int maxDate  = calendar.getActualMaximum(calendar.DATE);//一个月份有多少天
		for(int i=0;i<DayofWeek-1;i++){
			System.out.print("\t");     //打印前面的空白
		}
		for(int i=1;i<=maxDate;i++){
			if(i==today){
				System.out.print("*");//今天的日期上加一个*号
			}
			System.out.print(i+"\t");
			int w = calendar.get(Calendar.DAY_OF_WEEK);
			if(w==Calendar.SATURDAY){
				System.out.print("\n");
			}
			calendar.add(Calendar.DATE,1);//每打印一次把日期加一。否则日期一直就是一个值
		}
		
		}catch(ParseException e){
			e.printStackTrace();
		}                             
		
		
	}
}
