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
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode forwd = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = forwd;
        }
        
        return prev;
    }
    
    public void reorderList(ListNode head) {
        if(head== null || head.next == null) return;
        
        //step 1 mid
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
            
        newHead = reverse(newHead);
        
        //step 2
        ListNode f1 = head;
        ListNode f2 = newHead;
        
        ListNode c1 = null;
        ListNode c2 = null;
        
        while(f2 != null){
            c1 = f1.next;
            c2 = f2.next;
            
            f1.next = f2;
            f2.next = c1;
            
            f1 = c1;
            f2 = c2;
        }
        
    }
}