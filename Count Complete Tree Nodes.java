//Count Complete Tree Nodes
//https://leetcode.com/problems/count-complete-tree-nodes/

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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int ll = lHeight(root.left);
        int lr = rHeight(root.left);
        int rl = lHeight(root.right);
        int rr = rHeight(root.right);
        
        if(ll == lr && rl == rr){
            return 1 + (int)(Math.pow(2, ll) - 1) + (int)(Math.pow(2, rr) - 1);
        }
        else if(ll == lr){
            return 1 + (int)(Math.pow(2, ll) - 1) + countNodes(root.right);
        }
        else{
            return 1 + (int)(Math.pow(2, rr) - 1) + countNodes(root.left);
        }
        
    }
    
    public int lHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        
        return 1 + lHeight(root.left);
    }
    
    public int rHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        
        return 1 + rHeight(root.right);
    }
}
