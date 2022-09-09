package be.tobania.fast.and.furious.discount.connectors.rewards;


public interface CustomerRewardsService {

    CustomerRewards retrieveCustomerRewards(String customerIdentifier) throws CustomerNotFoundException;
}
