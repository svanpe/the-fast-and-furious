package be.tobania.fast.and.furious.discount.connectors.rewards;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
@NamedQuery(name = "CustomerRewardsEntity.findByCustomerIdentifier", query = "from CustomerRewardsEntity cr where cr.customerIdentifier = ?1")
public class CustomerRewardsEntity implements Persistable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column(nullable = false, length = 50, unique = true)
    private String customerIdentifier;

    @Column(nullable = false)
    private Integer customerPoints;

    private CustomerRewardsEntity() {
    }

    public CustomerRewardsEntity(String customerIdentifier, Integer customerPoints) {
        this.customerIdentifier = customerIdentifier;
        this.customerPoints = customerPoints;
    }

    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

    public Integer getCustomerPoints() {
        return customerPoints;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }
}
