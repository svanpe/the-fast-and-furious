package be.tobania.fast.and.furious.discount.discountrules;

import be.tobania.fast.and.furious.discount.connectors.rewards.CustomerNotFoundException;
import be.tobania.fast.and.furious.discount.connectors.rewards.CustomerRewards;
import be.tobania.fast.and.furious.discount.connectors.rewards.CustomerRewardsService;
import be.tobania.fast.and.furious.discount.connectors.rewards.RewardingLevel;
import be.tobania.fast.and.furious.discount.model.Basket;

import be.tobania.fast.and.furious.discount.model.Purchase;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static be.tobania.fast.and.furious.discount.connectors.rewards.RewardingLevel.*;

@Component
public class CustomerRewardsRule extends DiscountRule {

    Logger logger = LoggerFactory.getLogger(CustomerRewardsRule.class);

    private CustomerRewardsService customerRewardsService;

    private static Map<RewardingLevel, BigDecimal> discountRatePerLevel = Map.of(
            BRONZE, new BigDecimal("0.02"),
            SILVER, new BigDecimal("0.05"),
            GOLD, new BigDecimal("0.08"));

    public CustomerRewardsRule() {
        super("Customer Rewarding Discount");
    }

    @Autowired
    public void setCustomerRewardsService(CustomerRewardsService customerRewardsService) {
        this.customerRewardsService = customerRewardsService;
    }

    @Override
    public List<Discount> computeDiscount(Basket basket) {
        List<Discount> discounts = new ArrayList<>();
        if (StringUtils.isNotEmpty(basket.getCustomerIdentifier())) {
            CustomerRewards rewards = null;
            try {
                rewards = customerRewardsService.retrieveCustomerRewards(basket.getCustomerIdentifier());
            } catch (CustomerNotFoundException e) {
                e.printStackTrace();
            }
            if (rewards != null && rewards.getRewardingLevel() != null) {
                for (Purchase purchase : basket.getPurchaseList()) {
                    BigDecimal totalDiscount = purchase.getProduct().getPrice().multiply(discountRatePerLevel.get(rewards.getRewardingLevel())).multiply(BigDecimal.valueOf(purchase.getQuantity()));
                    discounts.add(new Discount(Collections.singletonList(purchase.getProduct()), this, "Discount of " + discountRatePerLevel.get(rewards.getRewardingLevel()) + "% because you are a " + rewards.getRewardingLevel() + " customer.", totalDiscount));
                }
            } else {
                logger.debug("customer not identified or rewarding level undetermined " + basket.getCustomerIdentifier());
            }
        }
        return discounts;
    }
}