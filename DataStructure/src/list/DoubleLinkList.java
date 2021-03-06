package list;


//双链表
public class DoubleLinkList<T> {

	private class Node{
		private T data;
		private Node prev;
		private Node next;
		public Node(){};
		public Node(T data,Node prev,Node next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	private Node header;
	private Node tail;
	private int size = 0;
	public DoubleLinkList(){
		header = tail = null;
	}
	public DoubleLinkList(T element){
		header  = new Node(element,null,null);
		tail = header;
		size ++;
	}
	public int length(){
		return size;
	}
	public boolean isEmpty(){
		return 0 == size;
	}
	//获取下标为index的节点的值
	public T get(int index){
		return getNodeByIndex(index).data;
	}
	//根据索引查找节点
	public Node getNodeByIndex(int index){
		if(index < 0 || index > size-1){
			throw new IndexOutOfBoundsException("链表索引越界");
		}
		if(index <= size/2){
			Node current = header;
			for(int i=0;i<=size/2 && current != null;i++){
				if(i == index){
					return current;
				}
				current = current.next;
			}
		}else{
			Node current = tail;
			for(int i=size -1;i>size/2&&current!=null ;i++){
				if(i == index){
					return current;
				}
				current = current.prev;
			}
		}
		return null;
	}
	
	//根据值查找索引值
	public int locate(T element){
		Node current = header;
		for(int i=0;i<size && current != null;i++){
			if(element.equals(current.data)){
				return i;
			}
			current = current.next;
		}
		return -1;
	}
	//[重要]向指定索引处插入插入元素
	public void insert(T element,int index){
		if(index < 0 || index > size-1){
			throw new IndexOutOfBoundsException("链表索引越界");
		}
		if(header == null){
			add(element);
		}else{
			if(index ==0){
				addAtHeader(element);
			}else{
				//获取插入点的前一个节点
				Node prev = getNodeByIndex(index-1);
				//获取当前index处的节点
				Node next = prev.next;
				Node newNode = new Node(element,prev,next);
				prev.next = newNode;
				next.prev = newNode;
				size++;
			}
		}
		
	}
	//在末尾插入元素
	public void add(T element){
		if(header ==null){
			header = new Node(element,null,null);
			tail = header;
		}else{
			Node newNode = new Node(element,tail,null);
			tail.next = newNode;
			tail = newNode;
		}
		size ++;
	}
	public void addAtHeader(T element){
		Node newNode = new Node(element,null,header);
		header = newNode;
		//如果插入之前是空链表
		if(tail == null){
			tail = header;
		}
		size++;
	}
	//[重要]删除指定索引处的节点
	public void delete(int index){
		if(index < 0 || index > size-1){
			throw new IndexOutOfBoundsException("链表索引越界");
		}
		//如果要删除的是头节点
		if(index == 0){
			header = header.next;
			header.prev = null;
		}else if(index == size -1){//如果要删除尾节点
			Node prevNode = tail.prev;
			tail = null;
			prevNode.next=null;
			tail = prevNode;
		}else{
			//找到index位置之前的节点
			Node prevNode = getNodeByIndex(index-1);
			Node delNode = prevNode.next;
			Node nextNode = delNode.next;
			delNode =null;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
		}
		size --;
	}
	//删除最后一个节点
	public void remove(){
		delete(size-1);
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
		DoubleLinkList<String> list = new DoubleLinkList<>();
		list.add("aaa");
		list.add("bbb");
		list.insert("www", 1);
		System.out.println(list.toString());
		list.addAtHeader("ccc");
		System.out.println(list.toString());
		System.out.println("1号位置的元素是"+list.get(1));
		list.delete(2);
		System.out.println("调用delete(2)之后的链表："+list.toString());
		list.remove();
		System.out.println("调用remove()之后的链表："+list.toString());
		list.add("ttt");
		System.out.println("插入ttt之后"+list.toString());
		System.out.println("ttt存放的索引值是:"+list.locate("ttt"));
		list.clear();
		System.out.println("清空链表之后 ,再次打印："+list.toString());
	}

}
