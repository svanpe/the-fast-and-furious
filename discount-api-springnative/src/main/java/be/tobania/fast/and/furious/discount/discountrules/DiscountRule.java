package be.tobania.fast.and.furious.discount.discountrules;

import be.tobania.fast.and.furious.discount.model.Basket;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(as = DiscountRuleData.class)
public abstract class DiscountRule {

    public DiscountRule(String label) {
        super();
        setLabel(label);
    }

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public abstract List<Discount> computeDiscount(Basket basket);
}