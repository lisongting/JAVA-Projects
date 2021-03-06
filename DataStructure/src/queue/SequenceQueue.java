package queue;
//顺序队列
//缺陷：出队列时，当front移动到和rear重叠时候，会出现“假满”的线象，因此要使用循环队列
public class SequenceQueue<T> {
	private int DEFAULT_SIZE = 10;
	private int capacity;
	private Object[] elementData;
	//保存顺序队列中元素的当前个数
	private int front = 0;
	private int rear = 0;
	public SequenceQueue(){
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	public SequenceQueue(T element){
		this();
		elementData = new Object[capacity];
		rear++;
	}
	public SequenceQueue(T element, int initSize){
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		rear ++;
	}
	public int length(){
		return rear - front;
	}
	public boolean isEmpty(){
		return rear==front;
	} 
	public void add(T element){
		if(rear > capacity-1){
			throw new IndexOutOfBoundsException("队列已满");
		}
		elementData[rear] = element;
		rear++;
	}
	//移除队列头部的元素(进行出队列操作)
	public T remove(){
		if(isEmpty()){
			throw new IndexOutOfBoundsException("空队列异常");
		}
		T oldValue = (T)elementData[front];
		elementData[front] = null;
		front++;
		return oldValue;
	}
	//返回队列头部元素，不删除
	public T element(){
		if(isEmpty()){
			throw new IndexOutOfBoundsException("空队列异常");
		}
		return (T)elementData[front];
	}
	public void clear(){
		for(int i=0;i<rear-front ;i++){
			elementData[i] = null;
		}
		front = rear = 0;
	}
	public String toString(){
		if(isEmpty()){
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		for(int i=0;i<=rear-front;i++){
			if(elementData[i]!=null){
				sb.append(elementData[i]+" ");
			}
		}
		sb.append(']');
		return sb.toString();
	}
	public static void main(String[] args) {
		SequenceQueue<String> queue = new SequenceQueue<>();
		queue.add("aaaa");
		queue.add("bbbb");
		queue.add("cccc");
		queue.add("dddd");
		System.out.println(queue);
		System.out.println("排在队首的元素是："+queue.element());
		queue.remove();
		System.out.println("出队列之后："+queue);
		queue.add("wwww");
		System.out.println("插入wwww之后："+queue);
		queue.clear();
		System.out.println("清空队列后："+queue);
	}
	
}
