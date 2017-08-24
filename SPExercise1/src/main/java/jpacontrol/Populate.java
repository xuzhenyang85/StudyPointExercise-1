
package jpacontrol;

import entity.Customer;
import entity.DiscountFixed;
import entity.DiscountQuantity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Populate
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        DiscountQuantity dq = new DiscountQuantity();
        em.persist(dq);
        
        DiscountFixed df = new DiscountFixed();
        em.persist(df);
        
        Customer c = new Customer();
        c.addDiscountType(dq);
        c.setPrice(c.getPrice(100, 3));
        em.persist(c);
        
        
        em.getTransaction().commit();
        em.close();
    }
}
