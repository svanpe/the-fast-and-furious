package be.tobania.fast.and.furious.discount.connectors.rewards;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRewardsRepository extends CrudRepository<CustomerRewardsEntity, Long> {

    CustomerRewardsEntity findByCustomerIdentifier(String customerIdentifier);
}
