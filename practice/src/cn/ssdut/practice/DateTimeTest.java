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
 * �����й����ں�ʱ�����Ӧ��
 * LocalDateTime ����
 * 2016.7.25
 * @author LST
 *
 */
public class DateTimeTest {

	public static void main(String[] args) {
		/*������clock���÷�*/
		Clock clock = Clock.systemUTC();
		System.out.println("��ǰʱ��Ϊ��"+clock.instant());
		System.out.println(clock.millis());
		System.out.println();
		
		/*������Duration���÷�*/
		Duration d = Duration.ofSeconds(6000);
		System.out.println("6000��="+d.toMinutes()+"��");
		System.out.println("6000��="+d.toHours()+"Сʱ");//??????????????
		System.out.println("6000��="+d.toDays()+"��");//??????????
		
		//��clock����������6000�룬�����µ�clock
		Clock clock2 = Clock.offset(clock,d);
		System.out.println("��ǰʱ���6000��Ϊ��"+clock2.instant());
		System.out.println();
		
		/*�����ǹ���instant���÷�*/
		Instant instant = Instant.now();//��ȡ��ǰʱ��
		System.out.println("����Э��ʱ��Ϊ��"+instant);
		Instant instant2 = instant.plusSeconds(6000);
		System.out.println(instant2);
		Instant instant3 = Instant.parse("2015-02-15T10:12:35.342z");//�����ַ�������Instant����
		System.out.println(instant3);
		Instant instant4 = instant3.plus(Duration.ofHours(5).plusMinutes(10));//��instant3�Ļ����ϼ�5Сʱ10
		System.out.println(instant4);
		Instant instant5 = instant4.minus(Duration.ofDays(5));//��ȡinstant4֮ǰ5���ʱ��
		System.out.println(instant5);
		Instant instant6 = instant.plus(Duration.ofHours(8));
		System.out.println("�����ҹ�ʱ�������Э��ʱ�����Ϊ+8Сʱ�����Ե�ǰ�й�ʱ��Ϊ"+instant6);
		System.out.println();
		
		/*�����ǹ���LocalDate���÷�*/
		LocalDate localdate = LocalDate.now();
		System.out.println(localdate);
		localdate = LocalDate.ofYearDay(2016, 182);//2016��182��
		System.out.println(localdate);
		localdate =  LocalDate.of(2015, Month.MAY, 20);
		System.out.println(localdate);
		System.out.println();
		
		/*������LocalTime���÷�*/
		LocalTime localtime = LocalTime.now();
		System.out.println(localtime);
		LocalTime localtime2 = LocalTime.of(22, 23);//����Ϊ22��23��
		System.out.println(localtime2);
		LocalTime localtime3 = LocalTime.ofSecondOfDay(6001);//һ���е�6001��
		System.out.println(localtime3);
		System.out.println();
		
		/*������LocalDateTime���÷�*/
		LocalDateTime ldt = LocalDateTime.now();//localDateTime��ȡ�ľ��ǵ���ʱ�������utcʱ��
		System.out.println(ldt);
		LocalDateTime ldt2 = ldt.plusHours(25).plusMinutes(10);//��ǰʱ�̼���25Сʱ10����
		System.out.println(ldt2);
		System.out.println();
		
		/*�����ǹ���Year YearMonth MonthDay���÷�*/
		Year year = Year.now();
		System.out.println(year);
		Year year2  = year.plusYears(3);
		System.out.println(year2);
		YearMonth ym = year.atMonth(10);
		System.out.println(ym);
		ym = ym.plusYears(3).minusMonths(2);//��3���2����
		System.out.println(ym);
		MonthDay md = MonthDay.now();
		System.out.println(md);
		MonthDay md2 = md.with(Month.MAY).withDayOfMonth(23);
		System.out.println("5��23��Ϊ��"+md2);
	}

}
