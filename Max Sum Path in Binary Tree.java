//Max Sum Path in Binary Tree
//https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/

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
    public int maxPathSum(TreeNode node) {
        Pair ans = fun(node);
        return ans.maxSum;
    }
    public static Pair fun(TreeNode node){
        if(node == null){
            return null;
        }
        
        if(node.left == null && node.right == null){
            Pair temp = new Pair();
            temp.maxSum = node.val;
            temp.maxPath = node.val;
            return temp;
        }
        Pair left = fun(node.left);
        Pair right = fun(node.right);
        
        Pair temp = new Pair();
        
        if(left == null){
            temp.maxPath = right.maxPath + node.val;
            temp.maxSum = Math.max(temp.maxPath, right.maxSum);
        }
        else if(right == null){
            temp.maxPath = left.maxPath + node.val;
            temp.maxSum = Math.max(temp.maxPath, left.maxSum);
        }
        else{
            temp.maxPath = Math.max(left.maxPath, right.maxPath) + node.val;
            temp.maxSum = max(temp.maxPath, left.maxSum, right.maxSum,
                            left.maxPath + right.maxPath + node.val);
        }
        temp.maxPath = Math.max(temp.maxPath, node.val);
        temp.maxSum = Math.max(temp.maxSum, temp.maxPath);
        return temp;
        
    }
    public static int max(int a, int b, int c, int d){
        return Math.max(Math.max(a,b),Math.max(c,d));
    }
}
class Pair{
    int maxSum;
    int maxPath;
}
