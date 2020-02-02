package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		if (root == null)
			return result;

		q.add(root);
		int counter = 1;

		while (!q.isEmpty()) {
			int size = q.size();
			if (counter % 2 == 0) {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				for (int i = 0; i < size; i++) {
					TreeNode temp = q.remove();
					if (temp.left != null)
						q.add(temp.left);
					if (temp.right != null)
						q.add(temp.right);
					arr.add(temp.val);
				}
				result.add(arr);

			} else {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				for (int i = size - 1; i >= 0; i--) {
					TreeNode temp = q.remove();
					if (temp.left != null)
						q.add(temp.left);
					if (temp.right != null)
						q.add(temp.right);
					arr.add(temp.val);
				}
				result.add(arr);
			}
		}
		return result;
	}
}
