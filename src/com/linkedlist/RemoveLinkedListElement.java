package com.linkedlist;

import java.util.ArrayList;

import com.strings.ListNode;

public class RemoveLinkedListElement {
	public ListNode removeElements(ListNode head, int val) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		if (head == null)
			return head;

		ListNode newHead = null;
		ListNode temp = head;
		while (temp != null) {
			arr.add(temp.val);
			temp = temp.next;
		}
		int i = 0;
		for (; i < arr.size(); i++)
			if (arr.get(i) != val) {
				newHead = new ListNode(arr.get(i));
				i++;
				break;

			}
		temp = newHead;

		for (; i < arr.size(); i++) {
			if (arr.get(i) != val) {
				temp.next = new ListNode(arr.get(i));
				temp = temp.next;
			}
		}
		return newHead;
	}
}
