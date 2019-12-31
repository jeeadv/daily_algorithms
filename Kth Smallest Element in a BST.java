//Kth Smallest Element in a BST
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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
    int n;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        ans = -1;
        n = k;
        inorder(root);
        return ans;
    }
    
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        n--;
        if(n == 0){
            ans = root.val;
            return;
        }
        
        inorder(root.right);
    }
}
