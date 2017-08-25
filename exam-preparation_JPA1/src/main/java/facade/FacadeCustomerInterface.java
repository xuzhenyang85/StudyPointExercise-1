
package facade;

import entity.Customer;
import java.util.List;

public interface FacadeCustomerInterface
{
    public Customer getCustomer(Long id);
    public Customer addCustomer(Customer c);
    public void deleteCustomer(Long id);
    public Customer editCustomer (Customer c);
    public List<Customer> getCustomers();
}
