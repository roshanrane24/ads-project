/**
 * 
 */
package com.graph;

import static com.utils.CommonUtils.squashArray;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.hashtable.HashMap;
import com.hashtable.HashMapInterface;
import com.hashtable.HashSetInterface;
import com.hashtable.HashSett;
import com.utils.PrimaryKey;

@SuppressWarnings("serial")
public class Graph<K extends Comparable<K>, V extends PrimaryKey<K>> implements GraphInterface<K, V>, Serializable {

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

		// check if index start and end element initialized
		HashSetInterface<K> set1 = edgeList.get(start);

		if (set1 == null)
			edgeList.put(start, new HashSett<>());

		HashSetInterface<K> set2 = edgeList.get(end);

		if (set2 == null)
			edgeList.put(end, new HashSett<>());

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

		// check if index start and end element initialized
		HashSetInterface<K> set1 = edgeList.get(start);

		if (set1 == null)
			throw new RuntimeException("No edges are stored for node " + start);

		HashSetInterface<K> set2 = edgeList.get(end);

		if (set2 == null)
			throw new RuntimeException("No edges are stored for node " + start);

		// remove edge from start to end
		edgeList.get(start).remove(end);

		// remove edge from end to start
		edgeList.get(end).remove(start);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V removeNode(V element) {
		K key = element.getKey();
		// check if elements exist for given key
		if (vertexlist.get(key) == null)
			return null;

		// remove Node
		vertexlist.remove(key);

		// get neighbors

		Object[] neighbors = edgeList.get(key).values();

		// remove mode connections
		edgeList.remove(key);

		// remove neighbors connection
		for (Object k : neighbors) {
			edgeList.get((K) k).remove(key);
		}

		return element;
	}

	@Override
	public V getNode(K key) {
		return vertexlist.get(key);
	}

	@Override
	public V[] BFS() {
		V node = ((HashMap<K, V>) vertexlist).getFirst();

		if (node == null)
			return null;

		return BFS(node, -2);
	}

	@Override
	public V[] BFS(V node) {
		return BFS(node, -2);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V[] BFS(V node, int depth) {
		// Store result
		V[] result = null;
		int count = 0;

		// map to check is node visited
		HashMapInterface<K, Boolean> isVisited = new HashMap<K, Boolean>();
		K[] keys = vertexlist.keys();

		for (int i = 0; i < keys.length; i++) {
			isVisited.put(keys[i], false);
		}

		result = (V[]) Array.newInstance(vertexlist.get(keys[0]).getClass(), vertexlist.size());

		// create & add node to queue
		Queue<K> queue = new LinkedList<>();
		queue.add(node.getKey());

		// add null to queue to indicate end of depth
		queue.add(null);

		// until queue is empty
		while (!queue.isEmpty()) {
			// get element from queue
			K current = queue.remove();

			// check depth
			if (depth == 0)
				break;

			// when within depth
			if (current != null) {
				if (!isVisited.get(current)) {
					// mark current visited
					isVisited.put(current, true);

					// process node
					result[count++] = vertexlist.get(current);

					// get next edges
					HashSetInterface<K> edgeSet = edgeList.get(current);

					if (edgeSet != null) {
						Object[] edges = edgeSet.values();
						Arrays.sort(edges);
						for (int i = 0; i < edges.length; i++) {
							if (!isVisited.get((K) edges[i]))
								queue.add((K) edges[i]);
						}
					}
				}

			} else {
				// decrease depth
				depth--;
				// to check last depth
				if (!queue.isEmpty())
					queue.add(null);
			}

		}
		return squashArray(result, vertexlist.get(keys[0]).getClass());
	}

	public V[] getVertexlist() {
		return vertexlist.values();
	}

}
