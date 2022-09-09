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
        if(head == null || head.next == null) return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        
        ListNode op = odd;
        ListNode ep = even;
        
        ListNode temp = even.next;
        
        int count = 3;
        
        while(temp != null){
            if(count % 2 == 0){
                //even idx
                ep.next = temp;
                ep = ep.next;
            }
            else {
                op.next = temp;
                op = op.next;
            }
            
            temp = temp.next;
            count++;
        }
        
        op.next = even;
        ep.next = null;
        return head;
    }
}