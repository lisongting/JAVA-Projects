package nowcode;

import java.util.Stack;

public class Main3 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	public boolean isSubTree(TreeNode node1,TreeNode node2){
		if(node2==null){
			return true;
		}
		if(node1==null){
			return false;
		}
		if(node1.val == node2.val){
			return isSubTree(node1.left,node2.left)
					&&isSubTree(node1.right,node2.right);
		}else{
			return false;
		}
		
	}
	 public boolean HasSubtree(TreeNode root1,TreeNode root2) {
	        if(root1 == null ||root2 == null){
	        	return false;
	        }
	        return isSubTree(root1,root2)||
	        		isSubTree(root1.left,root2)||
	        		isSubTree(root1.right,root2);
	        
	    }
	
	public static void main(String[] args) {
		
		
		//System.out.println(Integer.toBinaryString(-1));

	}

}
