package nowcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
/**
 * 
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author Administrator
 *
 */
public class Main5 {
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	 public RandomListNode Clone(RandomListNode pHead)
	 {
		   if(pHead == null){
			   return null;
		   }
	       RandomListNode head;
	       RandomListNode cur = pHead;
	       //第一步：复制链表,将节点A复制后的节点A1，插在A后面	       
	       while(cur!=null){
	    	   RandomListNode copy = new RandomListNode(cur.label);
	    	   copy.next = cur.next;
	    	   cur.next = copy;
	    	   cur = copy.next;
	       }
	       //第二步：A1.random = A.random.next 
	       cur = pHead;
	       while(cur!=null){
	    	   if(cur.random!=null){
	    		   cur.next.random = cur.random.next;
	    	   }
	    	   cur = cur.next.next;
	       }
	       //第三步：拆开原来的链表
	       head = pHead.next;
	       RandomListNode move = head;
	       cur = pHead;
	       while(cur!=null){
	    	   cur.next = cur.next.next;
	    	   if(move.next!=null){
	    		   move.next = move.next.next;
	    	   }
	    	   move = move.next;
	    	   cur = cur.next;
	       }
	       return head;
	 }
	public static void main(String[] args) {
	}

}
