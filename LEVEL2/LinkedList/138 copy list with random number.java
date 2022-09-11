/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        HashMap<Node, Node> map= new HashMap<>();
        Node dummy = new Node(-10000);
        Node p = dummy;
        Node curr = head;
        
        while(curr != null){
            Node newNode = new Node(curr.val);
            
            map.put(curr, newNode);
            
            p.next = newNode;
            p = p.next;
            curr = curr.next;
        }
        
        dummy = dummy.next;
        curr = head;
        p = dummy;
        
        while(curr != null){
            Node Random = curr.random;
            
            if(Random == null){
                p.random = null;
            }
            else{
                Node value = map.get(Random);
                
                p.random = value;
            }
            
            p = p.next;
            curr = curr.next;
        }
        
        return dummy;
    }
}