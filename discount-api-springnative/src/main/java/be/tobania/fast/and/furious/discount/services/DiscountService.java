package be.tobania.fast.and.furious.discount.services;

import be.tobania.fast.and.furious.discount.discountrules.Discount;
import be.tobania.fast.and.furious.discount.model.Basket;

import java.util.List;

public interface DiscountService {

    List<Discount> computeDiscountsForBasket(Basket basket);
}
