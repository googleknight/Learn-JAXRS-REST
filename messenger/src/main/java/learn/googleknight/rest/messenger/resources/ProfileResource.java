package learn.googleknight.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import learn.googleknight.rest.messenger.service.ProfileService;
import learn.googleknight.rest.messenger.model.Message;
import learn.googleknight.rest.messenger.model.Profile;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON) // return type method
@Produces(MediaType.APPLICATION_JSON) // input that it accepts
public class ProfileResource {

	ProfileService profileService = new ProfileService();

	@GET
	public List<Profile> getProfiles() {
		return profileService.getAllprofiles();
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addprofile(profile);
	}
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return profileService.getprofile(profileName);
	}
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateprofile(profile);
	}
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName) {
		profileService.removeprofile(profileName);
	}
}
