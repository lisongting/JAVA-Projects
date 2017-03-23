package nowcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * “之”字型遍历二叉树
 * @author Administrator
 *
 */
public class Main12 {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> layers = new ArrayList<>();
    	Deque<TreeNode> queue = new LinkedList<>();
    	queue.add(pRoot);
    	if(pRoot == null){
    		return layers;
    	}
    	int depth = 0;
    	while(!queue.isEmpty()){
    		depth++;
    		ArrayList<Integer> layer = new ArrayList<>();
    		int cur =0,size = queue.size();
    		if(depth%2==0){//偶数层,倒数添加
    			Iterator<TreeNode> it = queue.descendingIterator();
    			while(it.hasNext()){
    				layer.add(it.next().val);
    			}
    		}else{//奇数层
    			Iterator <TreeNode> it = queue.iterator();
    			while(it.hasNext()){
    				layer.add(it.next().val);
    			}
    		}
    		while(cur < size){
    			TreeNode node = queue.poll();
    			if(node.left!=null){
    				queue.offer(node.left);
    			}
    			if(node.right!=null){
    				queue.offer(node.right);
    			}
    			cur ++;
    		}
    		layers.add(layer);
    	}
    	return layers;
    }
   
	public static void main(String[] args) {
		
	}
}
