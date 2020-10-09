package lizun.service;

import lizun.mappers.CustomerMapper;
import lizun.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    private CustomerMapper customerMapper;

    public CustomerService(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public boolean setNewCustomer(Customer customer) {

        boolean state=false;
        Customer existCostumer = customerMapper.getCustomerByPhone(customer.getPhone());
        if (existCostumer != null) {
            if(existCostumer.getPassword().equals(customer.getPassword()) ){
                state=true;
            }
        } else {
            customerMapper.setNewCustomer(customer);
            state=true;
        }
        return state;

    }


}
