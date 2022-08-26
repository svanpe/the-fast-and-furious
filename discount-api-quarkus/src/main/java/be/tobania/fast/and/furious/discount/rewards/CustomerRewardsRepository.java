package be.tobania.fast.and.furious.discount.rewards;



public interface CustomerRewardsRepository {

    CustomerRewardsEntity findByCustomerIdentifier(String customerIdentifier);
}
