package lizun.mappers;

import lizun.model.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface CustomerMapper {
    void setNewCustomer(@Param("customer") Customer customer);
    Customer getCustomerByPhone(@Param("phone") String phone);

}
