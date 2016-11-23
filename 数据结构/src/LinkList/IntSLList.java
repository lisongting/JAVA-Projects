package LinkList;

public class IntSLList {
	protected IntSLLNode head,tail;
	public IntSLList(){
		head = tail=null;
	}
	public boolean isEmpty(){
		return head ==null;
	}
	public void addToHead(int e){
		head = new IntSLLNode(e);
		if(tail==null)
			tail = head;//？？
	}
	public void addToTail(int e){
		if(!isEmpty()){
			tail.next = new IntSLLNode(e);
			tail = tail.next;
		}
		else{
			head = tail = new IntSLLNode(e);
		}
	}
	public int deleteFromHead(){
		int e = head.info;
		if(head == tail){//如果表中只有一个节点
			head = tail=null;
		}
		else 
			head = head.next;//头部后移，然后把头部的info数值返回
		return e;
	}
	public int deleteFromTail(){
		int e = tail.info;
		if(head ==tail)
			head=tail=null;//如果表中只有一个节点，则首尾置空
		else{
			IntSLLNode tmp;
			for(tmp = head;tmp.next!=tail;tmp = tmp.next);//把tmp的位置移到尾部
			tail = tmp;//走完上面的for循环，说明tmp已经移动到tail的前一位，此时把tail前移到tmp位置，
			tail.next = null;//再把该删除的那个尾节点删除
		}
		return e;
	}
	public void printAll(){
		for(IntSLLNode tmp = head;tmp!=null;tmp = tmp.next ){
			System.out.println(tmp.info+"   ");
		}
	}
	public boolean isInList(int el){//判断某个元素是否在链表里
		IntSLLNode tmp;
		for(tmp = head;tmp!=null&&tmp.info!=el;tmp = tmp.next);
			return tmp!=null;
	}
	
	public void delete(int el){
		if(!isEmpty()){
			if(head ==tail &&el == head.info)//如果表中只有一个节点,并且这个节点等于el
				head = tail =null;
			else if(el ==head.info){//如果表中不止一个节点,且头结点的值等于el
				head = head.next;
			}
			else{//如果表中不止一个节点且头结点不等于el
				IntSLLNode pred,tmp;
				//一前一后两个临时节点同时向后移动到链表尾部,直到找到元素el
				for(pred = head,tmp=head.next;tmp!=null&&tmp.info!=el;pred = pred.next,tmp = tmp.next);
				
				if(tmp!=null){
					pred.next = tmp.next;
					if(tmp==tail)
						tail = pred;
				}
			}
		}
		
	}
}
