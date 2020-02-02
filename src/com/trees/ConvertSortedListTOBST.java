package com.trees;

import java.util.ArrayList;
import java.util.List;

import com.strings.ListNode;

public class ConvertSortedListTOBST {

	List<Integer> list = new ArrayList<Integer>();

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		createList(head);
		return createTree(0, list.size() - 1);

	}

	public void createList(ListNode head) {
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
	}

	public TreeNode createTree(int low, int high) {
		if (low > high)
			return null;
		else {
			int mid = (low + high) / 2;
			TreeNode root = new TreeNode(list.get(mid));
			root.left = createTree(low, mid - 1);
			root.right = createTree(mid + 1, high);

			return root;
		}
	}
}
