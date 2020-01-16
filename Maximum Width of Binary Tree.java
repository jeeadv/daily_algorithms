//Maximum Width of Binary Tree
//https://leetcode.com/problems/maximum-width-of-binary-tree/

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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        preorder(root, 1);
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int globalMax = Integer.MIN_VALUE;
        
        while(!q.isEmpty()){
            int n = q.size();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                TreeNode top = q.poll();
                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
                
                if(top.val < min){
                    min = top.val;
                }
                if(top.val > max){
                    max = top.val;
                }
            }
            if(max - min + 1> globalMax){
                globalMax = max - min + 1;
            }
        }
        return globalMax;
    }
    
    public void preorder(TreeNode root, int x){
        if(root == null){
            return;
        }
        
        root.val = x;
        
        preorder(root.left, 2*x);
        preorder(root.right, 2*x + 1);
    }
    
}
