package nowcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * @author Administrator
 *
 */

public class Main13 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	//为指定节点添加子节点
	public TreeNode addNode(TreeNode parent,int data,boolean isLeft){
		if(parent == null){
			throw new RuntimeException("parent节点为null,无法添加子节点");
		}
		if(isLeft && parent.left!=null){
			throw new RuntimeException("parent已有左子节点,无法添加子节点");
		}
		if(!isLeft && parent.right!=null){
			throw new RuntimeException("parent已有右子节点,无法添加子节点");
		}
		TreeNode newNode = new TreeNode(data);
		if(isLeft){
			parent.left = newNode;
		}else{
			parent.right = newNode;
		}
		return newNode;
	}
	private int index=-1;
    String Serialize(TreeNode root) {
	  StringBuilder sb = new StringBuilder();
      if(root==null){
        	sb.append("#,");
        	return sb.toString();
      }
      sb.append(root.val+",");
      sb.append(Serialize(root.left));
      sb.append(Serialize(root.right));
      return sb.toString();
    }
  
    TreeNode Deserialize(String str) {
       int len = str.length();
       index++;
       String[] strArr = str.split(",");
       TreeNode node = null;
       if(!strArr[index].equals("#")){
    	   node = new TreeNode(Integer.valueOf(strArr[index]));
    	   node.left = Deserialize(str);
    	   node.right = Deserialize(str);
       }
       return node;
    }
	public static void main(String[] args) {
		Main13 m = new Main13();
		Main13.TreeNode tree = m.new TreeNode(3); 
		Main13.TreeNode tn1 = m.addNode(tree, 4, true);
		Main13.TreeNode tn2 = m.addNode(tree,9, false);
		Main13.TreeNode tn3 = m.addNode(tn2, 7, true);
		Main13.TreeNode tn4 = m.addNode(tn2,8, false);
		Main13.TreeNode tn5 = m.addNode(tn3,5, true);
		String str = null;
		str = m.Serialize(tree);
		System.out.println(str);
		TreeNode t = m.Deserialize(str);
		System.out.println(t.val);
	}

}