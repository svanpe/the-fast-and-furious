package be.tobania.fast.and.furious.discount.rewards;



import javax.persistence.*;

@Entity
public class CustomerRewardsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false, length = 50, unique = true)
    private String customerIdentifier;

    @Column(nullable = false)
    private Integer customerPoints;

    public CustomerRewardsEntity() {
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


    public Integer getId() {
        return id;
    }


    public boolean isNew() {
        return id == null;
    }
}
