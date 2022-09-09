package be.tobania.fast.and.furious.discount.discountrules;

import be.tobania.fast.and.furious.discount.connectors.redmarket.RedMarketService;
import be.tobania.fast.and.furious.discount.connectors.redmarket.RedPrice;
import be.tobania.fast.and.furious.discount.model.Basket;
import be.tobania.fast.and.furious.discount.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RedPriceAdjustmentRule extends DiscountRule{

    @Autowired
    RedMarketService redMarketService;

    public RedPriceAdjustmentRule() {
        super("Adjustment to the lowest price Discount");
    }

    @Override
    public List<Discount> computeDiscount(Basket basket) {
        List<Discount> allDiscounts = new ArrayList<>();
        for(Purchase purchase : basket.getPurchaseList()){
            RedPrice redPrice = redMarketService.getRedPrice(purchase.getProduct().getCode());
            if(redPrice!=null){
                if(redPrice.getPrice().compareTo(purchase.getProduct().getPrice())<0){
                  BigDecimal totalDiscount =  purchase.getProduct().getPrice().add(redPrice.getPrice().negate()).multiply(BigDecimal.valueOf(purchase.getQuantity()));
                  allDiscounts.add(new Discount(Collections.singletonList(purchase.getProduct()),this, "Price is adjusted to the lowest price on the market (" + redPrice.getPrice()+")", totalDiscount));
                }
            }
        }
        return allDiscounts;
    }
}
