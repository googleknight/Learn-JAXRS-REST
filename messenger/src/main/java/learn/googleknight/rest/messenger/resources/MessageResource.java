package learn.googleknight.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import learn.googleknight.rest.messenger.model.Message;
import learn.googleknight.rest.messenger.service.MessageService;

@Path("/messages") // To map message URI to this particular class
public class MessageResource {

	MessageService messageservice = new MessageService();
	//Message Body writer converts message into JSON/XML which is added in dependencies
	
	@GET // To map HTTP GET method to this particular method
	@Produces(MediaType.APPLICATION_JSON) // To specify the response format // MediaType is a enumerator which specifies
									// the type
	public List<Message> getMessages() {
		return messageservice.getAllMessages();
	}
	
	@POST //To map HTTP POST method to this particular method
	@Consumes(MediaType.APPLICATION_JSON)//return type of POST method
	@Produces(MediaType.APPLICATION_JSON)//input that it accepts
	public Message addMessage(Message message) {
		return messageservice.addMessage(message);
	}

	@GET
	@Path("/{messageId}") // By using {} it tells that part of url as variable and maps it to this method
	@Produces(MediaType.APPLICATION_JSON)
	public Message test(@PathParam("messageId") long messageId) // To use the value passed in url which is mapped to the
																// variable
	{// Can handle multiple params, with different type too even regex
		return messageservice.getMessage(messageId);
	}
}
