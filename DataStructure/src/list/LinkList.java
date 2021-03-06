package list;
//单链表
public class LinkList<T> {
	//定义一个内部类
	private class Node{
		private T data;
		private Node next;
		public Node(){};
		public Node(T data,Node next){
			this.data = data;
			this.next = next;
		}
	}
	private Node header;
	private Node tail;
	private int size = 0;
	public LinkList(){
		//空链表
		header = tail = null;
	}
	public LinkList(T element){
		header = new Node(element,null);
		tail = header;
		size++;
	}
	public int length(){
		return size;
	}
	//根据索引查找指定位置的节点
	public Node getNodeByIndex(int index){
		if(index < 0||index >size-1){
			throw new IndexOutOfBoundsException("链表索引越界");
		}
		Node current = header;
		for(int i=0;i < size && current!=null;i++){
			if(i == index){
				return current;
			}
			current = current.next;
		}
		return null;
	}
	//根据节点返回所在的位置
	public int locate(T element){
		Node current = header;
		for(int i=0;i<size && current!= null;i++){
			if(element.equals(current.data)){
				return i;
			}
			current = current.next;
		}
		return -1;
	}
	//[重要]向指定下标处插入元素
	public void insert(int index,T element){
		if(index < 0 || index>size){
			throw new IndexOutOfBoundsException("链表索引越界");
		}
		if(header == null){
			add(element);
		}else{
			if(index==0){
				addAtHeader(element);				
			}else{
				//获取插入节点的前一个节点
				Node prev = getNodeByIndex(index -1);
				//prev的next指向新节点
				//让新节点的next指向原来prev的下一个节点
				prev.next = new Node(element,prev.next);
				size++;
			}
		}
	
	}
	public void add(T element){
		if(header == null){
			header = new Node(element,null);
			tail = header;
		}else{
			Node newNode = new Node(element,null);
			tail.next = newNode;
			tail = newNode;
		}
		size ++;
	}
	public void addAtHeader(T element){
		Node tmp = new Node(element,header);
		header = tmp;
		//如果在插入之前是空链表
		if(tail == null){
			tail = header;
		}
		size ++;
	}
	//[重要]删除指定索引处的元素
	public void delete(int index){
		if(index < 0 || index>size-1){
			throw new IndexOutOfBoundsException("链表索引越界");
		}
		Node del = null;
		//如果被删除的是头节点
		if(index ==0){
			header = null;
			header = header.next;
		}else{
			//获取删除节点的前一个节点
			Node prev = getNodeByIndex(index-1);
			//获取将要被删除的节点
			del = prev.next;
			prev.next = del.next;
			del = null;
		}
		size --;
	}
	public void remove(){
		delete(size -1);
	}
	public boolean isEmpty(){
		return size ==0;
	}
	public void clear(){
		Node current = header;
		for(int i=0;i<size && current != null;i++){
			Node nextNode = current.next;
			current = null;
			current = nextNode;
		}
		size = 0;
	}
	public String toString(){
		if(isEmpty()){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[");
			Node current = header;
			for(int i=0;i<size && current !=null;i++){
				sb.append(current.data+"  ");
				current = current.next;
			}
			sb.append("]");
			return sb.toString();
		}
		
	}
	public static void main(String[] args) {
		LinkList<String> list = new LinkList<>();
		list.insert(0, "aaaa");
		list.add("bbbb");
		list.add("wwww");
		System.out.println(list.toString());
		list.addAtHeader("cccc");
		System.out.println(list.toString());
		System.out.println("1号位置是"+list.getNodeByIndex(1).data);
		list.delete(1);
		System.out.println(list.toString());
		System.out.println("wwww在链表中的位置是："+list.locate("wwww"));
		
	}

}
