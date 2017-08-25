package facade;

import entity.Customer;
import entity.ItemType;
import entity.ProductOrder;
import entity.OrderLine;
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

    @Override
    public ProductOrder addOrder(ProductOrder o)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            return o;
        } finally
        {
            em.close();
        }
    }

    @Override
    public ProductOrder getOrder(Long id)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            ProductOrder o = em.find(ProductOrder.class, id);
            em.getTransaction().commit();
            return o;
        } finally
        {
            em.close();
        }
    }

    @Override
    public ItemType addItemType(ItemType i)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();
            return i;
        } finally
        {
            em.close();
        }
    }

    @Override
    public OrderLine addOrderLine(OrderLine o)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            return o;
        } finally
        {
            em.close();
        }
    }
    
    @Override
    public Customer addOrderByCustomer(ProductOrder o, Customer cust)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            
            cust.addOrder(o);
            o.addCust(cust);
            em.persist(o);
            em.merge(cust);
            
            em.getTransaction().commit();
            return cust;
        } finally
        {
            em.close();
        }
    }

    @Override
    public ItemType getItemType(Long id)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            ItemType i = em.find(ItemType.class, id);
            em.getTransaction().commit();
            return i;
        } finally
        {
            em.close();
        }
    }
    
    @Override
    public double totalPrice(ProductOrder po)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            
            List<OrderLine> orderlines =  po.getOrderLines();
            
            double totalprice = 0;
            
            for (OrderLine orderline : orderlines)
            {
                int quantity = orderline.getQuantity();
                double itemprice = orderline.getItemtype().getPrice();
                totalprice += quantity * itemprice;
            }
            em.getTransaction().commit();
            
            return totalprice;
        } finally
        {
            em.close();
        }
    }


}
