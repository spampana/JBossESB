package com.cbeyond.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
@WebService()
public interface DemoService {

	@GET
	@WebMethod
	@Path("/hello/{user_name}")
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	@WebResult(name="message")
	public String getHelloString(@PathParam("user_name") @WebParam(name="UserName") String name);
	
	@GET
	@WebMethod
	@Path("/greeting/{user_name}")
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	@WebResult(name="message")
	public String getGreeetingString(@PathParam("user_name") @WebParam(name="UserName") String name);

}
