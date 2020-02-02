package com.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Deque<TreeNode> q = new LinkedList<TreeNode>();

		if (root == null)
			return result;

		q.add(root);

		boolean flag = false;
		while (!q.isEmpty()) {
			int size = q.size();
			LinkedList<Integer> arr = new LinkedList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.remove();

				if (temp.left != null)
					q.addLast(temp.left);
				if (temp.right != null)
					q.addLast(temp.right);

				if (flag)
					arr.addFirst(temp.val);
				else
					arr.addLast(temp.val);
			}
			flag = (!flag);
			result.add(arr);
		}
		return result;

	}
}
