package com.trees;

public class BinarySearchTree {

	TreeNode root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void insert(int val) {
		if (this.root == null) {
			this.root = new TreeNode(val);
			return;
		} else
			rInsert(this.root, val);

	}

	public int height(TreeNode root) {
		if (root == null)
			return 0;
		int x = height(root.left) + 1;
		int y = height(root.left) + 1;

		return Math.max(x, y);

	}

	public int balancefactor(TreeNode root) {
		int left = root != null && root.left != null ? root.left.height : 0;
		int right = root != null && root.right != null ? root.right.height : 0;
		return left - right;
	}

	public void itInsert(int val) {
		TreeNode input = root;
		TreeNode temp = null;
		while (input != null) {
			temp = input;
			if (val < input.val) {

				input = input.left;
			} else if (val > input.val) {

				input = input.right;
			} else
				return;

		}
		input = new TreeNode(val);
		if (temp.val < input.val)
			temp.right = input;
		else if (temp.val > input.val)
			temp.left = input;

	}

	public TreeNode rInsert(TreeNode input, int val) {

		if (input == null) {
			input = new TreeNode(val);
			input.height = 1;
			return input;
		}
		if (val < input.val) {
			input.left = rInsert(input.left, val);
		} else if (val > input.val) {
			input.right = rInsert(input.right, val);
		}

		input.height = height(input);

		if (balancefactor(input) == 2 && balancefactor(input.left) == 1)
			return LLRotation(input);

		return input;
	}

	public TreeNode LLRotation(TreeNode input) {

		TreeNode inputleft = input.left;
		TreeNode inputleftright = inputleft.right;

		inputleft.right = input;
		input.left = inputleftright;
		if (input == this.root) {
			this.root = inputleft;

		}
		input.height = height(input);
		inputleft.height = height(inputleft);
		return inputleft;

	}

	public void inorder(TreeNode input) {
		if (input != null) {
			inorder(input.left);
			System.out.print(input.val + "  ");
			inorder(input.right);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();
		b.insert(100);
		b.insert(80);
		b.insert(70);
		b.inorder(b.root);
		System.out.println(b.height(b.root));

	}
}
