package be.tobania.fast.and.furious.discount.model;


import java.util.Collections;
import java.util.List;


public class DiscountRule {

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

    public List<Discount> computeDiscount(Basket basket){ return Collections.emptyList();};
}