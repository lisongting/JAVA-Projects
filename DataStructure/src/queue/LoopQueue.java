package queue;
//循环队列
public class LoopQueue<T> {
	private int DEFAULT_SIZE = 10;
	private int capacity;
	private Object[] elementData;
	//保存顺序队列中元素的当前个数
	private int front = 0;
	private int rear = 0;
	public LoopQueue(){
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	public LoopQueue(T element){
		this();
		elementData = new Object[capacity];
		rear++;
	}
	public LoopQueue(T element, int initSize){
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		rear ++;
	}
	public void add(T element){
		if(rear == front && elementData[front]!=null){
			throw new IndexOutOfBoundsException("队列已满");
		}
		elementData[rear] = element;
		rear++;
		//如果rear已经到最大了，则掉头
		rear = rear==capacity? 0:rear;
	}
	//出队列
	public T remove(){
		if(isEmpty()){
			throw new IndexOutOfBoundsException("队列已满");
		}
		T oldValue = (T)elementData[front];
		elementData[front] = null;
		front++;
		//如果front到头则掉头
		front = front==capacity? 0:front;
		return oldValue;
	}
	//获取队列首部元素，不删除
	public T element(){
		if(isEmpty()){
			throw new IndexOutOfBoundsException("队列已满");
		}
		return (T)elementData[front];
	}
	public int length(){
		if(isEmpty()){
			return 0;
		}
		return rear > front ? rear - front :capacity-(front-rear);
	}
	public boolean isEmpty(){
		return rear == front && elementData[rear]==null;
	}
	public void clear(){
		for(int i=0;i<capacity ;i++){
			elementData[i] = null;
		}
		front = rear = 0;
	}
	public String toString(){
		if(isEmpty()){
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");		
		//如果front<rear，那么有效元素就是front到rear之间的元素
		if(front<rear){
			for(int i=front;i<rear;i++){
				sb.append(elementData[i]+" ");
			}
		}else{
			//如果front>=rear，那么有效元素为front~capacity和0到rear之间的
			for(int i=front;i<capacity;i++){
				sb.append(elementData[i]+" ");
			}
			for(int j=0;j<rear;j++){
				sb.append(elementData[j]+" ");				
			}
		}
		sb.append(']');
		return sb.toString();
	}
	public static void main(String[] args) {
		LoopQueue<String> queue = new LoopQueue<>();
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
