package cn.edu.bupt.sdmda.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphAlgorithm {

	// double[][] graph = new double[][]{
	// {0, 34, 46, -1,-1,19},
	// {34,0,-1,-1,12,-1},
	// {46,-1,0,17,-1,25},
	// {-1,-1,17,0,38,25},
	// {-1,12,-1,38,0,26},
	// {19,-1,25,25,26,0}
	// };

	public static void dfs(double[][] graph, int start) {
		// init an array of int to indicate which vertex is visited
		int[] visited = new int[graph.length];

		// start dfs recursively
		_dfs(graph, start, visited);
	}

	// dfs recursively
	private static void _dfs(double[][] graph, int start, int[] visited) {
		// print current vertex
		System.out.print(start + " ");
		visited[start] = 1;
		// find next available vertex and dfs on it
		for (int i = 0; i < graph[start].length; i++) {
			if (graph[start][i] > 0 && visited[i] != 1) {
				visited[i] = 1;
				_dfs(graph, i, visited);
			}
		}
	}

	public static void bfs(double[][] graph, int start) {
		// init an array of int to indicate which vertex is visited
		int[] visited = new int[graph.length];
		visited[start] = 1;
		// build a queue and push start to it
		// change LinkedList to your own implementation
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offer(start);
		// loop while queue is empty
		while (queue.size() > 0) {
			// pop and print a vertex,
			int cur = queue.poll();
			System.out.print(cur + " ");
			// then push its available next vertex to the queue
			for (int i = 0; i < graph[start].length; i++) {
				if (graph[cur][i] > 0 && visited[i] != 1) {
					queue.offer(i);
					visited[i] = 1;
				}
			}
		}
	}

	public static double[][] prim(double[][] graph) {
		// init a double[][] for return
		// init U and V
		double[][] ret = new double[graph.length][graph.length];
		for (int i = 0; i < ret.length; i++)
			for (int j = 0; j < ret.length; j++) {
				if (i == j)
					ret[i][j] = 0;
				else
					ret[i][j] = -1;
			}
		List<Integer> U = new ArrayList<>();
		List<Integer> V = new ArrayList<>();
		U.add(0);
		for (int i = 1; i < graph.length; i++)
			V.add(i);
		// loop while V is not empty
		while (!V.isEmpty()) {
			double min = 0;
			int u = -1, v = -1;
			for (int i = 0; i < U.size(); i++) {
				for (int j = 0; j < V.size(); j++) {
					if ((graph[U.get(i)][V.get(j)] > 0) && (min == 0 || graph[U.get(i)][V.get(j)] < min)) {
						min = graph[U.get(i)][V.get(j)];
						u = U.get(i);
						v = V.get(j);
					}
				}
			}
			ret[u][v] = min;
			ret[v][u] = min;
			V.remove(V.indexOf(v));
			U.add(v);
			// loop on each vertex in U
			// find closest path from U to V(u-->v)
			// move v to U
		}

		return ret;
	}

	public static double[][] kruskal(double[][] graph) {
		// construct a list of edge from graph, and sort it
		List<Edge> edges = null;

		// init a array represent the root of each vertex
		int[] root = null;

		// init a double[][] for return
		double[][] ret = null;

		// loop on edges

		// check if the roots of two vertex of this edge the same
		// if is same, continue
		// if not, modify the double[][] for return
		// and update root

		return ret;
	}

	// get root of a vertex
	private static int _getRoot(int[] root, int query) {
		return 0;
	}

	// a simple class to represent edge
	// it is comparable to itself
	static class Edge implements Comparable<Edge> {
		int v1, v2;
		double weight;

		public Edge(int v1, int v2, double w) {
			this.v1 = v1 < v2 ? v1 : v2;
			this.v2 = v1 < v2 ? v2 : v1;
			weight = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

	public static double dijkstra(double[][] graph, int start, int end) {
		int len = graph.length;// init U and V
		List<Integer> U = new ArrayList();
		List<Integer> V = new ArrayList();
		U.add(start);
		for (int i = 1; i < len; i++) {
			V.add(i);
		}
		// init an array indicating the shortest distance from start to each vertex
		double[] distance = new double[len];
		for (int i = 0; i < len; i++) {
			distance[i] = -1;
		}
		distance[start] = 0;
		// loop if end is not in U

		// find shortest path from U to V (u--v)
		// update distance, U ,V

		while (!U.contains(end)) {
			double min = -1;
			int ming = -1;
			for (int i = 0; i < U.size(); i++) {
				int index = U.get(i);
				for (int j = 0; j < graph.length; j++) {
					if ((!U.contains(j)) && graph[index][j] != -1) {
						if (ming == -1 | min > (graph[index][j] + distance[index])) {
							min = graph[index][j] + distance[index];
							ming = j;
						}
					}
				}
			}
			distance[ming] = min;

			U.add(ming);
			for (int i = 0; i < V.size(); i++) {
				if (ming == V.get(i)) {
					V.remove(i);
				}
			}
		}

		return distance[end];
	}

}
