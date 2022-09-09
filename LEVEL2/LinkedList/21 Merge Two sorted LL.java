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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 != null && l2 == null) return l1;
        
        if(l1 == null && l2 != null) return l2;
        
        ListNode i = l1;
        ListNode j = l2;
        
        ListNode dummy = new ListNode(-1);
        ListNode k = dummy;
        
        while(i!=null && j!=null){
            if(i.val <= j.val){
                k.next = i;
                i = i.next;
                k = k.next;
            }
            else{
                k.next = j;
                j = j.next;
                k = k.next;
            }
        }
        
        while(i!=null){
            k.next = i;
            i = i.next;
            k = k.next;
        }
        
        while(j!=null){
            k.next = j;
            j = j.next;
            k = k.next;
        }
        
       return dummy.next; 
    }
}