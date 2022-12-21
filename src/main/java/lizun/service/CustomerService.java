package lizun.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lizun.dto.CustomerDto;
import lizun.dto.UserDto;
import lizun.mappers.CustomerMapper;
import lizun.mappers.RoleMapper;
import lizun.mappers.UserMapper;
import lizun.model.Customer;
import lizun.model.Role;
import lizun.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {


    private final CustomerMapper customerMapper;
    private final UserMapper userMapper;
    private final SecurityService securityService;
    private final RoleMapper roleMapper;

    @Autowired
    public CustomerService(CustomerMapper customerMapper, RoleMapper roleMapper,
                           UserMapper userMapper, SecurityService securityService) {
        this.customerMapper = customerMapper;
        this.roleMapper = roleMapper;
        this.userMapper = userMapper;
        this.securityService = securityService;
    }

    public Customer setNewVisitor(String phone) {
        Customer customer = securityService.createCryptoCustomer(phone);
        Role role = roleMapper.getRoleIdByName("VISITOR");
        customer.setRole(role);
        return customerMapper.setNewCustomer(customer);
    }

    public Customer setNewCustomer(String phone, String pswd) {
        Customer customer = securityService.createCryptoCustomer(phone);
        User user = securityService.createCryptoUser(pswd);
        user = userMapper.setUser(user);
        customer.setUser(user);
        Role role = roleMapper.getRoleIdByName("CUSTOMER");
        customer.setRole(role);
      //  System.out.println(DatatypeConverter.parseHexBinary(customer.getKey()).length + " " +
        //  DatatypeConverter.parseHexBinary(customer.getIv()).length);
        return customerMapper.setNewCustomer(customer);
    }

    public Customer changeRoleToCustomer(Customer customer, String pswd) {
        User user = securityService.createCryptoUser(pswd);
        user = userMapper.setUser(user);
        customer.setUser(user);
        Role role = roleMapper.getRoleIdByName("CUSTOMER");
        customer.setRole(role);
        return customerMapper.updateCustomer(customer);
    }

    public Customer setNewCustomerAndCheck(UserDto customer) {
        Customer state = new Customer();
        Customer existCostumer = getCustomerByPhone(customer.getPhone());
        if (existCostumer != null) {
            if (existCostumer.getUser() == null) {
                state = changeRoleToCustomer(existCostumer, customer.getPswd());
            } else {
                if (BCrypt.verifyer().verify(customer.getPswd().toCharArray(),
                        existCostumer.getUser().getHash()).verified) {
                    state = existCostumer;
                }
            }
        } else {
            state = setNewCustomer(customer.getPhone(), customer.getPswd());
        }
        return state;

    }

    public Customer getCustomerByPhone(String phone) {
        List<Customer> customers = customerMapper.getCustomers();
        for (Customer customer : customers) {
            if (securityService.comparePhone(customer, phone))
                return customer;
        }
        return null;
    }

    public boolean setAdmin(Customer customer) {
        return true;
    }

    public List<CustomerDto> getCustomers() {
        List<Customer> customers = customerMapper.getCustomers();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            Integer count = customerMapper.getCountOfOrders(customer);
            Integer sum = customerMapper.getSumOfAllOrders(customer);
            customerDtos.add(new CustomerDto(securityService.getDecryptPhone(customer),
                    customer.getRole().getName(), count,
                    sum));
        }
        return customerDtos;
    }

}
