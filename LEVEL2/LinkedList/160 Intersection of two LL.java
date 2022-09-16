/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int findLength(ListNode head){
        int count =0;
        
        while(head != null){
            count++;
            head = head.next;
        }
        
        return count;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB==null) return null;
        
        int countA = findLength(headA);
        int countB = findLength(headB);
        
        int diff = Math.abs(countA-countB);
        
        if(countA > countB){
            for(int i = 1; i<=diff; i++){
                headA = headA.next;
            }
        }
        else{
            for(int i = 1; i<=diff; i++){
                headB = headB.next;
            }
        }
        
        while(headA != null){
            if(headA == headB) return headA;
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}