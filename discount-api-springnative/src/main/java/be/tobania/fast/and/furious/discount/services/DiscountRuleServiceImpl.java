package be.tobania.fast.and.furious.discount.services;

import be.tobania.fast.and.furious.discount.discountrules.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountRuleServiceImpl implements DiscountRuleService {

    @Autowired
    CustomerRewardsRule customerRewardsRule;

    @Autowired
    RedPriceAdjustmentRule redPriceAdjustmentRule;

    @Override
    public List<DiscountRule> loadDiscountRules() {
        List<DiscountRule> rules = new ArrayList<>();
        rules.add(new OnePlusOneFree("COKE4553334"));
        rules.add(new TheSecondIsHalfPrice("FAT34333005"));
        rules.add(customerRewardsRule);
        rules.add(redPriceAdjustmentRule);
        return rules;
    }
}