package be.tobania.fast.and.furious.discount;

import be.tobania.fast.and.furious.discount.model.Basket;
import be.tobania.fast.and.furious.discount.model.Discount;
import org.jboss.resteasy.reactive.RestForm;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/discounts/compute")
public class DiscountRessource {

    @Inject
    DiscountService discountService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Discount> compute(Basket basket) {
        List<Discount> discounts = discountService.computeDiscountsForBasket(basket);
        return discounts;
    }
}
