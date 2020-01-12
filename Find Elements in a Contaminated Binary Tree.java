//Find Elements in a Contaminated Binary Tree
//https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    HashSet<Integer> set = new HashSet<>();
    
    public FindElements(TreeNode root) {
        root = fun(root, 0);
    }
    
    public TreeNode fun(TreeNode root, int val){
        if(root == null){
            return null;
        }
        root.val = val;
        set.add(val);
        root.left = fun(root.left, val*2 + 1);
        root.right = fun(root.right, val*2 + 2);
        return root;
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
