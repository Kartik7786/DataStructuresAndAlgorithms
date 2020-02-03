package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class DFSUndirected {

	public static void dfs(int at, HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited, int[] components,
			int count) {

		if (visited[at]) {
			return;
		} else {
			visited[at] = true;
			components[at] = count;
			ArrayList<Integer> neighbors = graph.get(at);
			if (neighbors != null && !neighbors.isEmpty()) {
				for (Integer node : neighbors) {
					dfs(node, graph, visited, components, count);
				}
			}
		}
	}

	public static void main(String[] args) {

		int number_of_nodes = 8;

		boolean visited[] = new boolean[number_of_nodes];
		int components[] = new int[number_of_nodes];
		int count = 1;

		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

		ArrayList<Integer> neighbors = new ArrayList<>();
		neighbors.add(1);
		neighbors.add(2);
		graph.put(0, neighbors);

		neighbors = new ArrayList<>();
		System.out.println(neighbors);
		neighbors.add(0);
		neighbors.add(3);
		graph.put(1, neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(1);
		neighbors.add(2);
		neighbors.add(4);
		graph.put(3, neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(0);
		neighbors.add(3);

		graph.put(2, neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(3);
		graph.put(4, neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(5);
		neighbors.add(7);
		graph.put(6, neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(6);
		neighbors.add(7);
		graph.put(5, neighbors);

		neighbors = new ArrayList<>();
		neighbors.add(5);
		neighbors.add(6);
		graph.put(7, neighbors);

		for (int i : graph.keySet()) {
			if (!visited[i])
				dfs(i, graph, visited, components, count++);
		}
		System.out.println("Hello World, lets see connected components in action");

	}

}
