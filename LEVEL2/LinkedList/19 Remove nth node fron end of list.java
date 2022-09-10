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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        
        ListNode dummy = new ListNode(-100);
        ListNode p = dummy;
        
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i =1; i<n; i++){
            fast = fast.next;
        } 
        
        while(fast.next != null){
            fast = fast.next;
            p.next = slow;
            p = p.next;
            slow = slow.next;
        }
        
        p.next = slow.next;
        
        return dummy.next;
    }
}