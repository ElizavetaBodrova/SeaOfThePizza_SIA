package lizun.controller;


import lizun.dto.CustomerDto;
import lizun.dto.UserDto;
import lizun.model.Customer;
import lizun.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ResponseBody
    @RequestMapping(value = "/customer", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer addNewCustomer(@RequestBody UserDto customer) {

        return customerService.setNewCustomerAndCheck(customer);

    }

    @ResponseBody
    @RequestMapping(value = "/admin", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addAdmin(@RequestBody Customer customer) {

        return customerService.setAdmin(customer);

    }

    @ResponseBody
    @RequestMapping(value = "/customers", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDto> getCustomers() {

        return customerService.getCustomers();

    }
}
