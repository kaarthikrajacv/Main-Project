package linkedList;

public class LinkedList {
	
	public Node head;
	
	public static class Node{
		
		int data;
		public Node next;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	
	public void addElementsToLast(int data) {
		
		if(head == null) {
			
			head = new Node(data);
			return;
		}else {
			Node temp;
			temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
			return;
		
		}

	}
	
	public void addElementsToLast(Node head, int data) {
		
		if(head == null) {
			
			head = new Node(data);
			return;
		}else {
			Node temp;
			temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
			return;
		
		}
		
	}
	
	public void printLinkedList() {
		
		Node tnode = head;
        while (tnode != null)
        {
            System.out.println(tnode.data);
            tnode = tnode.next;
        }
	}
	
	public void printLinkedList(Node head) {
		
		Node tnode = head;
        while (tnode != null)
        {
            System.out.println(tnode.data);
            tnode = tnode.next;
        }
	}
}
