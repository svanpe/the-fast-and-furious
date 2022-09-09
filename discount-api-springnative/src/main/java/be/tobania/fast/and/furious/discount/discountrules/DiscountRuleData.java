package be.tobania.fast.and.furious.discount.discountrules;

import be.tobania.fast.and.furious.discount.model.Basket;

import java.util.List;

/**
 * Bad design requires tricks : the cucumber client needs to be able to instenciate the abstract discount rule.
 * A DDD design and separated objects between the API objects exposed and the domain model would be better
 * ... but it is not the purpose of this project.
 */
public final class DiscountRuleData extends DiscountRule {

    public DiscountRuleData() {
        super(null);
    }


    public DiscountRuleData(String label) {
        super(label);
    }

    @Override
    public List<Discount> computeDiscount(Basket basket) {
        return null;
    }
}
