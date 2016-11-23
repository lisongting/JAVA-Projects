package cn.ssdut.practice;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 测试遍历集合的方法：lambda表达式、iterator
 * @author LST
 *
 */
public class LambdaTest {

	public static void main(String[] args) {
		
		//用lambda表达式遍历集合
		Collection books = new HashSet();
		books.add("dadsa");
		books.add("qqqqqqq");
		books.add("456dd");
		books.add("132");
		books.add("13dfaa2");
		books.forEach(aa->System.out.println("迭代集合元素:"+aa));//lambda表达式的目标类型的consumer
		System.out.println();
		
		//用iterator遍历集合
		Iterator it = books.iterator();
		while(it.hasNext()){
			String book = (String)it.next();//由于it.next()返回的是Object类型，所以强转为String
			System.out.println(book);
		}
		
		//用lambda表达式遍历iterator
		Iterator it2 = books.iterator();
		it2.forEachRemaining(obj->System.out.println("迭代集合元素"+obj));
		
		//用foreach循环遍历集合
		for(Object obj:books){
			String book  = (String)obj;
			System.out.println(book);
		}
	}

}
