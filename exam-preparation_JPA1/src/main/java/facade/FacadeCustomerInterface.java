
package facade;

import entity.Customer;
import entity.ItemType;
import entity.ProductOrder;
import entity.OrderLine;
import java.util.List;

public interface FacadeCustomerInterface
{
    //customer
    public Customer getCustomer(Long id);
    public Customer addCustomer(Customer c);
    public void deleteCustomer(Long id);
    public Customer editCustomer (Customer c);
    public List<Customer> getCustomers();
    //order
    public ProductOrder addOrder(ProductOrder o);
    public Customer addOrderByCustomer(ProductOrder o, Customer c);
    public ProductOrder getOrder(Long id);
    //item
    public ItemType addItemType(ItemType i);
    //orderline
    public OrderLine addOrderLine(OrderLine o);
    //totalprice
    public double totalPrice (Long id);
}
