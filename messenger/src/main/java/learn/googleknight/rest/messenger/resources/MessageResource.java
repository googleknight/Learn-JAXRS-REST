package learn.googleknight.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@GET
	@Path("/{messageId}") // By using {} it tells that part of url as variable and maps it to this method 
	@Produces(MediaType.APPLICATION_XML)
	public Message test(@PathParam("messageId")long messageId) // To use the value passed in url which is mapped to the variable 
	{
		return messageservice.getMessage(messageId);
	}
}
