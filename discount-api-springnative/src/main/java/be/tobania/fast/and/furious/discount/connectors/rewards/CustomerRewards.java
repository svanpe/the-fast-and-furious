package be.tobania.fast.and.furious.discount.connectors.rewards;

public class CustomerRewards {

    private String customerIdentifier;
    private Integer customerPoints;

    CustomerRewards(CustomerRewardsEntity entity) {
        this(entity.getCustomerIdentifier(), entity.getCustomerPoints());
    }

    public CustomerRewards(String customerIdentifier, Integer customerPoints) {
        super();
        this.setCustomerIdentifier(customerIdentifier);
        this.setCustomerPoints(customerPoints);

    }

    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

    public void setCustomerIdentifier(String customerIdentifier) {
        this.customerIdentifier = customerIdentifier;
    }

    public Integer getCustomerPoints() {
        return customerPoints;
    }

    public void setCustomerPoints(Integer customerPoints) {
        this.customerPoints = customerPoints;
    }

    public RewardingLevel getRewardingLevel() {
        for (RewardingLevel level : RewardingLevel.values()) {
            if (level.isInRange(customerPoints)) {
                return level;
            }
        }

        return null;
    }
}