package learn.googleknight.rest.messenger.database;

import java.util.HashMap;
import java.util.Map;

import learn.googleknight.rest.messenger.model.Message;
import learn.googleknight.rest.messenger.model.Profile;

public class DatabaseClass {
	//Just a temporary Map to store messages and profiles like in a database 
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
