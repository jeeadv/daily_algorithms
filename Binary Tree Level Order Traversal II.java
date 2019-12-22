// Binary Tree Level Order Traversal II
//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        fun(root, 0, list);
        Collections.reverse(list);
        return list;
    }
    public void fun(TreeNode root, int level, List<List<Integer>> list){
        if(root == null){
            return;
        }
        if(list.size() == level){
            list.add(new LinkedList<>());
        }
        list.get(level).add(root.val);
        fun(root.left, level + 1, list);
        fun(root.right, level + 1, list);
    }
}
