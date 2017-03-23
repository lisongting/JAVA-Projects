package nowcode;
/**
 * 按照中序遍历的顺序，返回二叉树中一个指定节点的后一个节点
 * @author Administrator
 *
 */
public class Main11 {
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
    	
    	if(pNode == null){
    		return null;
    	}
    	//如果是叶子节点
    	if(pNode.left==null && pNode.right==null){
    		TreeLinkNode parent = pNode.next;
    		if(parent==null){
    			return null;
    		}
    		if(parent.left == pNode){
    			return parent;
    		}
    		if(parent.next!=null){
    			TreeLinkNode grandP = parent.next;;
    			
    			while(grandP!=null){
    				if(parent==grandP.left){
    					return grandP;
    				}
    				if(parent==grandP.right){
    					parent = grandP;
    					grandP = parent.next;
    				}
    			}
    			return null;
    		}
    	}
    	if(pNode.right!=null){
    		TreeLinkNode right = pNode.right;
    		if(right.left!=null){
    			TreeLinkNode cur = right.left;
    			while(cur.left!=null){
    				cur = cur.left;
    			}
    			return cur;
    		}else{
    			return right;
    		}
    	}else{
    		if(pNode.next!=null){
    			return pNode.next;
    		}else{//父节点为null，说明是root节点
    			if(pNode.right!=null){
    				TreeLinkNode right = pNode.right;
    				if(right.left!=null){
    					TreeLinkNode cur = right.left;
    					while(cur.left!=null){
    						cur = cur.left;
    					}
    					return cur;
    				}else{
    					return right;
    				}
    			}
    		}
    	}
    	return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
