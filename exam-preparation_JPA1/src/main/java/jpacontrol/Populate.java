package jpacontrol;

import entity.Customer;
import entity.ItemType;
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
        
        Customer c = new Customer("William1","william@dk.dk");
        em.persist(c);
//        
//        Customer c1 = em.find(Customer.class, 5l);
//        System.out.println("Email: "+c1.getEmail());
//        
//        Query Dquery1 = em.createQuery("SELECT c FROM Customer c");
//        List<Customer> customersAll = Dquery1.getResultList();
//        for(Customer customer: customersAll)
//        {
//            System.out.println("Customer " + customer);
//        }
//        
//        ItemType i1 = new ItemType("TV","LG 55' ULTRA HD TV",10.0);
//        em.persist(i1);
        
        em.getTransaction().commit();
        em.close();
    }
}
