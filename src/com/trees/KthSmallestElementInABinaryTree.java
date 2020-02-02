package com.trees;

import java.util.PriorityQueue;

public class KthSmallestElementInABinaryTree {
	PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    public int kthSmallest(TreeNode root, int k) {
       preorder(root); 
       for(int i=0; i< k-1; i++){
           queue.poll();
       }
        return queue.peek();
    }
    
    public void preorder(TreeNode root){
        if(root != null){
            preorder(root.left);
            queue.add(root.val);
            preorder(root.right);
        }
        
    }
}
