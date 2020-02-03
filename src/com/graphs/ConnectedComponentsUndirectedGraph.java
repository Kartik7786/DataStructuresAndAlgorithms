package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class ConnectedComponentsUndirectedGraph {


	public int countComponents(int n, int[][] edges) {

		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
		boolean[] visited = new boolean[n];
		int[] components = new int[n];
		int count = 1;

		for (int i = 0; i < n; i++) {
			addNodesInGraph(graph, i);
		}

		for (int i = 0; i < edges.length; i++) {
			adjacencyList(graph, edges, i);
		}

		for (Integer node : graph.keySet()) {
			if (!visited[node]) {
				dfs(node, graph, visited, count++, components);
			}
		}
		return count - 1;
	}

	public void adjacencyList(HashMap<Integer, ArrayList<Integer>> graph, int[][] edges, int i) {

		if (graph.get(edges[i][0]) == null) {
			ArrayList<Integer> neighbors = new ArrayList<>();
			neighbors.add(edges[i][1]);
			graph.put(edges[i][0], neighbors);
		} else {
			ArrayList<Integer> neighbors = graph.get(edges[i][0]);
			neighbors.add(edges[i][1]);
			graph.put(edges[i][0], neighbors);
		}

		if (graph.get(edges[i][1]) == null) {
			ArrayList<Integer> neighbors = new ArrayList<>();
			neighbors.add(edges[i][0]);
			graph.put(edges[i][1], neighbors);
		} else {
			ArrayList<Integer> neighbors = graph.get(edges[i][1]);
			neighbors.add(edges[i][0]);
			graph.put(edges[i][1], neighbors);
		}

	}

	public void dfs(int node, HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited, int count,
			int[] components) {
		if (visited[node]) {
			return;
		} else {
			visited[node] = true;
			components[node] = count;
			if (graph.get(node) != null) {
				for (Integer neighbor : graph.get(node)) {
					dfs(neighbor, graph, visited, count, components);
				}
			}
		}
	}

	public void addNodesInGraph(HashMap<Integer, ArrayList<Integer>> graph, int i) {

		graph.put(i, null);
	}

}
//5
//[[0, 1], [1, 2], [2, 3], [3, 4]]