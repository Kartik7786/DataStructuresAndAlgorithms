package com.trees;

import java.util.ArrayList;

public class IsValidBinaryTree {
	ArrayList<Integer> arr = new ArrayList<Integer>();

	public boolean isValidBST(TreeNode root) {

		if (root == null)
			return true;

		inorder(root);

		for (int i = 0; i < arr.size() - 1; i++) {
			if (arr.get(i) > arr.get(i + 1))
				return false;

		}
		return true;
	}

	private void inorder(TreeNode root) {

		if (root != null) {
			inorder(root.left);
			arr.add(root.val);
			inorder(root.right);
		}
	}
}
