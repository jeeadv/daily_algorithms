//Convert Sorted Array to Binary Search Tree
//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return fun(nums, 0, nums.length - 1);
    }
    
    public TreeNode fun(int[] nums, int l, int r){
        if(l > r){
            return null;
        }
        
        int mid = (l + r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = fun(nums, l, mid - 1);
        root.right = fun(nums, mid + 1, r);
        return root;
    }
}
