//Add Two Numbers
//https://leetcode.com/problems/add-two-numbers/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i = l1;
        ListNode j = l2;
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        
        while(i != null && j != null){
            int digit = (i.val + j.val + carry)%10;
            carry = (i.val + j.val + carry)/10;
            
            ListNode node = new ListNode(digit);
            if(head == null){
                head = node;
            }
            if(tail == null){
                tail = node;
            }
            else{
                tail.next = node;
                tail = tail.next;
            }
            
            i = i.next;
            j = j.next;
        }
        while(i != null){
            int digit = (i.val + carry)%10;
            carry = (i.val + carry)/10;
            
            ListNode node = new ListNode(digit);
            if(head == null){
                head = node;
            }
            if(tail == null){
                tail = node;
            }
            else{
                tail.next = node;
                tail = tail.next;
            }
            i = i.next;
        }
        while(j != null){
            int digit = (j.val + carry)%10;
            carry = (j.val + carry)/10;
            
            ListNode node = new ListNode(digit);
            if(head == null){
                head = node;
            }
            if(tail == null){
                tail = node;
            }
            else{
                tail.next = node;
                tail = tail.next;
            }
            j = j.next;
        }
        if(carry>0){
            ListNode node = new ListNode(carry);
            tail.next = node;
        }
        
        return head;
    }
}
