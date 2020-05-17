//Odd Even Linked List
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode h1 = head;
        ListNode h2 = head.next;
        
        ListNode tmp1 = h1;
        ListNode tmp2 = h2;
        
        while(tmp1 != null && tmp1.next != null && tmp2 != null && tmp2.next != null) {
            
            tmp1.next = tmp1.next.next;
            tmp2.next = tmp2.next.next;
            
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        
        tmp1.next = h2;
        return h1;
    }
}
