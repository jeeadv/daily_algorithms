//Complete Binary Tree Inserter
//https://leetcode.com/problems/complete-binary-tree-inserter/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {
    TreeNode root = null;
    LinkedList<TreeNode> q = new LinkedList<>();
    
    public CBTInserter(TreeNode root) {
        this.root = root;
        q.add(root);
    }
    
    public int insert(int v) {
        return levelOrderTraversal(v);
    }
    
    public int levelOrderTraversal(int v){
        while(!q.isEmpty()){
            TreeNode top = q.poll();

            if(top.left == null){
                top.left = new TreeNode(v);
                q.addFirst(top);
                return top.val;
            }
            if(top.right == null){
                top.right = new TreeNode(v);
                q.addFirst(top);
                return top.val;
            }

            q.add(top.left);
            q.add(top.right);
        }
        return 0;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
