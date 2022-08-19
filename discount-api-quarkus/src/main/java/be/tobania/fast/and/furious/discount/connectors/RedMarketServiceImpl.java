package be.tobania.fast.and.furious.discount.connectors;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.jboss.logging.Logger;

@ApplicationScoped
public class RedMarketServiceImpl implements RedMarketService{

    private static final Logger LOG = Logger.getLogger(RedMarketServiceImpl.class);

    @Inject
    @RestClient
    RedMarketAPI redMarketAPI;


    @Override
    public RedPrice getRedPrice(String productCode) {
        try{
            return redMarketAPI.getRedPrice(productCode);

        } catch(ResteasyWebApplicationException resteasyWebApplicationException){
            if(resteasyWebApplicationException.unwrap().getResponse().getStatus()==404){
                LOG.debug(productCode + " : " + resteasyWebApplicationException.unwrap().getResponse().readEntity(String.class));
                return null;
            } else {
                LOG.error(resteasyWebApplicationException.unwrap().getResponse().readEntity(String.class),resteasyWebApplicationException);
                throw resteasyWebApplicationException;
            }
        }

    }
}
