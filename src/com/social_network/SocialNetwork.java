package com.social_network;

import com.graph.GraphInterface;

public class SocialNetwork {
	private GraphInterface<User> graph;

	public SocialNetwork() {
		this.graph = null;
	}
	
	// add a user in network
	public void addUser(User user) {
	}
	
	// remove a user in network
	public User removeUser(int id) {
		return null;
	}
	
	// show all users in network
	public void listUsers() {
		
	}
	
	// get a user by Id
	public User getUser(int id) {
		return null;
	}
	
	// add connection between 2 users in network
	public void addConnection(User first, User Second) {
		
	}

	// remove connection between 2 users in network
	public void removeConnection(User first, User Second) {
		
	}
	
	// Display all connections of user
	public void showConnection(User user) {
		
	}

	// Display all mutual connections of users
	public void showMutualConnection(User user1, User user2) {
		
	}
	
	// Suggest new possible connections for user
	public User[] suggestConnections(User user) {
		return null;
	}
}
