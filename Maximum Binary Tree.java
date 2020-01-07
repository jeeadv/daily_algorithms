//Maximum Binary Tree

//https://leetcode.com/problems/maximum-binary-tree/

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        return fun(nums, n, l, r);
    }
    public TreeNode fun(int[] nums, int n, int l, int r){
        if(l > r){
            return null;
        }
        
        int i = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[i]);
        root.left = fun(nums, n, l, i - 1);
        root.right = fun(nums, n, i + 1, r);
        return root;
    }
    public int findMax(int[] nums, int l, int r){
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=l;i<=r;i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
