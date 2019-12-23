//Univalued Binary Tree
//https://leetcode.com/problems/univalued-binary-tree/
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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return false;
        }
        return fun(root, root.val);
    }
    public boolean fun(TreeNode root, int val){
        if(root == null){
            return true;
        }
        return root.val == val && fun(root.left, val) && fun(root.right, val);
    }
}
