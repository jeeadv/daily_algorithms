//Leaf-Similar Trees
//https://leetcode.com/problems/leaf-similar-trees/
//O(n) time O(n) space
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        preorder(root1, list1);
        preorder(root2, list2);
        
        //System.out.println(list1);
        //System.out.println(list2);
        
        if(list1.size() == list2.size()){
            for(int i=0;i<list1.size();i++){
                if(list1.get(i) != list2.get(i)){
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
    public void preorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null)
            list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}

// O(n) time O(logn) space
