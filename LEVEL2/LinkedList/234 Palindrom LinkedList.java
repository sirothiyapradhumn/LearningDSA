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
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        //step 1
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //step 2 reverse 2nd half
        slow.next = reverse(slow.next);
        
        //step 3
        slow = slow.next;
        
        //step 4
        while(slow != null){
            if(head.val != slow.val){
                return false;
            }
            
            head = head.next;
            slow = slow.next;
        }
        
        return true;
    }
}