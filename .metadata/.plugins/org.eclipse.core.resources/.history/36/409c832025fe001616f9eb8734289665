package list;

import java.util.Arrays;

public class SequenceList<T> {
	private int DEFAULT_SIZE = 16;
	private int capacity;
	private Object[] elementData;
	private int size = 0;
	public SequenceList(){
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	public SequenceList(T element){
		this();
		elementData[0] = element;
		size ++;
	}
	//初始化第一个元素，以指定大小创建List
	public SequenceList(T element,int initSize){
		capacity = 1;
		//把capacity设为大于initSize的数，并且为2的n次方
		while(capacity < initSize){
			capacity = capacity * 2;
		}
		elementData = new Object[capacity];
		elementData[0] = element;
		size++;
	}
	public int length(){
		return size;
	}
	public T get(int index){
		if(index<0||index>size-1){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		return (T) elementData[index];
	}
	public int locate(T element){
		for(int i=0;i<size;i++){
			if(elementData[i].equals(element)){
				return i;
			}
		}
		return -1;
	}
	//向指定位置插入元素
	public void insert(int index,T element){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		
		ensureCapacity(size+1);
		size ++;
		//把index位置以后的元素都向后移
		for(int i=size-1;i>index;i--){
			elementData[i] = elementData[i-1];
		}
		elementData[index] = element;
	}
	
	//删除指定下标位置的元素
	public void delete(int index){
		if(index < 0 ||index> size-1){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		//把从指定位置的元素都往前移动
		for(int i = index;i<size-1;i++){
			elementData[i] = elementData[i+1];
		}
		elementData[size-1]=null;
		size --;
	}
	//往末尾插入一个元素
	public void add(T element){
		insert(size,element);
	}
	public void remove(){
		delete(size-1);
	}
	public boolean isEmpty(){
		return size==0;
	}
	public void clear(){
		for(int i=0;i<size;i++){
			elementData[i] = null;
		}
		size = 0;
	}
	public String toString(){
		if(size==0){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[");
			for(int i=0;i<size;i++){
				sb.append(elementData[i].toString()+"  ");
			}
			sb.append(']');
			return sb.toString();
		}
	}
	//扩充底层数组的长度以确保数组容量够用
	public void ensureCapacity(int needCapacity){
		while(needCapacity > capacity){
			capacity *= 2;
		}
		elementData = Arrays.copyOf(elementData, capacity);
	}
	public static void main(String[] args){
		SequenceList<String> list = new SequenceList<>();
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		System.out.println(list.get(2));
		System.out.println(list.toString());
		list.insert(1, "tttt");
		System.out.println(list.toString());
		list.delete(0);
		System.out.println(list.toString());
		System.out.println("tttt在线性表中的位置是:"+list.locate("tttt"));
	}
}
