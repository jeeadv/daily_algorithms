//Sum of Root To Leaf Binary Numbers
//https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//top down
class Solution {
    
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    
    public int dfs(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        
        sum = sum * 2 + root.val;
        
        if(root.left == null && root.right == null){
            return sum;
        }
        
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
    
    public int sum = 0;
    public int sumRootToLeaf1(TreeNode root) {
        sum = 0;
        preorder(root, "");
        return sum;
    }
    
    public void preorder(TreeNode root, String str){
        if(root == null){
            return;
        }
        str += root.val;
        if(root.left == null && root.right == null){
            sum += binaryToDecimal(str);
        }
        
        preorder(root.left, str);
        preorder(root.right, str);
    }
    
    public int binaryToDecimal(String str){
        System.out.print(str + " ");
        int sum = 0;
        int i = 0;
        while(i < str.length()){
            sum = 2*sum + Integer.parseInt("" + str.charAt(i));
            i++;
        }
        System.out.println(sum);
        return sum;
    }
}

// top down then bottom up
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return fun(root, 0);
    }
    
    public int fun(TreeNode root, int num) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return num * 10 + root.val;
        }
        return fun(root.left, num * 10 + root.val) + fun(root.right, num * 10 + root.val);
    }
}

// top down
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int res = 0;
    public int sumNumbers(TreeNode root) {
        res = 0;
        fun(root, 0);
        return res;
    }
    
    public void fun(TreeNode root, int num) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            res += num * 10 + root.val;
            return;
        }
        fun(root.left, num * 10 + root.val);
        fun(root.right, num * 10 + root.val);
    }
}
