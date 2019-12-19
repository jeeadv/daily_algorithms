//Path Sum II
//https://leetcode.com/problems/path-sum-ii/

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> arr = new LinkedList<>();
        fun(root, sum, new LinkedList<>(), arr);
        return arr;
    }
    public void fun(TreeNode root, int sum, List<Integer> list, List<List<Integer>> arr){
        if(root == null){
            return;
        }
        
        list.add(root.val);
        
        if(root.left == null && root.right == null && root.val == sum){
            arr.add(new LinkedList<>(list));
        }
        else{
            fun(root.left, sum - root.val, list, arr);
            fun(root.right, sum - root.val, list, arr);
            
        }
        list.remove(list.size() - 1);
    }
}
