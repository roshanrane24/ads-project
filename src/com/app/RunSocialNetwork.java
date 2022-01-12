package com.app;

import static com.utils.SocialNetworkUtils.*;

import java.util.Scanner;

import com.social_network.SocialNetwork;

public class RunSocialNetwork {

	private static SocialNetwork network;

	public static void main(String[] args) {

		network = new SocialNetwork();

		boolean exit = false;

		try (Scanner sc = new Scanner(System.in)) {

			// test graph
			populateNetwork(network);

			while (!exit) {
				try {
					// Display menu & get user selection
					menu();
					int choice = sc.nextInt();

					int id;

					switch (choice) {

					// Display all Users
					case 1:
						network.listUsers();
						break;

					// Add a new User
					case 2:
						// get username & gender
						System.out.print("Enter User Name : ");
						sc.nextLine();
						String name = sc.nextLine();

						System.out.print("Enter User Gender [M/F] : ");
						String gender = sc.next();

						// verify details & add user
						addAUserToNetwork(name, gender, network);
						break;

					// Remove a User
					case 3:
						// get uid & remove user
						System.out.print("Enter User Id to delete user : ");
						id = sc.nextInt();
						removeAUserToNetwork(id, network);
						break;

					// Add connections between two users
					case 4:
						// Get uid of two users which you want to connect
						System.out.println("Enter user id of two users : ");
						connectTwoUsers(sc.nextInt(), sc.nextInt(), network);
						break;

					// Remove connections between two users
					case 5:
						// Get uid of two users which you want to remove connect
						System.out.println("Enter user id of two users : ");
						removeConnectionTwoUsers(sc.nextInt(), sc.nextInt(), network);
						break;

					// Show all connection of user
					case 6:
						// get user id from user & if available display connections
						System.out.print("Enter User Id : ");
						id = sc.nextInt();
						listAllConnectionsOfUser(id, network);
						break;

					// Show mutual connection of two users
					case 7:
						// get user id for users
						System.out.println("Enter user id of two users : ");

						// if both user exist display mutual connection
						listMutualConnectionOfUsers(sc.nextInt(), sc.nextInt(), network);
						break;

					// Suggest Connections for a user
					case 8:
						// get user id from user & if available display possible connections
						System.out.print("Enter User Id : ");
						id = sc.nextInt();
						suggestNewConnections(id, network);
						break;
					case 9:
						exit = true;
						break;
					default: // For Invalid Choice
						System.err.println("Invalid Choice");
						break;
					}
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				sc.nextLine();

			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	private static void menu() {
		System.out.println("1 -> Display All Users");
		System.out.println("2 -> Add a User.");
		System.out.println("3 -> Remove a User");
		System.out.println("4 -> Connect Two Users");
		System.out.println("5 -> Remove Connection of Two Users");
		System.out.println("6 -> Show Connections of a User");
		System.out.println("7 -> Show Mutual Connection of Two Users");
		System.out.println("8 -> Suggest Connection to a User");
		System.out.println("9 -> Exit");
		System.out.print("  -> ");

	}

}
