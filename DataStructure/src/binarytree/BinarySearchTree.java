package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


//二叉排序树，也叫二叉搜索树（存放整数，也可存放其他对象，
//只要能进行某种性质上的大小比较）
//根据整数大小来存放，比父节点小的总是为父节点左边
//比父节点大的总是为父节点的右边节点
public class BinarySearchTree {
	private class Node{
		int data;
		Node left;
		Node right;
		public Node(){};
		public Node(int element){
			this.data = element;
			left = right = null;
		}
		public Node(int element,Node left,Node right){
			this(element);
			this.left = left;
			this.right = right;
		}
	}
	private Node root;
	public BinarySearchTree(){
		root = null;
	};
	//以根节点创建二叉搜索树
	public BinarySearchTree(int element){
		root = new Node(element);
	}
	//[重要]插入操作
	public void insert(int element){
		if(root == null){
			root = new Node(element);
		}else{
			Node current = root;
			Node parent = null;
			Node newNode = new Node(element,null,null);
			//该变量标记新节点在左还是在右
			boolean isLeft = false;
			//寻找一个合适的位置作为插入点
			while(current != null){
				parent = current;
				//如果新插入的节点大于当前的节点
				if(element > current.data){
					//则把当前节点右移
					current = current.right;
					isLeft = false;
				}else{
					//如果新节点小于等于当前节点，则把当前节点左移
					current = current.left;
					isLeft = true;
				}
			}
			//如果是在左，则新节点放到最后一次parent的左边
			if(isLeft){
				parent.left = newNode;
			}else{
				parent.right = newNode;
			}
		}
	}
	//[重要]删除操作
	public void remove(int element){
		Node delNode = findNode(element);//先找到要删除的节点
		if(delNode == null){
			return;
		}
		//然后进行树结构调整操作
		//如果要删除的节点没有左右子节点，即它本身就是叶子节点
		if(delNode.left == null && delNode.right==null){
			//找到父节点
			Node parent = findParent(delNode);
			//如果要删除的节点是左子节点
			if(delNode == parent.left){
				parent.left = null;
				//这里手动将delNode设为null,如果不置为null起始也没关系
				//反正遍历树已经访问不到它了（估计它应该会被GC回收吧）
				delNode = null;
			}
			if(delNode == parent.right){
				parent.right = null;
				delNode = null;
			}
		}
		//如果要删除的节点只有左子节点
		else if(delNode.left!=null && delNode.right==null){
			if(root == delNode){
				root = root.left;
			}else{
				Node parent = findParent(delNode);
				if(delNode == parent.left){
					parent.left = delNode.left;
				}else if(delNode == parent.right){
					parent.right = delNode.left;
				}
			}
			
		}
		//如果要删除的节点只有右子节点
		else if(delNode.left==null && delNode.right!=null){
			if(delNode == root){
				root = root.right;
			}else{
				Node parent = findParent(delNode);
				if(delNode == parent.left){
					parent.left = delNode.right;
				}else if(delNode == parent.right){
					parent.right = delNode.right;
				}
			}
		}
		//如果要删除的节点有左右子节点
		else{
			//首先在其左子树中找到最大的那个值
			Node leftMaxNode = delNode.left;
			while(leftMaxNode.right!=null ){
				leftMaxNode = leftMaxNode.right;
			}
			//找到leftMaxNode的父节点
			Node maxParent = findParent(leftMaxNode);
			//找到delNode的父节点
			Node delNodeParent = findParent(delNode);
			//这种情况容易忽略，如果leftMaxNode的父节点刚好是要删除的节点
			if(delNode == maxParent){
				if(delNodeParent.left == delNode){
					delNodeParent.left = leftMaxNode;
				}else{
					delNodeParent.right = leftMaxNode;
				}
				leftMaxNode.right = delNode.right;
				delNode = null;
			}else{
				//由于leftMaxNode不可能是parent的左孩子,
				//只可能是parent的右孩子
				//而leftMaxNode一定没有右孩子
				//所以将parentde右子节点指向leftMaxNode的左边(可能为null，也没关系)
				//parent.right = null;
				maxParent.right = leftMaxNode.left;
				leftMaxNode.left = delNode.left;
				leftMaxNode.right = delNode.right;
				
				//下面还要在delNodeParent中对delNode的位置进行替换
				//（孩子丢了,给老人家一个交代）
				//如果delNode本来就是root节点
				if(delNodeParent == null){
					root = leftMaxNode;
				}//如果delNode不是root节点
				else{
					if(delNode == delNodeParent.left){
						//给老人家一个新儿子
						delNodeParent.left = leftMaxNode;
					}else{
						delNodeParent.right = leftMaxNode;
					}
				}
				delNode.left = null;
				delNode.right = null;
				delNode = null;
			}
		}
	}
	//根据数字查找节点
	public Node findNode(int element){
		if(root == null){
			return null;
		}
		Node p = root;
		while(p!=null){
			if(element > p.data){
				p = p.right;
			}else if(element < p.data){
				p = p.left;
			}else{
				return p;
			}
		}
		return null;
	}
	//找到一个节点的父节点
	public Node findParent(Node child){
		if(child == null || child == root){
			return null;
		}
		Node current = root;
		Node prev = current;
		while(current!= null){
			if(current.data < child.data){
				prev = current;
				current = current.right;
			}else if(current.data > child.data){
				prev = current;
				current = current.left;
			}else{
				
				return prev;
			}
		}
		return null;
	}
	//[重要]中序遍历:先遍历左子节点
	public void middleVisit(){
		List<Node> list = new ArrayList<>();
		list = middleVisit(root);
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i).data+" ");
		}
	}
	public List<Node> middleVisit(Node node){
		List<Node> tmpList = new ArrayList<>();
		//递归处理左子树
		if(node.left != null){
			tmpList.addAll(middleVisit(node.left));
		}
		tmpList.add(node);
		if(node.right != null){
			tmpList.addAll(middleVisit(node.right));
		}
		return tmpList;
	}
	//[重要]广度优先遍历
		public void breadthFirst(){
			Queue<Node> queue = new ArrayDeque<Node>();
			List<Node> list = new ArrayList<>();
			if(root != null){
				queue.offer(root);
			}
			while(!queue.isEmpty()){
				//将根元素加入队列
				list.add(queue.peek());
				//从队列头部取出元素
				Node p = queue.poll();
				//如果左子节点不为空，则加入到队列
				if(p.left!=null){
					queue.offer(p.left);
				}
				if(p.right!=null){
					queue.offer(p.right);
				}
			}
			//输出所有节点信息
			for(int i=0;i<list.size();i++){
				System.out.print(list.get(i).data+" ");
			}
			
		}
	/**
	 * 初始化建立起来的树为
	 *           6
	 *         /    \
	 *        2      13
	 *         \    /   \
	 *          5  8     25
	 *          /   \    / \
	 *         3    10  20  36
	 */
	public static void main(String[] args) {
		BinarySearchTree BSTree = new BinarySearchTree();
		//注意：这个插入顺序重要，插入顺序不同，即使元素相同
		//也不一定能得到相同的树结构
		BSTree.insert(6);
		BSTree.insert(13);
		BSTree.insert(2);
		BSTree.insert(5);
		BSTree.insert(25);
		BSTree.insert(3);
		BSTree.insert(36);
		BSTree.insert(8);
		BSTree.insert(10);
		BSTree.insert(20);
		//中序遍历输出所有值
		System.out.println("中序遍历输出所有节点：");
		BSTree.middleVisit();System.out.println();
		System.out.println("广度优先遍历为：");
		BSTree.breadthFirst();System.out.println();
		System.out.println("移除了13节点后：");
		BSTree.remove(13);
		BSTree.middleVisit();System.out.println();
		System.out.println("广度优先遍历为：");
		BSTree.breadthFirst();
	}

}
