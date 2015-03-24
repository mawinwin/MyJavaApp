package com.jas.resteasy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/address")
public class AddressService {

	@POST
	@Consumes("application/json")
	public Response create(Address address) {
		if (address != null) {
			System.out.println("Street1=" + address.getStreet1());
			System.out.println("Street2=" + address.getStreet2());
			System.out.println("City=" + address.getCity());
			System.out.println("Province=" + address.getProvince());
			System.out.println("Zipcode=" + address.getZipCode());				
		}
		return Response.status(200).entity(address).build();
	}
	
	@GET
	@Path("/{Street1}")
	@Produces("application/json")
	public Response get(@PathParam("Street1") String street1) {		
		Address address = new Address();
		address.setStreet1(street1);
		address.setStreet2("Street2");
		address.setCity("Pakkret");
		address.setProvince("Nonthaburi");
		address.setZipCode(10200);
		
		return Response.status(200).entity(address).build();
	}
}
