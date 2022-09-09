package be.tobania.fast.and.furious.discount.connectors.rewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerRewardsServiceImpl implements CustomerRewardsService {

    private CustomerRewardsRepository crRepo;

    @Autowired
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