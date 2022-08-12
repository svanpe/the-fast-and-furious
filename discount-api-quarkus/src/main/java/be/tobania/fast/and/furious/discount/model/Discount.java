package be.tobania.fast.and.furious.discount.model;

import java.math.BigDecimal;
import java.util.List;


public class Discount {

    List<Product> productList;

    DiscountRule discountApplied;

    String discountExplanation;

    BigDecimal totalDiscount;

    public Discount(){
        super();
    }
    public Discount(List<Product> productList, DiscountRule discountApplied, String discountExplanation, BigDecimal totalDiscount) {
        super();
        this.productList = productList;
        this.discountApplied = discountApplied;
        this.discountExplanation = discountExplanation;
        this.totalDiscount = totalDiscount;
    }

    public String getDiscountExplanation() {
        return discountExplanation;
    }

    public void setDiscountExplanation(String discountExplanation) {
        this.discountExplanation = discountExplanation;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public DiscountRule getDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(DiscountRule discountApplied) {
        this.discountApplied = discountApplied;
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(BigDecimal totalDiscount) {
        this.totalDiscount = totalDiscount;
    }
}
