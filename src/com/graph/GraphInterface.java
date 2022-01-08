package com.graph;

import com.utils.PrimaryKey;

public interface GraphInterface<U, T extends PrimaryKey<U>> {
	public void addNode(T element);

	public void addEdge(U start, U end);

	public void removeEdge(U start, U end);
	
	public T removeNode(T element);
	
	public T getNode(U key);
	
	public T[] DFS();

	public T[] DFS(T node);

	public T[] BFS();
	
	public T[] BFS(T node);
	
	public T[] BFS(T node, int depth);
}
