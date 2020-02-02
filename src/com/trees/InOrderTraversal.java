package com.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
	
	
	public List<Integer> inorderTraversal(TreeNode root) {
		
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();

		
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root); // Push root
				root = root.left; // Go to left 
			} else {
				TreeNode temp = stack.peek();
				stack.pop(); // If we encounter Null left we print that Node and then Go right;
				arr.add(temp.val);
				root = temp.right;

			}
		}
		return arr;
	}

}
