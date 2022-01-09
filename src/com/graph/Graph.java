/**
 * 
 */
package com.graph;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;

import com.hashtable.HashMap;
import com.hashtable.HashMapInterface;
import com.hashtable.HashSetInterface;
import com.linked_list.LinkedListInterface;
import com.utils.PrimaryKey;

public class Graph<K extends Comparable<K>, V extends PrimaryKey<K>> implements GraphInterface<K,V>{

	private HashMapInterface<K, V> vertexlist;
	private HashMapInterface<K, HashSetInterface<K>> edgeList;
	
	public Graph() {
		vertexlist = new HashMap<>();
		edgeList = new HashMap<>();
	}

	@Override
	public void addNode(V element) {
		// add node to vertex list
		vertexlist.put(element.getKey(), element);
	}

	@Override
	public void addEdge(K start, K end) {
		// check if elements exist for given key
		if (vertexlist.get(start) == null)
			throw new RuntimeException("No element stored for key " + start);

		if (vertexlist.get(end) == null)
			throw new RuntimeException("No element stored for key " + end);
		
		// add edge from start to end
		edgeList.get(start).add(end);

		// add edge from end to start
		edgeList.get(end).add(start);
	}

	@Override
	public void removeEdge(K start, K end) {
		// check if elements exist for given key
		if (vertexlist.get(start) == null)
			throw new RuntimeException("No element stored for key " + start);

		if (vertexlist.get(end) == null)
			throw new RuntimeException("No element stored for key " + end);
		
		// remove edge from start to end
		edgeList.get(start).remove(end);

		// remove edge from end to start
		edgeList.get(end).remove(start);
	}

	@Override
	public V removeNode(V element) {
		K key = element.getKey();
		// check if elements exist for given key
		if (vertexlist.get(key) == null)
			return null;
		
		// remove Node
		vertexlist.remove(key);
		
		// get neighbors
	
		K[] neighbors =	edgeList.get(key).values();
		
		// remove mode connections
		edgeList.remove(key);
		
		// remove neighbors connection
		for (K k : neighbors) {
			edgeList.get(k).remove(key);
		}
		
		return element;
	}

	@Override
	public V getNode(K key) {
		return vertexlist.get(key);
	}

	@Override
	public V[] DFS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V[] DFS(V node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V[] BFS() {
		return BFS(((HashMap<K, V>)vertexlist).getFirst(), -2);
	}

	@Override
	public V[] BFS(V node) {
		return BFS(node, -2);
	}

	@Override
	public V[] BFS(V node, int depth) {
		LinkedListInterface<V> result= null; // TODO instance of LL
		HashMapInterface<K, Boolean> isVisited = new HashMap<K, Boolean>();
	
		Queue<K> queue = new LinkedList<>();
		queue.add(node.getKey());
		queue.add(null);
		
		while (!queue.isEmpty() && depth + 1 != 0) {
			K current = queue.remove();
			
			if (current == null && !queue.isEmpty()) {
				// decrease depth
				depth--;
				queue.add(null);
			} else {
				// mark node visited
				if (isVisited.get(current) == false)
					isVisited.put(current, true);
				
				result.add(vertexlist.get(current));
				
				for (K k : edgeList.get(current).values()) {
					queue.add(k);
				} 
			}
		}
		
		@SuppressWarnings("unchecked")
		V[] res = (V[]) Array.newInstance(node.getClass(), result.size());
		
		for (int i = 0; i < res.length; i++) {
			res[i] = result.get(i);
		}
		
		return res;
	}

}
