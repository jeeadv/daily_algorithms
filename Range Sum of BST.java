//Range Sum of BST
//https://leetcode.com/problems/range-sum-of-bst/
//recursive
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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        
        if(root.val < L){
            return rangeSumBST(root.right, L, R);
        }
        else if(root.val > R){
            return rangeSumBST(root.left, L, R);
        }
        else{
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }
}

// iterative

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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        
        int sum = 0;
        TreeNode top = null;
        while(!s.isEmpty()){
            top = s.pop();
            if(top.val < L){
                if(top.right != null)
                    s.push(top.right);
            }
            else if(top.val > R){
                if(top.left != null)
                    s.push(top.left);
            }
            else{
                sum += top.val;
                if(top.left != null)
                    s.push(top.left);
                if(top.right != null)
                    s.push(top.right);
            }
        }
        return sum;
    }
}
// 2nd iterative

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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        
        int sum = 0;
        TreeNode top = null;
        while(!s.isEmpty()){
            top = s.pop();
            if(top.val >= L && top.val <= R){
                sum += top.val;
            }
            if(top.val > L){
                if(top.left != null)
                    s.push(top.left);
            }
            if(top.val < R){
                if(top.right != null)
                    s.push(top.right);
            }
        }
        return sum;
    }
}
