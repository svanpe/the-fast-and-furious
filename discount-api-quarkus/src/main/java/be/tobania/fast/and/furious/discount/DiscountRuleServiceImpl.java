package be.tobania.fast.and.furious.discount;

import be.tobania.fast.and.furious.discount.model.DiscountRule;
import be.tobania.fast.and.furious.discount.rules.OnePlusOneFree;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DiscountRuleServiceImpl implements DiscountRuleService {



    @Override
    public List<DiscountRule> loadDiscountRules() {
        List<DiscountRule> rules = new ArrayList<>();
        rules.add(new OnePlusOneFree("COKE4553334"));
       // rules.add(new TheSecondIsHalfPrice("FAT34333005"));
        //rules.add(customerRewardsRule);
        //rules.add(redPriceAdjustmentRule);
        return rules;
    }
}