package com.trees;

public class InsertIntoBST {

	public TreeNode insertIntoBST(TreeNode root, int val) {

		TreeNode temp = root;
		TreeNode tail = null;

		while (temp != null) {

			tail = temp;
			if (temp.val == val)
				break;
			else if (temp.val > val)
				temp = temp.left;
			else
				temp = temp.right;

		}

		temp = new TreeNode(val);
		if (temp.val < tail.val)
			tail.left = temp;
		else
			tail.right = temp;

		return root;
	}
}
