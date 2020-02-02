package com.linkedlist;

public class AddTwoNumbers {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

			ListNode head = null;
			ListNode temp = null;
			int carry = 0;

			if (l1 == null && l2 == null)
				return head;

			if (l1 != null && l2 != null) {
				if (l1.val + l2.val > 9) {
					head = new ListNode((l1.val + l2.val) % 10);
					carry = (l1.val + l2.val) / 10;

				} else {
					head = new ListNode((l1.val + l2.val));
				}
			}
			l1 = l1.next;
			l2 = l2.next;
			temp = head;

			while (l1 != null && l2 != null) {
				if (carry + l1.val + l2.val > 9) {
					temp.next = new ListNode((carry + l1.val + l2.val) % 10);
					carry = (carry + l1.val + l2.val) / 10;

				} else {
					temp.next = new ListNode((carry + l1.val + l2.val) % 10);
					carry = 0;
				}
				temp = temp.next;
				l1 = l1.next;
				l2 = l2.next;
			}

			while (l1 != null) {
				if (carry + l1.val > 9) {
					temp.next = new ListNode((carry + l1.val) % 10);
					carry = (carry + l1.val) / 10;

				} else {
					temp.next = new ListNode((carry + l1.val) % 10);
					carry = 0;
				}
				temp = temp.next;
				l1 = l1.next;
			}

			while (l2 != null) {
				if (carry + l2.val > 9) {
					temp.next = new ListNode((carry + l2.val) % 10);
					carry = (carry + l2.val) / 10;

				} else {
					temp.next = new ListNode((carry + l2.val) % 10);
					carry = 0;
				}
				temp = temp.next;
				l2 = l2.next;
			}

			if (carry != 0)
				temp.next = new ListNode(carry);

			return head;

		}
	}
}
