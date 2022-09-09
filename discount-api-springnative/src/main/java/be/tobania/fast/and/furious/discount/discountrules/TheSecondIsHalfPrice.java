package be.tobania.fast.and.furious.discount.discountrules;

import be.tobania.fast.and.furious.discount.model.Basket;
import be.tobania.fast.and.furious.discount.model.Purchase;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheSecondIsHalfPrice extends DiscountRule {

    private String productId;

    public TheSecondIsHalfPrice(String productId) {

        super("The second is half price Discount");
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


    @Override
    public List<Discount> computeDiscount(Basket basket) {
        List<Discount> allDiscounts = new ArrayList<>();
        for (Purchase purchase : basket.getPurchaseList()) {
            if (StringUtils.compareIgnoreCase(purchase.getProduct().getCode(), getProductId()) == 0 && purchase.getQuantity() > 1) {
                int numberOfTuples = purchase.getQuantity().intValue() / 2;
                BigDecimal totalDiscount = purchase.getProduct().getPrice().multiply(BigDecimal.valueOf(numberOfTuples)).divide(BigDecimal.valueOf(2));
                allDiscounts.add(new Discount(Collections.singletonList(purchase.getProduct()), this, "You buy 1, the second is half price", totalDiscount));
            }
        }
        return allDiscounts;
    }
}