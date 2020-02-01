package com.trees;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
// For particular Node which has both left and right child, Hold them in temporary           variables once you get them now for that node assign left child the right returned Node 
// and right child its left returned node
class InvertABinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root != null) {
			TreeNode left = invertTree(root.left);
			TreeNode right = invertTree(root.right);
			root.left = right;
			root.right = left;
			return root;
		} else
			return null;
	}
}