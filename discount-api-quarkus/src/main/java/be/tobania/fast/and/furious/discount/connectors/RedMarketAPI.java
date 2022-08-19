package be.tobania.fast.and.furious.discount.connectors;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/")
@RegisterRestClient(configKey="redmarket-api")
public interface RedMarketAPI {

    @GET
    @Path("/redprices/{productCode}")
    RedPrice getRedPrice(@PathParam String productCode);
}
