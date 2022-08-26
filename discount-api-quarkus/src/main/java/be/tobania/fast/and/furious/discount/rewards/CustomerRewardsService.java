package be.tobania.fast.and.furious.discount.rewards;


public interface CustomerRewardsService {

    CustomerRewards retrieveCustomerRewards(String customerIdentifier) throws CustomerNotFoundException;
}
