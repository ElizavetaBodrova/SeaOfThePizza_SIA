package lizun.controller;


import lizun.model.Customer;
import lizun.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }
    @RequestMapping(value = "/customer", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public  void addNewCustomer(@RequestBody Customer customer) {
        System.out.println("control");
        System.out.println(customer.getId()+" "+customer.getPhone());
        customerService.setNewCustomer(customer);

    }
}
