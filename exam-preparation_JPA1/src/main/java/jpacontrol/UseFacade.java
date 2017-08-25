package jpacontrol;

import entity.Customer;
import entity.ItemType;
import entity.OrderLine;
import entity.ProductOrder;
import facade.FacadeCustomer;
import facade.FacadeCustomerInterface;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;

public class UseFacade
{

    public static void main(String[] args)
    {
        FacadeCustomerInterface facade = new FacadeCustomer(Persistence.createEntityManagerFactory("jpaPU"));

        //add a customer
        System.out.println("Create a customer: " +facade.addCustomer(new Customer("Julie", "julie@dk.dk")));
        System.out.println("Create a customer: " +facade.addCustomer(new Customer("Ole", "julie@dk.dk")));
        System.out.println("Create a customer: " +facade.addCustomer(new Customer("Peter", "julie@dk.dk")));
        System.out.println("Create a customer: " +facade.addCustomer(new Customer("Madsen", "julie@dk.dk")));

        //find a customer
        System.out.println("Find a customer: " + facade.getCustomer(1l));

        //get all customers
        List<Customer> customers = new ArrayList<>();
        customers = facade.getCustomers();
        for (Customer customer : customers)
        {
            System.out.println("A list of customers: "+customer);
        }
        
        //create an order
        System.out.println("Create an order: " + facade.addOrder(new ProductOrder()));
        
        //add an order by a customer
        Customer c = facade.getCustomer(1l);
        c.setEmail("newemail@somemail.dk");
        System.out.println("Create an order by a customer" + facade.addOrderByCustomer(new ProductOrder(), c));
        
        //find an order
        System.out.println("find an order: " + facade.getOrder(1l));
        
        //create  an ItemType
        System.out.println("create an ItemType: "+ facade.addItemType(new ItemType("TV","LG 55' HD fladskærm",8888)));
        System.out.println("create an ItemType: "+ facade.addItemType(new ItemType("Iphone","Iphone 8",5899)));
        System.out.println("create an ItemType: "+ facade.addItemType(new ItemType("Sko","ECCO sko",800)));
        //create orderLines
        ProductOrder pu1 = facade.getOrder(2l);
        ItemType it1 = facade.getItemType(1l);
        System.out.println("create an ORDERLINE: " + facade.addOrderLine(new OrderLine(2, pu1, it1)));
        
        ProductOrder pu2 = facade.getOrder(2l);
        ItemType it2 = facade.getItemType(2l);
        System.out.println("create an ORDERLINE: " + facade.addOrderLine(new OrderLine(2, pu2, it2)));
        
        ProductOrder pu3 = facade.getOrder(2l);
        ItemType it3 = facade.getItemType(3l);
        System.out.println("create an ORDERLINE: " + facade.addOrderLine(new OrderLine(2, pu1, it3)));
        
        
        //find the total price of an order
        ProductOrder order1 = facade.getOrder(2l);
        double totalprice = facade.totalPrice(order1);
        System.out.println("Total price: " + totalprice);
        
    }
}
