package be.tobania.fast.and.furious.discount.rewards;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CustomerRewardsRepositoryImpl implements CustomerRewardsRepository{

    @Inject
    EntityManager em;

    @Override
    public CustomerRewardsEntity findByCustomerIdentifier(String customerIdentifier) {
        List<CustomerRewardsEntity> results = em.createQuery("select cr from CustomerRewardsEntity cr where cr.customerIdentifier = :identifier", CustomerRewardsEntity.class)
                .setParameter("identifier", customerIdentifier ).getResultList();

        if(results.isEmpty()){
            return null;
        } else {
            return results.get(0);
        }


    }
}
