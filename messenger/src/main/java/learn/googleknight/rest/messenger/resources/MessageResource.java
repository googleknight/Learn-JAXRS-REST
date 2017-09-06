package learn.googleknight.rest.messenger.resources;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import learn.googleknight.rest.messenger.model.Message;
import learn.googleknight.rest.messenger.service.MessageService;

@Path("/messages") // To map message URI to this particular class
@Consumes(MediaType.APPLICATION_JSON) // return type method
@Produces(MediaType.APPLICATION_JSON) // input that it accepts
public class MessageResource {

	MessageService messageservice = new MessageService();
	// Message Body writer converts message into JSON/XML which is added in
	// dependencies

	@GET // To map HTTP GET method to this particular method
	public List<Message> getMessages(@QueryParam("year") int year,
									@QueryParam("start") int start,
									@QueryParam("size") int size
									) {  // For getting query parameter if exists
		if(year>0) {
			return messageservice.getAllMessagesForYear(year);
		}
		if(start>0 &&size>0)
		{
			return messageservice.getAllMessagesPaginated(start, size);
		}
		return messageservice.getAllMessages();
	}

	@POST
	public Message addMessage(Message message) {
		return messageservice.addMessage(message);
	}

	@PUT
	@Path("/{messageId}") // By using {} it tells that part of url as variable and maps it to this method
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		System.out.println(message.getId());
		return messageservice.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long messageId) {
		messageservice.removeMessage(messageId);
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId) {// Can handle multiple params, with different
																		// type too even regex
		return messageservice.getMessage(messageId);
	}
}
