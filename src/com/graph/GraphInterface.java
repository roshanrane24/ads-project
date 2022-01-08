package com.graph;

public interface GraphInterface<T> {
	public void addNode(T element);

	public void addEdge(int start, int end);

	public T[] getNeighbours(T node);

	public T[] DFS(T node);

	public T[] BFS(T node, int depth);
}
