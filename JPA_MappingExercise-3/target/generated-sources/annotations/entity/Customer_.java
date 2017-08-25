package entity;

import entity.DiscountType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-25T09:53:09")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile ListAttribute<Customer, DiscountType> dts;
    public static volatile SingularAttribute<Customer, Double> price;
    public static volatile SingularAttribute<Customer, Long> id;

}