package com.social_network;

import com.graph.GraphInterface;
import com.hashtable.HashSetInterface;

public class SocialNetwork {
	private GraphInterface<Integer, User> graph;

	public SocialNetwork() {
		this.graph = null;
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
		displayUsers(graph.BFS());
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
		User[] u = graph.BFS(user, 1);
		u = removeUserFromArray(u, new User[] { user });

		System.out.println("Connection of User " + user.getName() + " :");
		displayUsers(u);
	}

	// Display all mutual connections of users
	public void showMutualConnection(User user1, User user2) {
		// get connections of user 1
		User[] u1 = graph.BFS(user1, 1);
		u1 = removeUserFromArray(u1, new User[] { user1 });

		// get connections of user 2
		User[] u2 = graph.BFS(user2, 1);
		u2 = removeUserFromArray(u2, new User[] { user2 });

		User[] ux = findCommonUsers(u1, u2);

		System.out.println("Connection of User " + user1.getName() + " with User " + user2.getName() + " :");
		displayUsers(ux);
	}

	// Suggest new possible connections for user
	public User[] suggestConnections(User user) {
		User[] userConnections = graph.BFS(user, 1);
		// TODO Initialize Set
		HashSetInterface<User> userSet = null;
		
		// add connection of connection
		User[] userRecommendations = graph.BFS(user, 2);
		for (User u: userRecommendations) {
			userSet.add(u);
		}
		
		// user which are not current connection of users
		return removeUserFromArray(userSet.values(), userConnections);
	}

	// diplay user list
	private void displayUsers(User[] u) {
		for (User user : u) {
			System.out.println(user);
		}
	}

	private User[] findCommonUsers(User[] u1, User[] u2) {
		// TODO Initialize Set
		HashSetInterface<User> userSet = null;
		
		// Add user from both array into set
		for (User user : u1) {
			userSet.add(user);
		}

		for (User user : u1) {
			userSet.add(user);
		}
		
		return userSet.values();
	}

	// remove user from user array
	private User[] removeUserFromArray(User[] fromArray, User[] userArray) {
		User[] u = new User[fromArray.length - userArray.length];
		int count = 0;

		for (int i = 0; i < fromArray.length; i++) {
			for (int j = 0; j < userArray.length; j++) {
				// if in user array try next element
				if (fromArray[i].equals(userArray[j])) {
					i++;
					j = 0;
				}
			}
			u[count++] = fromArray[i];
		}

		return u;
	}

}
