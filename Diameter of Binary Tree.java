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
    Integer max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        max = 0;
        fun(root);
        return max - 1;
    }
    
    public int fun(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = fun(root.left);
        int right = fun(root.right);
        
        max = Math.max(left + right + 1, max);
        return Math.max(left, right) + 1;
    }
}
// another solution without global variable
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
