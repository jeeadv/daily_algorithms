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
    ListNode head = null;
    
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        return inorder(0, findSize(head) - 1);
    }
    
    public int findSize(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    
    public TreeNode inorder(int l, int r){
        if(l > r){
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode left = inorder(l, mid - 1);
        
        TreeNode root = new TreeNode(this.head.val);
        root.left = left;
        
        this.head = this.head.next;
        
        root.right = inorder(mid + 1, r);

        return root;
    }
    
    public TreeNode sortedListToBST1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        TreeNode root = null;
        root = preorder(list, 0, list.size() - 1);
        return root;
    }
    
    public TreeNode preorder(List<Integer> list, int l, int r){
        if(l > r){
            return null;
        }
        
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = preorder(list, l, mid - 1);
        root.right = preorder(list, mid + 1, r);
        
        return root;
    }
    
}
