 
package kunderTest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;


@Path("RestApi")
public class RestApi {
	/**
     * Default constructor. 
     */
    public RestApi() {
        // TODO Auto-generated constructor stub
    	System.out.print("\"Hello\"");
    }


    /**
     * Retrieves representation of an instance of RestApi
     * @return an instance of String
     */
	@GET
	@Produces("text/plain")
	public String resourceMethodGET() { 
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
     * PUT method for updating or creating an instance of RestApi
     * @content content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
	@PUT
	@Consumes("text/plain")
	public void resourceMethodPUT(String content) { 
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/word")
    public Response word(@QueryParam("data") String word)
    {
		
		if ((word == null) || (word.length() != 4)){
			return Response.status(Status.BAD_REQUEST).build();
		}
		JsonObject json = (JsonObject) Json.createObjectBuilder().add("status", "200")
				.add("code", "OK")
				.add("word", word.toUpperCase()).build();
        return Response.ok(json).build();
    }
	
	/*
	 * 
	 * Accepts a number in UNIX format and returns it in UTC.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/time")
	public Response time(@QueryParam("value") String value){
		
		if(value.matches("[0-9]+")){
			
			long val = Long.parseLong(value);
			Date date = new Date(val*1000L);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
			
			JsonObject json = (JsonObject) Json.createObjectBuilder().add("status", "200")
					.add("code", "OK")
					.add("data", sdf.format(date)).build();
			
			return Response.ok(json).build();
			
		}else{
			return Response.status(Status.BAD_REQUEST).build();			
		}

		
		
	}
	
}