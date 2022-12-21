package lizun.service;

import lizun.dto.OrderDto;
import lizun.dto.OrdersDto;
import lizun.mappers.DishMapper;
import lizun.mappers.OrderMapper;
import lizun.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final DishMapper dishMapper;
    private final CustomerService customerService;


    public OrderService(OrderMapper orderMapper, DishMapper dishMapper, CustomerService customerService) {
        this.orderMapper = orderMapper;
        this.dishMapper = dishMapper;
        this.customerService = customerService;
    }

    public Integer addOrder(OrderDto orderDto) {
        for (int i = 0; i < orderDto.getOrder().size(); i++) {
            Integer id = orderDto.getOrder().get(i).getId();
            if (id == null) {
                String name = orderDto.getOrder().get(i).getName();
                Integer group = orderDto.getOrder().get(i).getGroup().getId();
                Integer newId = dishMapper.getIdDishByNameAndByGroupName(name, group);
                orderDto.getOrder().get(i).setId(newId);
            }

        }
        Customer customer = customerService.getCustomerByPhone(orderDto.getPhone());
        if (customer == null) {
            customer = customerService.setNewVisitor(orderDto.getPhone());
        }
        Integer id = orderMapper.insertNewOrder(
                orderDto.getOrder(),
                orderDto.getNumberOfDish(),
                orderDto.getTypeOfDelivery(),
                orderDto.getPoint(),
                customer.getId());
        return id;
    }

    public List<OrdersDto> getLastOrderByIDCustomer(String phone) {
        Customer customer = customerService.getCustomerByPhone(phone);
        ArrayList<OrdersDto> orders = orderMapper.findLastOrderByCustomersPhone(customer.getPhone());
        return orders;
    }
}
