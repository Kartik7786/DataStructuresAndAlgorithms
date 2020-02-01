package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	List<List<Integer>> result = new ArrayList<List<Integer>>();
    Queue<Node> q = new LinkedList<Node>();
    public List<List<Integer>> levelOrder(Node root) {
        
        if(root == null)
            return result;
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            
            for(int i = 0; i< size; i++){
                Node temp = q.poll();
                for(Node elements : temp.children)
                {
                    q.add(elements);
                }
                
                arr.add(temp.val);
            }
       result.add(arr); }
        
        
    return result;
    }
}
