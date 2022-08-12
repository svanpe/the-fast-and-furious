package be.tobania.fast.and.furious.discount;

import be.tobania.fast.and.furious.discount.model.Basket;
import be.tobania.fast.and.furious.discount.model.Discount;


import java.util.List;

public interface DiscountService {

    List<Discount> computeDiscountsForBasket(Basket basket);
}
