package be.tobania.fast.and.furious.discount.services;



import be.tobania.fast.and.furious.discount.discountrules.DiscountRule;

import java.util.List;

public interface DiscountRuleService {
    List<DiscountRule> loadDiscountRules();
}
