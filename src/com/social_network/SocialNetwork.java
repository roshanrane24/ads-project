package com.social_network;

import com.graph.GraphInterface;

public class SocialNetwork {
	private GraphInterface<User> graph;

	public SocialNetwork(GraphInterface<User> graph) {
		this.graph = graph;
	}
	
	public void addUser(User user) {
	}
	
	public User removeUser() {
		return null;
	}
	
	public void listUsers() {
		
	}
	
	public User getUser(int id) {
		return null;
	}
	
	public void addFriends(User first, User Second) {
		
	}

	public void removeFriends(User first, User Second) {
		
	}
}
