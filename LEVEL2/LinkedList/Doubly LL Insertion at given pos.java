/* Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}*/

class GfG
{
    //Function to insert a new node at given position in doubly linked list.
    void addNode(Node head, int pos, int data)
	{
		// Your code here
		Node temp = new Node(data);
		Node p = head;
		
		if(head == null){
		    head = temp;
		    return;
		}
		
		for(int i = 1; i<=pos; i++){
		    p = p.next;
		}
		
		if(p.next == null){
		    p.next = temp;
		    temp.prev = p;
		}
		else{
		    p.next.prev = temp;
		    temp.next = p.next;
		    temp.prev = p;
		    p.next = temp;
		}
		
	}
}