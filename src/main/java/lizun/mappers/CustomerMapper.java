package lizun.mappers;

import lizun.model.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerMapper {

    List<Customer> getCustomers();
    Integer getCountOfOrders(@Param("customer") Customer customer);
    Integer getSumOfAllOrders(@Param("customer") Customer customer);
   // Customer setPassword(@Param("customer") Customer customer);
    Customer setNewCustomer(@Param("customer") Customer customer);
    Customer updateCustomer(@Param("customer") Customer customer);
    //Customer getCustomerByPhone(@Param("phone") String phone);
    Customer getCustomerById(@Param("id") Integer id);
}
