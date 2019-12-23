//Average of Levels in Binary Tree
//https://leetcode.com/problems/average-of-levels-in-binary-tree/

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new LinkedList<>();
        List<Integer> count = new LinkedList<>();
        fun(root, sum, count, 0);
        int n = sum.size();
        for(int i=0;i<n;i++){
            sum.set(i, sum.get(i)/count.get(i));
        }
        return sum;
    }
    public void fun(TreeNode root, List<Double> sum, List<Integer> count, int level){
        if(root == null){
            return;
        }
        
        if(sum.size() == level){
            sum.add(0.0);
            count.add(0);
        }
        
        sum.set(level, sum.get(level) + root.val);
        count.set(level, count.get(level) + 1);
        
        fun(root.left, sum, count, level + 1);
        fun(root.right, sum, count, level + 1);
    }
}
