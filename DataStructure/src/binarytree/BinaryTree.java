package binarytree;

import java.util.ArrayList;
import java.util.List;

//二叉链表树
public class BinaryTree<T> {
	class Node{
		T data;
		Node left;
		Node right;
		public Node(){};
		public Node(T data){
			this.data = data;
		}
		public Node(T data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	private Node root;
	public BinaryTree(){
		root = new Node();
	}
	public BinaryTree(T data){
		root = new Node(data,null,null);
	}
	//为指定节点添加子节点
	public Node addNode(Node parent,T data,boolean isLeft){
		if(parent == null){
			throw new RuntimeException("parent节点为null,无法添加子节点");
		}
		if(isLeft && parent.left!=null){
			throw new RuntimeException("parent已有左子节点,无法添加子节点");
		}
		if(!isLeft && parent.right!=null){
			throw new RuntimeException("parent已有右子节点,无法添加子节点");
		}
		Node newNode = new Node(data);
		if(isLeft){
			parent.left = newNode;
		}else{
			parent.right = newNode;
		}
		return newNode;
	}
	
	public boolean isEmpty(){
		return root.data == null;
	}
	//获取根节点
	public Node root(){
		if(isEmpty()){
			throw new RuntimeException("树为空");
		}
		return root;
	}
	//[重要]获取树的深度
	public int deep(){
		return deep(root);
	}
	//[重要]一个递归方法
	public int deep(Node node){
		if(node == null){
			return 0;
		}
		if(node.left == null || node.right == null){
			return 1;
		}else{
			int leftDeep =deep(node.left); 
			int rightDeep = deep(node.right);
			int max = leftDeep > rightDeep ? leftDeep : rightDeep;
			return max + 1;//这里为什么
		}
	}
	//[重要]先序遍历
	//中序遍历和后序遍历都是同理
	public void preIterator(){
		List<Node> list = new ArrayList<>();
		list = preIterator(root);
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i).data+" ");
		}
	}
	public List<Node> preIterator(Node node){
		List<Node> tmpList = new ArrayList<>();
		tmpList.add(node);
		//递归处理左子树
		if(node.left != null){
			tmpList.addAll(preIterator(node.left));
		}
		if(node.right != null){
			tmpList.addAll(preIterator(node.right));
		}
		return tmpList;
	}
	
	
	public static void main(String[] args) {
		BinaryTree<String> tree = new BinaryTree<>("根节点");
		BinaryTree.Node tn1 = tree.addNode(tree.root(), "第二层左节点", true);
		BinaryTree.Node tn2 = tree.addNode(tree.root(), "第二层右节点", false);
		BinaryTree.Node tn3 = tree.addNode(tn2, "第三层左节点", true);
		BinaryTree.Node tn4 = tree.addNode(tn2, "第三层右节点", false);
		BinaryTree.Node tn5 = tree.addNode(tn3, "第四层左节点", true);
		System.out.println("tn2的左子节点："+tn2.left.data);
		System.out.println("tn2的右子节点："+tn2.right.data);
		System.out.println("tn3的左子节点: "+tn3.left.data);
		System.out.println("深度:"+tree.deep());

	}

}