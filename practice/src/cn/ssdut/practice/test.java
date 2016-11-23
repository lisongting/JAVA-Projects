package cn.ssdut.practice;
/**
 * 测试时间对象和字符串之间的相互转化
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class test {

public static void main(String[] args) {
	
	String str2 = "1989,7,8";
	DateFormat df2 = new SimpleDateFormat("yyyy,MM,dd");
	try{
	Date d = (Date) df2.parse(str2);
	System.out.println(d);
	}
	catch(ParseException e){
		e.printStackTrace();
	}
	System.out.println();
}
}
