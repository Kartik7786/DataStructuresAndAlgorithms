package com.trees;

public class MinDepthOfBinaryTree {
	public int minDepth(TreeNode root) {

		if (root == null)
			return 0;
		return depth(root);

	}

	public int depth(TreeNode root) {
		if (root != null) {

			int x = depth(root.left) + 1;
			int y = depth(root.right) + 1;
			return x >= 2 && y >= 2 ? Math.min(x, y) : Math.max(x, y);
		}
		return 0;
	}

}
