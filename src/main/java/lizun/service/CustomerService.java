package lizun.service;

import lizun.mappers.CustomerMapper;
import lizun.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    CustomerMapper customerMapper;




    public void setNewCustomer(Customer customer){
        System.out.println("service");
        customerMapper.setNewCustomer(customer);
    }


}
