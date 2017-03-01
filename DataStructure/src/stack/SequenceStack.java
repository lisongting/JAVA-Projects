package stack;

import java.util.Arrays;

//顺序栈
public class SequenceStack<T> {
	private int DEFAULT_SIZE = 10;
	private int capacity;
	//程序每次增加的数组长度
	private int capacityIncrement = 0;
	private Object[] elementData;
	private int size = 0;
	public SequenceStack(){
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	};
	//以第一个初始元素来构造顺序栈
	public SequenceStack(T element){
		this();
		elementData[0] = element;
		size ++;
	}
	public SequenceStack(T element,int initSize){
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		size ++;
	}
	//以指定数组长度以及增量来创建顺序栈
	public SequenceStack(T element,int initSize, int increment){
		this.capacity = initSize;
		this.capacityIncrement = increment;
		elementData = new Object[capacity];
		elementData[0] = element;
		size++;
	}
	public int length(){
		return size;
	}
	public boolean isEmpty(){
		return 0 == size;
	}
	//[重要]入栈
	public void push(T element){
		ensureCapacity(size+1);
		elementData[size] = element;
		size++;
	}
	//确保容量
	public void ensureCapacity(int needCapacity){
		if(needCapacity > capacity){
				if(capacityIncrement > 0){
					while(needCapacity > capacity){
						capacity += capacityIncrement;
					}
				}else{
					while(needCapacity > capacity){
						capacity *= 2;
					}
				}
		}
		elementData = Arrays.copyOf(elementData, capacity);
	}
	//入栈
	public T pop(){
		T tmp = (T) elementData[size-1];
		elementData[size - 1] =null;
		size--;
		return tmp;
	}
	//返回栈顶元素，但不删除
	public T peek(){
		return (T) elementData[size-1];
	}
	public void clear(){
		for(int i=0;i<size;i++){
			elementData[i] = null;
		}
		size = 0;
	}
	public String toString(){
		if(size == 0){
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		for(int i=0;i<size;i++){
			sb.append(elementData[i]+" "); 
		}
		sb.append(']');
		return sb.toString();
	}
	public static void main(String[] args){
		SequenceStack<String> stack = new SequenceStack<>();
		stack.push("aaaa");
		stack.push("bbbb");
		System.out.println("此时栈顶元素是："+stack.peek());
		stack.push("cccc");
		System.out.println("自底向上栈内的元素为："+stack.toString());
		stack.pop();
		System.out.println("出栈后栈内的元素为："+stack.toString());
		stack.push("eeee");
		stack.push("tttt");
		System.out.println("自底向上栈内的元素为："+stack.toString());
		stack.clear();
		System.out.println("清空后栈内的元素为："+stack.toString());
	}
}
