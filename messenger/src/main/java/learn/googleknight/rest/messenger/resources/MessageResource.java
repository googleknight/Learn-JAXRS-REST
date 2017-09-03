package learn.googleknight.rest.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messages") // To map message URI to this particular class
public class MessageResource {
	@GET // To map HTTP GET method to this particular method
	@Produces(MediaType.TEXT_PLAIN) // To specify the response format // MediaType is a enumerator which specifies
									// the type
	public String getMessages() {
		return "Hello World!!!!";
	}
}
