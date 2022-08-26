package be.tobania.fast.and.furious.discount.rewards;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CustomerRewardsServiceImpl implements CustomerRewardsService {

    @Inject
    private CustomerRewardsRepository crRepo;

    @Inject
    public void setCrRepo(CustomerRewardsRepository crRepo) {
        this.crRepo = crRepo;
    }

    @Override
    public CustomerRewards retrieveCustomerRewards(String customerIdentifier) throws CustomerNotFoundException {

        CustomerRewardsEntity entity = crRepo.findByCustomerIdentifier(customerIdentifier);

        if (entity == null) {
            throw new CustomerNotFoundException("Customer not found");
        }

        return new CustomerRewards(entity);
    }
}