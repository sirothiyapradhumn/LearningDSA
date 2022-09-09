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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        
        ListNode c1 = l1;
        ListNode c2 = l2;
        
        int carry = 0; 
        
        while(c1 != null || c2 != null){
            int num1 = c1!=null ? c1.val: 0;
            int num2 = c2!=null ? c2.val: 0;
            
            int sum = num1 + num2 + carry;
            int rem = sum%10;
            carry = sum/10;
            
            p.next = new ListNode(rem);
            p = p.next;
            
            if(c1 != null) c1=c1.next;
            
            if(c2 != null) c2=c2.next;
        }
        
        if(carry>0){
            p.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}