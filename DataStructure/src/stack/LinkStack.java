package stack;
//链式栈
public class LinkStack<T> {
	private class Node{
		private T data;
		private Node next;//该next是往栈底指
		public Node(){};
		public Node(T element){
			data = element;
		}
		public Node(T data,Node next){
			this.data = data;
			this.next = next;
		}
	}
	//栈顶元素
	private Node top;
	private int size = 0;
	public LinkStack(){
		top = null;
	};
	public LinkStack(T element){
		top = new Node(element,null);
		size ++;
	}
	public int length(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	//[重要]
	public void push(T element){
		Node newNode = new Node(element,top);
		top = newNode;
		size ++;
	}
	public T pop(){
		Node oldTop = top;
		top = null;
		top = oldTop.next;
		size --;
		return oldTop.data;
	}
	public T peek(){
		return top.data;
	}
	public void clear(){
		Node current = top;
		for(int i=0;i<size && current!=null;i++){
			Node nextNode = current.next;
			current = null;
			current = nextNode;
		}
		size = 0;
	}
	public String toString(){
		if(size == 0){
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		Node current = top;
		for(int i=0;i<size && current!=null;i++){
			sb.append(current.data+" ");
			current = current.next;
		}
		sb.append(']');
		return sb.toString();
	}
	public static void main(String[] args) {
		LinkStack<String> stack = new LinkStack<>();
		stack.push("aaaa");
		stack.push("bbbb");
		System.out.println("此时栈顶元素是："+stack.peek());
		stack.push("cccc");
		System.out.println("自顶向下栈内的元素为："+stack.toString());
		stack.pop();
		System.out.println("出栈后栈内的元素为："+stack.toString());
		stack.push("eeee");
		stack.push("tttt");
		System.out.println("自顶向下栈内的元素为："+stack.toString());
		stack.clear();
		System.out.println("清空后栈内的元素为："+stack.toString());
	}

}
