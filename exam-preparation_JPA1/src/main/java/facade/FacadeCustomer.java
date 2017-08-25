package facade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class FacadeCustomer implements FacadeCustomerInterface
{
    private EntityManagerFactory emf;

    public FacadeCustomer(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    @Override
    public Customer getCustomer(Long id)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            Customer c = em.find(Customer.class, id);
            em.getTransaction().commit();
            return c;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Customer addCustomer(Customer c)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return c;
        } finally
        {
            em.close();
        }
    }

    @Override
    public void deleteCustomer(Long id)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.remove(id);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
    }

    @Override
    public Customer editCustomer(Customer c)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
            return c;
        } finally
        {
            em.close();
        }
    }

    @Override
    public List<Customer> getCustomers()
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT c FROM Customer c");
            List<Customer> customers = q.getResultList();
            em.getTransaction().commit();
            return customers;
        } finally
        {
            em.close();
        }
    }

}
