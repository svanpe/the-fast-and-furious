package be.tobania.fast.and.furious.discount;


import be.tobania.fast.and.furious.discount.model.Basket;
import be.tobania.fast.and.furious.discount.model.Discount;
import be.tobania.fast.and.furious.discount.model.DiscountRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DiscountServiceImpl implements DiscountService {

    Logger logger = LoggerFactory.getLogger(DiscountServiceImpl.class);

    @Inject
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