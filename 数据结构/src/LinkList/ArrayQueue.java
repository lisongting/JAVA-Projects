package LinkList;
/**
 * 队列的数组实现
 * 16.8.3
 * @author LST
 *
 */
public class ArrayQueue {
	private int first,last,size;
	private Object[] storage;
	public ArrayQueue(int n){
		size = n;
		storage = new Object[size];
		first = last = -1;
	}
	
	public boolean isFull(){
		return first ==0&&last ==size-1||first ==last+1;
	}
	public boolean isEmpty(){
		return first==-1;
	}
	public void enqueue(Object el){
		if(last==size-1||last==-1){
			storage[0] =el;
			last = 0;
			if(first==-1)
				first = 0;
		}
		else storage[++last] = el;
	}
	public Object dequeue(){
		Object tmp = storage[first];
		if(first==last)
			last = first = -1;
		else if(first == size-1){
			first = 0;
		}
		else first++;
		return tmp;
	}
	public void printAll(){
		for(int i=0;i<size;i++)
			System.out.println(storage[i]+"");
	}
}
