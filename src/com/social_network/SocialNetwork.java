package com.social_network;

import com.graph.Graph;
import com.graph.GraphInterface;
import com.hashtable.HashSetInterface;
import com.hashtable.HashSett;

public class SocialNetwork {
	private GraphInterface<Integer, User> graph;

	public SocialNetwork() {
		this.graph = new Graph<>();
	}

	// add a user in network
	public void addUser(User user) {
		graph.addNode(user);
	}

	// remove a user in network
	public User removeUser(int id) {
		User u = this.getUser(id);

		// when user found
		if (u != null) {
			graph.removeNode(u);
		}

		return null;
	}

	// show all users in network
	public void listUsers() {
		displayUsers(((Graph<Integer, User>) graph).getVertexlist());
	}

	// get a user by Id
	public User getUser(int id) {
		return graph.getNode(id);
	}

	// add connection between 2 users in network
	public void addConnection(User first, User Second) {
		graph.addEdge(first.getKey(), Second.getKey());
	}

	// remove connection between 2 users in network
	public void removeConnection(User first, User Second) {
		graph.removeEdge(first.getKey(), Second.getKey());
	}

	// Display all connections of user
	public void showConnection(User user) {
		// get connections of user
		User[] u = graph.BFS(user, 2);
		u = removeUserFromArray(u, new User[] { user });

		System.out.println("Connection of User " + user.getName() + " :");
		displayUsers(u);
	}

	// Display all mutual connections of users
	public void showMutualConnection(User user1, User user2) {
		// get connections of user 1
		User[] u1 = graph.BFS(user1, 2);
		u1 = removeUserFromArray(u1, new User[] { user1 });

		// get connections of user 2
		User[] u2 = graph.BFS(user2, 2);
		u2 = removeUserFromArray(u2, new User[] { user2 });

		User[] ux = findCommonUsers(u1, u2);

		System.out.println("Connection of User " + user1.getName() + " with User " + user2.getName() + " :");
		displayUsers(ux);
	}

	// Suggest new possible connections for user
	public void suggestConnections(User user) {
		User[] userConnections = graph.BFS(user, 2);
		HashSetInterface<User> userSet = new HashSett<>();

		// add connection of connection
		User[] userRecommendations = graph.BFS(user, 3);
		for (User u : userRecommendations) {
			userSet.add(u);
		}

		// user which are not current connection of users
		displayUsers(removeUserFromArray(userSet.values(), userConnections));
	}

	// diplay user list
	private void displayUsers(User[] u) {
		if (u == null)
			return;

		for (User user : u) {
			System.out.println(user);
		}
	}

	private User[] findCommonUsers(User[] u1, User[] u2) {
		HashSetInterface<User> userSet = new HashSett<>();
		HashSetInterface<User> resultSet = new HashSett<>();

		// Add user from both array into set
		for (User user : u1) {
			userSet.add(user);
		}

		for (User user : u2) {
			if (userSet.contains(user))
				resultSet.add(user);
		}

		return resultSet.values();
	}

	// remove user from user array
	private User[] removeUserFromArray(User[] fromArray, User[] userArray) {
		User[] u = new User[fromArray.length - userArray.length];
		if (u.length < 1)
			return null;

		int count = 0;

		for (int i = 0; i < fromArray.length; i++) {
			for (int j = 0; j < userArray.length && i < fromArray.length; j++) {
				// if in user array try next element
				if (fromArray[i].equals(userArray[j])) {
					i++;
					j = 0;
				}
			}
			if (i < fromArray.length)
				u[count++] = fromArray[i];
		}

		return u;
	}

}
