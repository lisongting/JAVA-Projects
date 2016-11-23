package ������;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * ����������
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
	
	//����ڵ�
	public void insert(int el){
		IntBSTNode p = root,prev = null;
		while(p!=null){//�ҵ�һ�����ʵ�λ�ô�Žڵ�
			prev = p;//��prev����Ǻ��ʵ�λ��
			if(p.key<el)
				p = p.right;
			else
				p = p.left;//С�ڻ���ڽڵ��ֵ���������
		}
		if(root==null)
			root = new IntBSTNode(el);//����ǿ���
		else if(prev.key<el)
			prev.right = new IntBSTNode(el);
		else 
			prev.left = new IntBSTNode(el);
			
	}
	
	//���ҽڵ�
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
	
	//������ȱ���
	public void breadthFirst(){
		IntBSTNode p = root;
		ArrayDeque queue = new ArrayDeque();
		if(p!=null){
			queue.offer(p);//������
			while(!queue.isEmpty()){
				p = (IntBSTNode) queue.poll();//������
				visit(p);
				if(p.left!=null){
					queue.offer(p.left);//�����ҷֱ���뵽������
				}
				if(p.right!=null){
					queue.offer(p.right);
				}
				
			}
		}
	}
	
	
	//������ȱ���:�������
	public void preorder(IntBSTNode p){
		if(p!=null){
			visit(p);
			preorder(p.left);
			preorder(p.right);
		}
	}
	//[��Ҫ]��������ķǵݹ�ʵ��??
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
					travStack.push(p.left);//��ڵ����룬�Ա�֤��ڵ���ҽڵ��ȳ�ջ
			}
		}
	}
	//������ȱ���:�������
	public void inorder(IntBSTNode p){
		if(p!=null){
			preorder(p.left);
			visit(p);
			preorder(p.right);
		}
	}
	//[��Ҫ]��������ķǵݹ�ʵ��???
	public void iterativeInorder(){
		IntBSTNode p = root;
		Stack travStack = new Stack();
		while(p!=null){//�������ΪʲôҪ��while��
			while(p!=null){//����root�����·����ߣ���������ڵ����Һ�������Һ�����ջ���Һ�����ջ֮���ٰѱ��ڵ���ջ
				if(p.right!=null)
					travStack.push(p.right);
				travStack.push(p);
				p = p.left;
			}
			p = (IntBSTNode )travStack.pop();//��ջ��ȡ��Ԫ�أ���Ԫ��һ����û�����ӵ�
			while(!travStack.isEmpty() && p.right==null){
				visit(p);				//����һ��ȡ����û�����ӵĽڵ㣬����ýڵ�Ҳû���Һ��ӣ�˵����Ҷ�ӽڵ㣬ֱ�ӷ���
				p = (IntBSTNode)travStack.pop();//������֮���ٴγ�ջ
			}
			visit(p);//��������ڵ㣬��û�����ӵ������Һ��ӵĽڵ�
			if(!travStack.isEmpty())
				p = (IntBSTNode)travStack.pop();//�ٴγ�ջ
			else
				p =null;
		}
	}
	//������ȱ���:�������
	public void postorder(IntBSTNode p){
		if(p!=null){
			preorder(p.left);
			preorder(p.right);
			visit(p);
		}
	}	
	//[��Ҫ]��������ķǵݹ�ʵ��??
	public void iterativePostorder(){
		IntBSTNode p = root,q=root;//����������ָ����ڵ������,q��������ѱ�p���ʹ��Ľڵ�
		Stack travStack = new Stack();
		while(p!=null){
			for(;p.left!=null;p= p.left)
				travStack.push(p);//����root�����·��ƶ��������нڵ�ѹ��ջ
			while(p!=null&&(p.right==null||p.right==q)){//��p��Ϊ��ʱ������Һ���Ϊ�ջ����ѱ����ʹ�����ֱ�ӷ��ʸýڵ�
				visit(p);
				q= p;//������p֮����q�����p��λ��
				if(travStack.isEmpty())
					return;
				p = (IntBSTNode)travStack.pop();//p�����Ͻ���
			}
			travStack.push(p);//���������½ǣ������ķ����ߣ�����Щ�ڵ���ջ����ȥ������Щ�������Ұ벿��
			p = p.right;//p���Ұ벿����
		}
	}
	
	//###[��Ҫ] Morris��������㷨
	//����㷨�ȶԶ��������нṹת�����ȵ������Ĺ������ٽ��лָ�
	public void MorrisInorder(){
		IntBSTNode p = root,tmp;
		while(p!=null){
			if(p.left ==null){//���������������������ҵ�����ʱ���л�·���������·��ƶ���������Щû�����ӵĽڵ㣬���������ƶ�
				visit(p);		
				p = p.right;
			}
			else{//�����ö�������û�б��������ҵ���������ʼ����
				tmp = p.left;
				while(tmp.right!=null&&tmp.right!=p)
					tmp = tmp.right;//�����֧�ߣ��ҵ�û���Һ��ӵ��Ǹ������ҵġ��ڵ�
				if(tmp.right==null){
					tmp.right = p;//�������ҵ��Ľڵ���Ϊ�������壬��p��֧������ȥ��Ȼ��p�����ƶ�
					p = p.left;
				}
				else {//�Թ����õ��ҵ��������б�������״�ָ�
					visit(p);
					tmp.right=null;
					p = p.right;
				}
			}
		}
	}
	
	//[��Ҫ]�鲢ɾ��
	public void deleteByMerging(int el){
		IntBSTNode tmp,node,p= root,prev = null;
		while(p!=null&&p.key!=el){//�ҵ�el���ڵĽڵ�
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
			System.out.println("Ŀ��ڵ㲻������");
		else
			System.out.println("���ǿ���");
	}
	
	//[��Ҫ]����ɾ��
	public void deleteByCopying(int el){
		IntBSTNode  node ,p=root,prev = null;
		while(p!=null&&p.key!=el){//�����ѭ�����ҵ�Ҫɾ���ڵ����ڵ�λ��
			prev = p;
			if(p.key<el)
				p = p.right;
			else
				p = p.left;
		}
		node = p;
		if(p!=null&&p.key==el){
			if(node.right==null)//����ýڵ�û���Һ���
				node = node.left;
			else if(node.left==null)//����ýڵ�û������
				node = node.right;
			else{//����ýڵ������Һ���
				IntBSTNode tmp = node.left;
				IntBSTNode previous = node;
				while(tmp.right!=null){//�ҵ�node�����������Ľڵ㣬Ҳ����node�����������ҵĽڵ�
					previous = tmp;
					tmp = tmp.right;
				}
				node.key =  tmp.key;//����ֵ�滻
				if(previous ==node)//���node�ڵ����ӵ�������Ϊ��
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
			System.out.println("Ԫ��"+el+"�ڸ����в�����");
		else
			System.out.println("����һ�ÿ���");
	}
}
