//Flatten Binary Tree to Linked List
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

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
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        
        TreeNode prev = null;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        
        while(!s.isEmpty()){
            TreeNode top = s.pop();
            
            if(top.right != null){
                s.push(top.right);
            }
            if(top.left != null){
                s.push(top.left);
            }
            
            if(prev == null){
                prev = top;
            }
            else{
                prev.left = null;
                prev.right = top;
                prev = top;
            }
        }
    }
}
