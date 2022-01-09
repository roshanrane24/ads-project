package com.graph;

import com.utils.PrimaryKey;

public interface GraphInterface<K, V extends PrimaryKey<K>> {
	public void addNode(V element);

	public void addEdge(K start, K end);

	public void removeEdge(K start, K end);
	
	public V removeNode(V element);
	
	public V getNode(K key);
	
	public V[] DFS();

	public V[] DFS(V node);

	public V[] BFS();
	
	public V[] BFS(V node);
	
	public V[] BFS(V node, int depth);
}
