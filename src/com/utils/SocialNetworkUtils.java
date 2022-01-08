package com.utils;

import com.social_network.Gender;
import com.social_network.SocialNetwork;
import com.social_network.User;

public class SocialNetworkUtils {

	/*
	 * Add user to social network
	 */
	public static void addAUserToNetwork(String name, String gender, SocialNetwork network) throws Exception {
		switch (gender) {
		case "M":
		case "m":
		case "male":
		case "Male":
			network.addUser(new User(name, Gender.MALE));
			break;

		case "F":
		case "f":
		case "female":
		case "Female":
			network.addUser(new User(name, Gender.MALE));
			break;

		default:
			throw new Exception("User Gender is invalid.");
		}
	}

	/*
	 * Remove user if user with id if exist
	 */
	public static void removeAUserToNetwork(int id, SocialNetwork network) throws Exception {
		User u = network.removeUser(id);

		// no user is deleted
		if (u == null)
			throw new Exception("User with id " + id + " does not exist.");
	}

	/*
	 * make connection between two users
	 */
	public static void connectTwoUsers(int firstUid, int secondUid, SocialNetwork network) throws Exception {
		// Verify First User
		User first = network.getUser(firstUid);
		if (first == null)
			throw new Exception("User with id " + firstUid + " does not exist.");

		// Verify Second User
		User second = network.getUser(secondUid);
		if (second == null)
			throw new Exception("User with id " + secondUid + " does not exist.");

		// add a connection
		network.addConnection(first, second);
	}

	/*
	 * remove connection between two users
	 */
	public static void removeConnectionTwoUsers(int firstUid, int secondUid, SocialNetwork network) throws Exception {
		// Verify First User
		User first = network.getUser(firstUid);
		if (first == null)
			throw new Exception("User with id " + firstUid + " does not exist.");

		// Verify Second User
		User second = network.getUser(secondUid);
		if (second == null)
			throw new Exception("User with id " + secondUid + " does not exist.");

		// add a connection
		network.removeConnection(first, second);
	}

	/*
	 * List all available users in a network
	 */
	public static void listAllConnectionsOfUser(int id, SocialNetwork network) throws Exception {
		// Verify User
		User u = network.getUser(id);
		if (u == null)
			throw new Exception("User with id " + id + " does not exist.");

		network.showConnection(u);
	}

	/*
	 * List mutual friends of two users
	 */
	public static void listMutualConnectionOfUsers(int firstUid, int secondUid, SocialNetwork network)
			throws Exception {
		// Verify First User
		User first = network.getUser(firstUid);
		if (first == null)
			throw new Exception("User with id " + firstUid + " does not exist.");

		// Verify Second User
		User second = network.getUser(secondUid);
		if (second == null)
			throw new Exception("User with id " + secondUid + " does not exist.");

		network.showMutualConnection(first, second);
	}

	/*
	 * Suggest new connection for given user
	 */
	public static void suggestNewConnections(int id, SocialNetwork network) throws Exception {
		// Verify User
		User u = network.getUser(id);
		if (u == null)
			throw new Exception("User with id " + id + " does not exist.");

		network.suggestConnections(u);
	}

}
