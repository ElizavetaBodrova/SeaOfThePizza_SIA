package lizun.mappers;

import lizun.model.Customer;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    void setNewCustomer(@Param("customer") Customer customer);
    Customer getCustomerByPhone(@Param("phone") String phone);

}
