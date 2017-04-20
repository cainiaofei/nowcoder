package com.nowcoder;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class CountNodes {
    public int count(TreeNode root) {
    	if(root==null){
    		return 0;
    	}
    	else{
    		int leftDeepth = getDeepth(root.left);
    		int rightDeepth = getDeepth(root.right);
    		if(leftDeepth==rightDeepth){
    			return 1 + (int)Math.pow(2, leftDeepth) - 1 + count(root.right);
    		}
    		else{
    			return 1 + (int)Math.pow(2, rightDeepth) - 1 + count(root.left);
    		}
    	}
    }

	private int getDeepth(TreeNode tn) {
		int deepth = 0;
		while(tn!=null){
			tn = tn.left;
			deepth++;
		}
		return deepth;
	}
}