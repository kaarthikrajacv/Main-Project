package test;

import linkedList.*;
import linkedList.LinkedList.Node;

public class Test_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list = new LinkedList();
		Node head;// = list.head;
		head = new Node(9);
		list.head = head;
		
		list.addElementsToLast(5);
		list.addElementsToLast(6);
		list.addElementsToLast(head, 7);
		list.printLinkedList(head);
		list.printLinkedList();
	}  

}
