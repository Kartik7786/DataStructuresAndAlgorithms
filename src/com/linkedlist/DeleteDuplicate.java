package com.linkedlist;

import java.util.ArrayList;

import com.strings.ListNode;

public class DeleteDuplicate {
	public ListNode deleteDuplicates(ListNode head) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode result = null;
		ListNode temp = head;

		while (temp != null) {
			list.add(temp.val);
			temp = temp.next;
		}

		if (!list.isEmpty())
			result = new ListNode(list.get(0));

		temp = result;

		for (int i = 1; i <= list.size() - 1; i++) {
			if (list.get(i) == list.get(i + 1))
				continue;
			else {
				temp.next = new ListNode(list.get(i));
				temp = temp.next;
			}
		}
		return result;
	}
}