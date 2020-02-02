package com.trees;

public class SearchInABST {

	public TreeNode searchBST(TreeNode root, int val) {

		if (root != null) {

			if (root.val == val)
				return root;
			else if (val < root.val)
				return searchBST(root.left, val);
			else
				return searchBST(root.right, val);
		}
		return null;
	}
}
/*
 * public TreeNode searchBST(TreeNode root, int val) {
 * 
 * while(root != null){ if(root.val == val) return root; else if(val < root.val)
 * root=root.left; else root = root.right; }
 * 
 * return null; }
 */