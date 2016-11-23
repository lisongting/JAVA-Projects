package cn.ssdut.practice;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * ���Ա������ϵķ�����lambda���ʽ��iterator
 * @author LST
 *
 */
public class LambdaTest {

	public static void main(String[] args) {
		
		//��lambda���ʽ��������
		Collection books = new HashSet();
		books.add("dadsa");
		books.add("qqqqqqq");
		books.add("456dd");
		books.add("132");
		books.add("13dfaa2");
		books.forEach(aa->System.out.println("��������Ԫ��:"+aa));//lambda���ʽ��Ŀ�����͵�consumer
		System.out.println();
		
		//��iterator��������
		Iterator it = books.iterator();
		while(it.hasNext()){
			String book = (String)it.next();//����it.next()���ص���Object���ͣ�����ǿתΪString
			System.out.println(book);
		}
		
		//��lambda���ʽ����iterator
		Iterator it2 = books.iterator();
		it2.forEachRemaining(obj->System.out.println("��������Ԫ��"+obj));
		
		//��foreachѭ����������
		for(Object obj:books){
			String book  = (String)obj;
			System.out.println(book);
		}
	}

}
