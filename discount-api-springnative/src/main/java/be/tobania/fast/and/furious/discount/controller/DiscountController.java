package be.tobania.fast.and.furious.discount.controller;

import be.tobania.fast.and.furious.discount.discountrules.Discount;
import be.tobania.fast.and.furious.discount.model.Basket;
import be.tobania.fast.and.furious.discount.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("discounts")
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @PostMapping("compute")
    public @ResponseBody
    List<Discount> computeDiscountsForBasket(@RequestBody Basket basket) {
        List<Discount> discounts = discountService.computeDiscountsForBasket(basket);
        return discounts;
    }
}