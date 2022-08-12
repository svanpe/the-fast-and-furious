package be.tobania.fast.and.furious.discount.model;

import java.util.List;

public class Basket {

    private final String customerIdentifier;

    private final List<Purchase> purchaseList;

    public Basket(String customerIdentifier, List<Purchase> purchaseList) {
        this.customerIdentifier = customerIdentifier;
        this.purchaseList = purchaseList;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

}
