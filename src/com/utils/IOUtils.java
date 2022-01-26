package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.social_network.SocialNetwork;

public interface IOUtils {
	String PATH = "saved_network";

	static void saveNetwork(SocialNetwork network) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH))) {
			oos.writeObject(network);
		}

		System.out.println("Written to file " + PATH);

	}

	static SocialNetwork loadNetwork() throws FileNotFoundException, IOException {
		SocialNetwork network = null;

		File f = new File(PATH);
		if (f.exists() && f.isFile() && f.canRead()) {

			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH))) {
				Object obj = ois.readObject();
				if (obj instanceof SocialNetwork)
					network = (SocialNetwork) obj;
				System.out.println("Data Loaded");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} else
			throw new FileNotFoundException("Invalid File Name.");
		return network;
	}

}
