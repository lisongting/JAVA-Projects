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
			tail = head;//����
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
		if(head == tail){//�������ֻ��һ���ڵ�
			head = tail=null;
		}
		else 
			head = head.next;//ͷ�����ƣ�Ȼ���ͷ����info��ֵ����
		return e;
	}
	public int deleteFromTail(){
		int e = tail.info;
		if(head ==tail)
			head=tail=null;//�������ֻ��һ���ڵ㣬����β�ÿ�
		else{
			IntSLLNode tmp;
			for(tmp = head;tmp.next!=tail;tmp = tmp.next);//��tmp��λ���Ƶ�β��
			tail = tmp;//���������forѭ����˵��tmp�Ѿ��ƶ���tail��ǰһλ����ʱ��tailǰ�Ƶ�tmpλ�ã�
			tail.next = null;//�ٰѸ�ɾ�����Ǹ�β�ڵ�ɾ��
		}
		return e;
	}
	public void printAll(){
		for(IntSLLNode tmp = head;tmp!=null;tmp = tmp.next ){
			System.out.println(tmp.info+"   ");
		}
	}
	public boolean isInList(int el){//�ж�ĳ��Ԫ���Ƿ���������
		IntSLLNode tmp;
		for(tmp = head;tmp!=null&&tmp.info!=el;tmp = tmp.next);
			return tmp!=null;
	}
	
	public void delete(int el){
		if(!isEmpty()){
			if(head ==tail &&el == head.info)//�������ֻ��һ���ڵ�,��������ڵ����el
				head = tail =null;
			else if(el ==head.info){//������в�ֹһ���ڵ�,��ͷ����ֵ����el
				head = head.next;
			}
			else{//������в�ֹһ���ڵ���ͷ��㲻����el
				IntSLLNode pred,tmp;
				//һǰһ��������ʱ�ڵ�ͬʱ����ƶ�������β��,ֱ���ҵ�Ԫ��el
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
