import java.util.LinkedList;
import java.util.List;

/**
 * 2017/4/19 13:39 297 after study the course nowcoder 
 * this oj exist flaw when there are spaces before "public class..." it will cause compile error,
 * cant find symbol Codec
 * */

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

 public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
    	if(root==null){
    		sb.append("#$");
    	}
    	else{
    		sb.append(root.val);
    		sb.append("$");
    		preOrder(root.left,sb);
    		preOrder(root.right,sb);
    	}
	}

	// Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("\\$");
        List<String> list = new LinkedList<String>();
        for(String str:strs){
        	list.add(str);
        }
        return buildTree(list);
    }

	private TreeNode buildTree(List<String> list) {
		if(list.isEmpty()){
			return null;
		}
		else{
			String curValue = list.remove(0);
			if(curValue.equals("#")){
				return null;
			}
			else{
				TreeNode root = new TreeNode(Integer.valueOf(curValue));
				root.left = buildTree(list);
				root.right = buildTree(list);
				return root;
			}
		}
	}
	
//	public static void main(String[] args){
//		Codec codec = new Codec();
//		TreeNode tn = new TreeNode(1);
//		tn.left = new TreeNode(2);
//		tn.right = new TreeNode(3);
//		codec.deserialize(codec.serialize(tn));
//	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));