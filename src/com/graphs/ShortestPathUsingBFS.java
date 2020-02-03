package com.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUsingBFS {
	static int no_of_nodes;



	public static void BFS(int start, int end, HashMap<Integer, ArrayList<Integer>> graph) {

		Integer[] parent = solve(start, graph);

		ArrayList<Integer> path = reconstructPath(start, end, parent);

		if (path != null) {
			for (Integer element : path) {
				System.out.print(element + " ->");
			}
		}else {
			System.out.println("There doesnt exsist any path");
		}
	}

	public static ArrayList<Integer> reconstructPath(int start, int end, Integer[] parent) {

		ArrayList<Integer> path = new ArrayList<>();
		Integer at = end;
		while (at != null) {
			path.add(at);
			at = parent[at];
		}
		Collections.reverse(path);

		if (path.get(0) == start) {
			return path;
		} else {
			return null;
		}
	}

	public static Integer[] solve(int start, HashMap<Integer, ArrayList<Integer>> graph) {

		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[no_of_nodes];
		Integer[] parent = new Integer[no_of_nodes];

		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			ArrayList<Integer> neighbors = graph.get(node);

			if (neighbors != null) {
				for (int next : neighbors) {
					if (!visited[next]) {
						queue.add(next);
						visited[next] = true;
						parent[next] = node;
					}
				}
			}
		}

		return parent;
	}
	
	
	public static void addDirectedEdge(int from, int to, HashMap<Integer, ArrayList<Integer>> graph) {

		ArrayList<Integer> neighbors = graph.get(from);
		if (neighbors == null) {
			neighbors = new ArrayList<Integer>();
			neighbors.add(to);
			graph.put(from, neighbors);
		} else {
			neighbors.add(to);
		}

	}

	public static void main(String[] args) {
		ShortestPathUsingBFS.no_of_nodes = 13;

		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
		addDirectedEdge(10, 1, graph);
		addDirectedEdge(9, 10, graph);
		addDirectedEdge(8, 1, graph);
		addDirectedEdge(8, 12, graph);
		addDirectedEdge(9, 8, graph);
		addDirectedEdge(12, 2, graph);
		addDirectedEdge(3, 4, graph);
		addDirectedEdge(3, 2, graph);
		addDirectedEdge(0, 9, graph);
		addDirectedEdge(0, 7, graph);
		addDirectedEdge(0, 11, graph);
		addDirectedEdge(7, 11, graph);
		addDirectedEdge(7, 3, graph);
		addDirectedEdge(7, 6, graph);
		addDirectedEdge(6, 5, graph);

		BFS(9,2,graph);

	}

}
