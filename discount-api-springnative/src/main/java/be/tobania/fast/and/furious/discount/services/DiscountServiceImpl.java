package be.tobania.fast.and.furious.discount.services;


import be.tobania.fast.and.furious.discount.discountrules.Discount;
import be.tobania.fast.and.furious.discount.discountrules.DiscountRule;
import be.tobania.fast.and.furious.discount.model.Basket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DiscountServiceImpl implements DiscountService {

    Logger logger = LoggerFactory.getLogger(DiscountServiceImpl.class);

    @Autowired
    DiscountRuleService discountRuleService;

    public List<Discount> computeDiscountsForBasket(Basket basket) {
        List<Discount> discounts = new ArrayList<>();
        List<DiscountRule> discountRules = discountRuleService.loadDiscountRules();

        for (DiscountRule rule : discountRules) {
            discounts.addAll(rule.computeDiscount(basket));
        }

        return discounts;
    }
}