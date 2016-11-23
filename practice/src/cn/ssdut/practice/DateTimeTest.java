package cn.ssdut.practice;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

/**
 * 测试有关日期和时间类的应用
 * LocalDateTime 好用
 * 2016.7.25
 * @author LST
 *
 */
public class DateTimeTest {

	public static void main(String[] args) {
		/*下面是clock的用法*/
		Clock clock = Clock.systemUTC();
		System.out.println("当前时刻为："+clock.instant());
		System.out.println(clock.millis());
		System.out.println();
		
		/*下面是Duration的用法*/
		Duration d = Duration.ofSeconds(6000);
		System.out.println("6000秒="+d.toMinutes()+"分");
		System.out.println("6000秒="+d.toHours()+"小时");//??????????????
		System.out.println("6000秒="+d.toDays()+"天");//??????????
		
		//在clock基础上增加6000秒，返回新的clock
		Clock clock2 = Clock.offset(clock,d);
		System.out.println("当前时间加6000秒为："+clock2.instant());
		System.out.println();
		
		/*下面是关于instant的用法*/
		Instant instant = Instant.now();//获取当前时间
		System.out.println("国际协调时间为："+instant);
		Instant instant2 = instant.plusSeconds(6000);
		System.out.println(instant2);
		Instant instant3 = Instant.parse("2015-02-15T10:12:35.342z");//根据字符串解析Instant对象
		System.out.println(instant3);
		Instant instant4 = instant3.plus(Duration.ofHours(5).plusMinutes(10));//在instant3的基础上加5小时10
		System.out.println(instant4);
		Instant instant5 = instant4.minus(Duration.ofDays(5));//获取instant4之前5天的时间
		System.out.println(instant5);
		Instant instant6 = instant.plus(Duration.ofHours(8));
		System.out.println("由于我国时间与国际协调时间相差为+8小时，所以当前中国时间为"+instant6);
		System.out.println();
		
		/*下面是关于LocalDate的用法*/
		LocalDate localdate = LocalDate.now();
		System.out.println(localdate);
		localdate = LocalDate.ofYearDay(2016, 182);//2016的182天
		System.out.println(localdate);
		localdate =  LocalDate.of(2015, Month.MAY, 20);
		System.out.println(localdate);
		System.out.println();
		
		/*下面是LocalTime的用法*/
		LocalTime localtime = LocalTime.now();
		System.out.println(localtime);
		LocalTime localtime2 = LocalTime.of(22, 23);//设置为22点23分
		System.out.println(localtime2);
		LocalTime localtime3 = LocalTime.ofSecondOfDay(6001);//一天中的6001秒
		System.out.println(localtime3);
		System.out.println();
		
		/*下面是LocalDateTime的用法*/
		LocalDateTime ldt = LocalDateTime.now();//localDateTime获取的就是当地时间而不是utc时间
		System.out.println(ldt);
		LocalDateTime ldt2 = ldt.plusHours(25).plusMinutes(10);//当前时刻加上25小时10分钟
		System.out.println(ldt2);
		System.out.println();
		
		/*下面是关于Year YearMonth MonthDay的用法*/
		Year year = Year.now();
		System.out.println(year);
		Year year2  = year.plusYears(3);
		System.out.println(year2);
		YearMonth ym = year.atMonth(10);
		System.out.println(ym);
		ym = ym.plusYears(3).minusMonths(2);//加3年减2个月
		System.out.println(ym);
		MonthDay md = MonthDay.now();
		System.out.println(md);
		MonthDay md2 = md.with(Month.MAY).withDayOfMonth(23);
		System.out.println("5月23日为："+md2);
	}

}
