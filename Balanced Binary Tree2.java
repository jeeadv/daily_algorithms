//Balanced Binary Tree
//https://leetcode.com/problems/balanced-binary-tree/

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
    public boolean isBalanced(TreeNode root) {
        if(fun(root) == -1){
            return false;
        }
        else{
            return true;
        }
    }
    
    public int fun(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = fun(root.left);
        if(left == -1){
            return -1;
        }
        
        int right = fun(root.right);
        if(right == -1){
            return -1;
        }
        
        if(Math.abs(left - right) > 1){
            return -1;
        }
        else{
            return Math.max(left, right) + 1;
        }
    }
}
