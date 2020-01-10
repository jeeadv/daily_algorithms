//All Elements in Two Binary Search Trees
//https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        Stack<TreeNode> s1 = new Stack<>();
        pushLeft(root1, s1);
        
        while(!s1.isEmpty()){
            list1.add(s1.peek().val);
            pushLeft(s1.pop().right, s1);
        }
        
        List<Integer> list2 = new LinkedList<>();
        Stack<TreeNode> s2 = new Stack<>();
        pushLeft(root2, s2);
        
        while(!s2.isEmpty()){
            list2.add(s2.peek().val);
            pushLeft(s2.pop().right, s2);
        }
        
        return merge(list1, list2);
    }
    
    public List<Integer> merge(List<Integer> list1, List<Integer> list2){
        List<Integer> list = new LinkedList<>();
        int i = 0;
        int j = 0;
        
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                list.add(list1.get(i));
                i++;
            }
            else{
                list.add(list2.get(j));
                j++;
            }
        }
        
        while(i < list1.size()){
            list.add(list1.get(i));
            i++;
        }
        
        while(j < list2.size()){
            list.add(list2.get(j));
            j++;
        }
        
        return list;
    }
    
    public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        pushLeft(root1, s1);
        pushLeft(root2, s2);
        
        while(!s1.isEmpty() && !s2.isEmpty()){
            Stack<TreeNode> s = s1.peek().val < s2.peek().val ? s1 : s2;
            list.add(s.peek().val);
            pushLeft(s.pop().right, s);
        }
        
        while(!s1.isEmpty()){
            list.add(s1.peek().val);
            pushLeft(s1.pop().right, s1);
        }
        
        while(!s2.isEmpty()){
            list.add(s2.peek().val);
            pushLeft(s2.pop().right, s2);
        }
        return list;
    }
    
    public void pushLeft(TreeNode root, Stack<TreeNode> s){
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }
    
    
}
