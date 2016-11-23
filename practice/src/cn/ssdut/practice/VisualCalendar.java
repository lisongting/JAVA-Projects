package cn.ssdut.practice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ���ӻ���������
 * �����calendar������
 * 2016 6 29
 * @author LST
 *
 */
public class VisualCalendar {
	public static void main(String[] args) {
		System.out.println("�밴�ո�ʽ����һ�����ڣ���ʽ��2016-6-30");
		Scanner input = new Scanner(System.in);
		String temp = input.next();
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		//���try-catch ������
		try{
		Date date = format.parse(temp);
		Calendar calendar = new GregorianCalendar(); 
		calendar.setTime(date);		
		
		int today = calendar.get(Calendar.DATE);
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		calendar.set(calendar.DATE,1);
		
		int DayofWeek = calendar.get(calendar.DAY_OF_WEEK);//��һ�����ܼ�
		
		int maxDate  = calendar.getActualMaximum(calendar.DATE);//һ���·��ж�����
		for(int i=0;i<DayofWeek-1;i++){
			System.out.print("\t");     //��ӡǰ��Ŀհ�
		}
		for(int i=1;i<=maxDate;i++){
			if(i==today){
				System.out.print("*");//����������ϼ�һ��*��
			}
			System.out.print(i+"\t");
			int w = calendar.get(Calendar.DAY_OF_WEEK);
			if(w==Calendar.SATURDAY){
				System.out.print("\n");
			}
			calendar.add(Calendar.DATE,1);//ÿ��ӡһ�ΰ����ڼ�һ����������һֱ����һ��ֵ
		}
		
		}catch(ParseException e){
			e.printStackTrace();
		}                             
		
		
	}
}
