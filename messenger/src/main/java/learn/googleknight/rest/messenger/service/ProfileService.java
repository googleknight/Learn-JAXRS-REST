package learn.googleknight.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import learn.googleknight.rest.messenger.database.DatabaseClass;

import learn.googleknight.rest.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Shubham",new Profile(1L,"Shubham","Shubham","Mathur"));
	}

	// Service Stubs
	public List<Profile> getAllprofiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getprofile(String profilename) {
		return profiles.get(profilename);
	}

	public Profile addprofile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateprofile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeprofile(String profilename) {
		return profiles.remove(profilename);
	}
}
