//Diameter of Binary Tree
//https://leetcode.com/problems/diameter-of-binary-tree/

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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Pair ans = fun(root);
        return ans.diameter - 1;
    }
    public Pair fun(TreeNode root){
        if(root == null){
            return new Pair(0, 0);
        }
        
        Pair left = fun(root.left);
        Pair right = fun(root.right);
        int diameter = Math.max(left.height + right.height + 1, 
                                Math.max(right.diameter, left.diameter));
        int height = Math.max(left.height, right.height) + 1;
        
        return new Pair(diameter, height);
    }
}
class Pair{
    int diameter;
    int height;
    
    Pair(int diameter, int height){
        this.diameter = diameter;
        this.height = height;
    }
}
