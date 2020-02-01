package com.linkedlist;

import java.util.HashMap;

public class CopyListWithRandomPointers {
	public Node copyRandomList(Node head) {

		if (head == null)
			return null;

		

		HashMap<Node, Node> randommap = new HashMap<Node, Node>();
		HashMap<Node, Node> listmap = new HashMap<Node, Node>();

		Node temp = head;
		
		while (temp != null) {
			randommap.put(temp, temp.random);
			temp = temp.next;

		}
		

		Node newhead = new Node(head.val);

		Node newtemp = newhead;
		
		temp = head.next;

		while (temp != null) {
			newtemp.next = new Node(temp.val);
			newtemp = newtemp.next;
			temp = temp.next;
		}

		temp = head;
		newtemp = newhead;

		while (temp != null) {

			listmap.put(temp, newtemp);
			temp = temp.next;
			newtemp = newtemp.next;

		}

		temp = head;
		newtemp = newhead;

		while (temp != null) {
			newtemp.random = listmap.get(randommap.get(temp));

			temp = temp.next;
			newtemp = newtemp.next;
		}

		return newhead;

	}
}
