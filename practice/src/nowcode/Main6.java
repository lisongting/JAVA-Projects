package nowcode;

import java.util.ArrayList;
import java.util.List;
/**
 * 将二叉搜索树按照中序遍历的顺序转换为双向链表
 * @author Administrator
 *
 */
public class Main6 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	TreeNode head = null;
	TreeNode realHead = null;
	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree==null){
			return null;
		}
		if(pRootOfTree.left==null&&pRootOfTree.right==null){
			return pRootOfTree;
		}
		//将左子树构造成双链表，并返回头节点
		TreeNode left = Convert(pRootOfTree.left);
		TreeNode p = left;
		//定位到左子树双链表的最后一个节点
		while(p!=null && p.right!=null){
			p = p.right;
		}
		//如果左子树链表不为空的话，将当前root追加到左子树链表
		if(left!=null){
			p.right = pRootOfTree;
			pRootOfTree.left = p;
		}
		//将右子树构造成双链表，然后追加到root之后
		TreeNode right = Convert(pRootOfTree.right);
		
		if(right!=null){
			right.left = pRootOfTree;
			pRootOfTree.right = right;
		}
		
		return left!=null?left:pRootOfTree;
    }
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("test");
		ArrayList<StringBuilder> list = new ArrayList<>();
		list.add(sb);
		System.out.println(list.get(0).toString());
		sb.append("plus");
		System.out.println(list.get(0).toString());
		System.out.println(sb.equals(list.get(0)));
	}

}
