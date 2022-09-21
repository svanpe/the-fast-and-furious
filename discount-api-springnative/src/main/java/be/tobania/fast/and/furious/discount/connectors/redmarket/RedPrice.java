package be.tobania.fast.and.furious.discount.connectors.redmarket;

import java.math.BigDecimal;
import java.time.LocalDate;


public class RedPrice {

    public String productCode;
    public String productName;
    public LocalDate priceDate;
    public BigDecimal price;

    public RedPrice() {
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(LocalDate priceDate) {
        this.priceDate = priceDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
