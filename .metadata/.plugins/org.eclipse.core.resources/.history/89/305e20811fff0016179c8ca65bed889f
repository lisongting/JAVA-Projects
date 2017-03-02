package 二叉树;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉搜索树
 * @author LST
 *
 */
public class IntBST {
	protected IntBSTNode root;
	public IntBST(){
		root = null;
	}
	
	protected void visit(IntBSTNode p){
		System.out.println(p.key+" ");
	}
	
	//插入节点
	public void insert(int el){
		IntBSTNode p = root,prev = null;
		while(p!=null){//找到一个合适的位置存放节点
			prev = p;//用prev来标记合适的位置
			if(p.key<el)
				p = p.right;
			else
				p = p.left;//小于或等于节点的值都放在左边
		}
		if(root==null)
			root = new IntBSTNode(el);//如果是空树
		else if(prev.key<el)
			prev.right = new IntBSTNode(el);
		else 
			prev.left = new IntBSTNode(el);
			
	}
	
	//查找节点
	public IntBSTNode search(IntBSTNode proot,int e){
		while(proot!=null){
			if(e == proot.key)
				return proot;
			if(e<proot.key)
				return search(proot.left,e);
			else if(e>proot.key)
				return search(proot.right,e);
		}
		return null;
	}
	
	//广度优先遍历
	public void breadthFirst(){
		IntBSTNode p = root;
		ArrayDeque queue = new ArrayDeque();
		if(p!=null){
			queue.offer(p);//进队列
			while(!queue.isEmpty()){
				p = (IntBSTNode) queue.poll();//出队列
				visit(p);
				if(p.left!=null){
					queue.offer(p.left);//把左右分别加入到队列中
				}
				if(p.right!=null){
					queue.offer(p.right);
				}
				
			}
		}
	}
	
	
	//深度优先遍历:先序遍历
	public void preorder(IntBSTNode p){
		if(p!=null){
			visit(p);
			preorder(p.left);
			preorder(p.right);
		}
	}
	//[重要]先序遍历的非递归实现??
	public void iterativePreorder(){
		IntBSTNode p = root;
		Stack travStack = new Stack();
		if(p!=null){
			travStack.push(p);
			while(travStack.isEmpty()){
				p = (IntBSTNode )travStack.pop();
				visit(p);
				if(p.right!=null)
					travStack.push(p.right);
				if(p.left!=null)
					travStack.push(p.left);//左节点后放入，以保证左节点比右节点先出栈
			}
		}
	}
	//深度优先遍历:中序遍历
	public void inorder(IntBSTNode p){
		if(p!=null){
			preorder(p.left);
			visit(p);
			preorder(p.right);
		}
	}
	//[重要]中序遍历的非递归实现???
	public void iterativeInorder(){
		IntBSTNode p = root;
		Stack travStack = new Stack();
		while(p!=null){//奇怪这里为什么要用while？
			while(p!=null){//沿着root向左下方向走，如果遇到节点有右孩子则把右孩子入栈。右孩子入栈之后再把本节点入栈
				if(p.right!=null)
					travStack.push(p.right);
				travStack.push(p);
				p = p.left;
			}
			p = (IntBSTNode )travStack.pop();//从栈顶取出元素，该元素一定是没有左孩子的
			while(!travStack.isEmpty() && p.right==null){
				visit(p);				//上上一步取出了没有左孩子的节点，如果该节点也没有右孩子，说明是叶子节点，直接访问
				p = (IntBSTNode)travStack.pop();//访问了之后再次出栈
			}
			visit(p);//访问这个节点，它没有左孩子但是有右孩子的节点
			if(!travStack.isEmpty())
				p = (IntBSTNode)travStack.pop();//再次出栈
			else
				p =null;
		}
	}
	//深度优先遍历:后序遍历
	public void postorder(IntBSTNode p){
		if(p!=null){
			preorder(p.left);
			preorder(p.right);
			visit(p);
		}
	}	
	//[重要]后序遍历的非递归实现??
	public void iterativePostorder(){
		IntBSTNode p = root,q=root;//定义两个都指向跟节点的引用,q用来标记已被p访问过的节点
		Stack travStack = new Stack();
		while(p!=null){
			for(;p.left!=null;p= p.left)
				travStack.push(p);//沿着root往左下放移动，把所有节点压入栈
			while(p!=null&&(p.right==null||p.right==q)){//在p不为空时，如果右孩子为空或者已被访问过，则直接访问该节点
				visit(p);
				q= p;//访问了p之后，用q来标记p的位置
				if(travStack.isEmpty())
					return;
				p = (IntBSTNode)travStack.pop();//p向右上角走
			}
			travStack.push(p);//从树的左下角，往根的方向走，把这些节点入栈，再去遍历这些子树的右半部分
			p = p.right;//p往右半部分走
		}
	}
	
	//###[重要] Morris中序遍历算法
	//这个算法先对二叉树进行结构转换，等到遍历的过程中再进行恢复
	public void MorrisInorder(){
		IntBSTNode p = root,tmp;
		while(p!=null){
			if(p.left ==null){//当整个二叉树被构建成右单向树时（有环路），向右下方移动，访问那些没有左孩子的节点，继续往下移动
				visit(p);		
				p = p.right;
			}
			else{//如果这棵二叉树还没有被构建成右单向树，则开始构建
				tmp = p.left;
				while(tmp.right!=null&&tmp.right!=p)
					tmp = tmp.right;//往左分支走，找到没有右孩子的那个“最右的”节点
				if(tmp.right==null){
					tmp.right = p;//把上面找到的节点作为连接受体，把p分支连接上去，然后p向左移动
					p = p.left;
				}
				else {//对构建好的右单向树进行遍历和形状恢复
					visit(p);
					tmp.right=null;
					p = p.right;
				}
			}
		}
	}
	
	//[重要]归并删除
	public void deleteByMerging(int el){
		IntBSTNode tmp,node,p= root,prev = null;
		while(p!=null&&p.key!=el){//找到el所在的节点
			prev = p;
			if(p.key<el)
				p = p.right;
			else 
				p = p.left;
		}
		node = p;
		if(p!=null&&p.key==el){
			if(node.right==null)
				node = node.right;
			else if(node.left == null)
				node = node.right;
			else{
				tmp = node.left;
				while(tmp.right!=null)
					tmp = tmp.right;
				tmp.right = node.right;
				node = node.left;
			}
			if(p==root)
				root  = node;
			else if(prev.left ==p)
				prev.left = node;
			else 
				prev.right = node;
		}
		else if (root!=null)
			System.out.println("目标节点不在树中");
		else
			System.out.println("树是空树");
	}
	
	//[重要]复制删除
	public void deleteByCopying(int el){
		IntBSTNode  node ,p=root,prev = null;
		while(p!=null&&p.key!=el){//在这个循环中找到要删除节点所在的位置
			prev = p;
			if(p.key<el)
				p = p.right;
			else
				p = p.left;
		}
		node = p;
		if(p!=null&&p.key==el){
			if(node.right==null)//如果该节点没有右孩子
				node = node.left;
			else if(node.left==null)//如果该节点没有左孩子
				node = node.right;
			else{//如果该节点有左右孩子
				IntBSTNode tmp = node.left;
				IntBSTNode previous = node;
				while(tmp.right!=null){//找到node左子树种最大的节点，也就是node左子树中最右的节点
					previous = tmp;
					tmp = tmp.right;
				}
				node.key =  tmp.key;//进行值替换
				if(previous ==node)//如果node节点左孩子的右子树为空
					previous.left = tmp.left;
				else
					previous.right=tmp.left;
				
			}
			if(p==root)
				root=node;
			else if(prev.left ==p)
				prev.left = node;
			else 
				prev.right = node;
		}
		else if(root!=null)
			System.out.println("元素"+el+"在该树中不存在");
		else
			System.out.println("这是一棵空树");
	}
}
