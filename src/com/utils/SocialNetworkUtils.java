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
			network.addUser(new User(name, Gender.FEMALE));
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

	public static void populateNetwork(SocialNetwork network) throws Exception {
		// Addding 26 new users
		addAUserToNetwork("Mona", "F", network);
		addAUserToNetwork("Scott", "M", network);
		addAUserToNetwork("Jimmy", "M", network);
		addAUserToNetwork("Darryl", "M", network);
		addAUserToNetwork("Elbert", "M", network);
		addAUserToNetwork("Amber", "F", network);
		addAUserToNetwork("Paula", "F", network);
		addAUserToNetwork("Rochelle", "F", network);
		addAUserToNetwork("Vera", "F", network);
		addAUserToNetwork("Rosemarie", "F", network);
		addAUserToNetwork("Mindy", "F", network);
		addAUserToNetwork("Jorge", "M", network);
		addAUserToNetwork("Gladys", "M", network);
		addAUserToNetwork("Larry", "M", network);
		addAUserToNetwork("Sue", "F", network);
		addAUserToNetwork("Micheal", "M", network);
		addAUserToNetwork("Kellie", "F", network);
		addAUserToNetwork("Jack", "M", network);
		addAUserToNetwork("Donald", "M", network);
		addAUserToNetwork("Ida", "F", network);
		addAUserToNetwork("Albert", "M", network);
		addAUserToNetwork("Rita", "F", network);
		addAUserToNetwork("Darla", "F", network);
		addAUserToNetwork("Judith", "F", network);
		addAUserToNetwork("Hannah", "F", network);
		addAUserToNetwork("Jake", "M", network);
		addAUserToNetwork("Clifton", "M", network);

		// 61 connections between 26 Users
		connectTwoUsers(8, 2, network);
		connectTwoUsers(4, 14, network);
		connectTwoUsers(25, 20, network);
		connectTwoUsers(4, 22, network);
		connectTwoUsers(13, 24, network);
		connectTwoUsers(2, 12, network);
		connectTwoUsers(6, 16, network);
		connectTwoUsers(17, 18, network);
		connectTwoUsers(1, 6, network);
		connectTwoUsers(18, 20, network);
		connectTwoUsers(18, 3, network);
		connectTwoUsers(23, 24, network);
		connectTwoUsers(6, 15, network);
		connectTwoUsers(10, 13, network);
		connectTwoUsers(6, 21, network);
		connectTwoUsers(12, 13, network);
		connectTwoUsers(10, 14, network);
		connectTwoUsers(10, 22, network);
		connectTwoUsers(13, 23, network);
		connectTwoUsers(13, 14, network);
		connectTwoUsers(1, 8, network);
		connectTwoUsers(1, 2, network);
		connectTwoUsers(9, 14, network);
		connectTwoUsers(17, 16, network);
		connectTwoUsers(11, 2, network);
		connectTwoUsers(9, 2, network);
		connectTwoUsers(5, 3, network);
		connectTwoUsers(22, 23, network);
		connectTwoUsers(19, 2, network);
		connectTwoUsers(5, 4, network);
		connectTwoUsers(6, 4, network);
		connectTwoUsers(2, 3, network);
		connectTwoUsers(25, 4, network);
		connectTwoUsers(20, 5, network);
		connectTwoUsers(17, 11, network);
		connectTwoUsers(10, 12, network);
		connectTwoUsers(8, 9, network);
		connectTwoUsers(8, 12, network);
		connectTwoUsers(26, 8, network);
		connectTwoUsers(16, 18, network);
		connectTwoUsers(5, 19, network);
		connectTwoUsers(18, 19, network);
		connectTwoUsers(2, 5, network);
		connectTwoUsers(10, 4, network);
		connectTwoUsers(14, 24, network);
		connectTwoUsers(1, 7, network);
		connectTwoUsers(12, 14, network);
		connectTwoUsers(14, 22, network);
		connectTwoUsers(8, 7, network);
		connectTwoUsers(4, 9, network);
		connectTwoUsers(5, 25, network);
		connectTwoUsers(8, 10, network);
		connectTwoUsers(25, 19, network);
		connectTwoUsers(6, 3, network);
		connectTwoUsers(25, 9, network);
		connectTwoUsers(25, 22, network);
		connectTwoUsers(9, 5, network);
		connectTwoUsers(18, 11, network);
		connectTwoUsers(16, 3, network);
		connectTwoUsers(9, 10, network);
		connectTwoUsers(2, 4, network);

	}

}
