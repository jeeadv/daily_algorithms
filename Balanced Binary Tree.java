//https://www.interviewbit.com/problems/balanced-binary-tree/
//Balanced Binary Tree

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int isBalanced(TreeNode A) {
        if(fun(A) == -1){
            return 0;
        }
        else{
            return 1;
        }
    }
    public int fun(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = fun(node.left);
        if(left == -1){
            return -1;
        }
        int right = fun(node.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right) + 1;
    }
}
