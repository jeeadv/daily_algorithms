//Check Completeness of a Binary Tree
//https://leetcode.com/problems/check-completeness-of-a-binary-tree/

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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode top = q.poll();
            
            if(top.left != null)
                q.add(top.left);
            
            if(top.right != null)
                q.add(top.right);
            
            if(top.left == null && top.right != null){
                return false;
            }
            
            if(top.left == null || top.right == null){
                break;
            }
        }
        
        while(!q.isEmpty()){
            TreeNode top = q.poll();
            if(!isLeaf(top)){
                return false;
            }
        }
        return true;
    }
    
    public boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
}
