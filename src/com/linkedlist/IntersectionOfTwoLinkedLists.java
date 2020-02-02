package com.linkedlist;

import java.util.HashSet;

import com.strings.ListNode;

public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		if (headA == null || headB == null)
			return null;
		ListNode temp1 = headA;
		ListNode temp2 = headB;

		while (temp1 != null) {
			set.add(temp1);
			temp1 = temp1.next;
		}

		while (temp2 != null) {
			if (set.contains(temp2))
				return temp2;
			temp2 = temp2.next;

		}
		return null;
	}

}
