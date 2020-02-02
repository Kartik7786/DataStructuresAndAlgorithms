package com.linkedlist;

import com.strings.ListNode;

public class ReverseALinkedList {

	public ListNode reverseList(ListNode head) {

		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;

	}

	public ListNode recursivereverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		else {
			ListNode newHead = recursivereverse(head.next);
			head.next.next = head;
			head.next = null;

			return newHead;

		}

	}

}
