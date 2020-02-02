package com.trees;

public class IsBalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		if (Math.abs(helper(root.left) - helper(root.right)) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}

	public int helper(TreeNode root) {
		if (root != null) {
			int x = helper(root.left) + 1;
			int y = helper(root.right) + 1;
			return Math.max(x, y);
		} else
			return -1;
	}

}
