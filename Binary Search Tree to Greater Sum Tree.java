//Binary Search Tree to Greater Sum Tree
//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
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
    public TreeNode bstToGst(TreeNode root) {
        return inorder(root, new int[]{0});
    }
    
    public TreeNode inorder(TreeNode root, int[] sum){
        if(root == null){
            return null;
        }
        root.right = inorder(root.right, sum);
        
        root.val += sum[0];
        sum[0] = root.val;
        
        root.left = inorder(root.left, sum);
        return root;
    }
}
