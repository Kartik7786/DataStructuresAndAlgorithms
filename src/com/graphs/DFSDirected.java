package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSDirected {

	static class Edge {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	static void dfs(int at, boolean[] visited, Map<Integer, List<Edge>> graph) {

		// We have already visited this node
		if (visited[at])
			return;

		// Visit this node
		visited[at] = true;
		System.out.println(at + "->");

		// Visit all edges adjacent to where we're at
		List<Edge> edges = graph.get(at);
		if (edges != null) {
			for (Edge edge : edges) {
				dfs(edge.to, visited, graph);
			}
		}

	}

	private static void addDirectedEdge(Map<Integer, List<Edge>> graph, int from, int to, int cost) {
		List<Edge> list = graph.get(from);
		if (list == null) {
			list = new ArrayList<Edge>();
			graph.put(from, list);
		}
		list.add(new Edge(from, to, cost));
	}

	public static void main(String[] args) {

		int numNodes = 5;
		boolean[] visited = new boolean[5];
		Map<Integer, List<Edge>> graph = new HashMap<>();
		addDirectedEdge(graph, 0, 1, 4);
		addDirectedEdge(graph, 0, 2, 5);
		addDirectedEdge(graph, 1, 2, -2);
		addDirectedEdge(graph, 1, 3, 6);
		addDirectedEdge(graph, 2, 3, 1);
		addDirectedEdge(graph, 2, 2, 10); // Self loop
		dfs(0, visited, graph);

	}

}
