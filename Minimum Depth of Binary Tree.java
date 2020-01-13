//Minimum Depth of Binary Tree
//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int level = 1;
        
        while(!q.isEmpty()){
            int n = q.size();
            
            for(int i = 0; i < n; i++){
                TreeNode top = q.poll();
                if(isLeaf(top)){
                    return level;
                }
                
                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
            }
            level++;
        }
        return level;
    }
    
    public boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
    
    public int minDepth1(TreeNode root) {
        if(root == null)
            return 0;
        else if(root.left != null && root.right != null)
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        else if(root.left != null)
            return 1 + minDepth(root.left);
        else if(root.right != null)
            return 1 + minDepth(root.right);
        else
            return 1;
    }
}
