package learn.googleknight.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import learn.googleknight.rest.messenger.model.Message;
import learn.googleknight.rest.messenger.service.MessageService;

@Path("/messages") // To map message URI to this particular class
public class MessageResource {

	MessageService messageservice = new MessageService();

	@GET // To map HTTP GET method to this particular method
	@Produces(MediaType.APPLICATION_XML) // To specify the response format // MediaType is a enumerator which specifies
									// the type
	public List<Message> getMessages() {
		return messageservice.getAllMessages();
	}
}
