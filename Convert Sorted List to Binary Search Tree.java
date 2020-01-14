//Convert Sorted List to Binary Search Tree
//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        TreeNode root = null;
        root = fun(list, 0, list.size() - 1);
        return root;
    }
    
    public TreeNode fun(List<Integer> list, int l, int r){
        if(l > r){
            return null;
        }
        
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = fun(list, l, mid - 1);
        root.right = fun(list, mid + 1, r);
        
        return root;
    }
    
}
