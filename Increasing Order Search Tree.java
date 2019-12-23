//Increasing Order Search Tree
//https://leetcode.com/problems/increasing-order-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode start = null;
    TreeNode prev = null;
    public TreeNode increasingBST(TreeNode root) {
        start = null;
        prev = null;
        
        inorder(root);
        return start;
    }
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        
        if(start == null){
            start = root;
        }
        
        root.left = null;
        if(prev != null) {
            prev.right = root; 
        }
        prev = root;
        
        inorder(root.right);
    }
}
