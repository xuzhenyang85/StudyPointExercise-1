
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;
    
    private List<DiscountType> dts = new ArrayList<>();
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public double getPrice(double pricePerItem, int quantity)
    {
        double bestDiscount = 0;
        for (int i = 0; i < dts.size(); i++)
        {
           if(dts.get(i).calcDiscount(pricePerItem, quantity) > bestDiscount){
               bestDiscount = dts.get(i).calcDiscount(pricePerItem, quantity);
           }
        }
        return (pricePerItem * quantity) - bestDiscount;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void addDiscountType(DiscountType dts){
        this.dts.add(dts);
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer))
        {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Customer{" + "id=" + id + ", price=" + price + ", dts=" + dts + '}';
    }


}
