package lizun.mappers;

import lizun.model.Customer;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    Customer setNewCustomer(@Param("customer") Customer customer);
}
