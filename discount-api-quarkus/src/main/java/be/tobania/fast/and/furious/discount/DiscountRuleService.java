package be.tobania.fast.and.furious.discount;

import be.tobania.fast.and.furious.discount.model.DiscountRule;


import java.util.List;

public interface DiscountRuleService {
    List<DiscountRule> loadDiscountRules();
}
