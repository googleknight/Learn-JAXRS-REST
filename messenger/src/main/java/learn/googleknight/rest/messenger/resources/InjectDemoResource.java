package learn.googleknight.rest.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotations") //Showing various Param annotations
	public String getParamsUsingAnnotations(@MatrixParam("param")String matrixParam,  //for matrix parameters of url, for ex: /annotations:param=value
											@HeaderParam("customHeaderValue")String header,// for parameters in custom headers, for ex: customHeaderValue SomeValue
											@CookieParam("name")String cookie) // for getting parameters sent in cookies
											//another is @FormParam for html forms
	{
											
		return "Matrix param: "+matrixParam+" Header Param: "+header+". Here's a cookie for you:"+cookie;
	}
	@GET
	@Path("context")  //Using Context annotation, info about URI, headers could be accessed
	//Context annotations can only be used with certain special data types like URIInfo, HttpHeaders etc, 
	//unlike other param annotations which work with any data type  
	public String getParamsUsingContext(@Context UriInfo uriinfo,@Context HttpHeaders headers) {
		String path=uriinfo.getAbsolutePath().toString();
		String cookies=headers.getCookies().toString();
		return "Path :"+path+" Cookies:"+cookies;		
	}
}
