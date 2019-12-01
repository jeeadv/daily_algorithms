//https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
//Kth Smallest Element In Tree

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
    static int count = 0;
    static int ans = 0;
    public int kthsmallest(TreeNode node, int k) {
        count = 0;
        ans = 0;
        inorder(node, k);
        return ans;
    }
    public static void inorder(TreeNode node, int k){
        if(node == null){
            return;
        }
        inorder(node.left, k);
        count++;
        if(count == k){
            ans = node.val;
            return;
        }
        inorder(node.right, k);
    }
}

