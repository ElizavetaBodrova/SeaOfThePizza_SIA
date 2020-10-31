package lizun.service;

import lizun.dto.OrderDto;
import lizun.dto.OrdersDto;
import lizun.mappers.DishMapper;
import lizun.mappers.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final DishMapper dishMapper;



    public OrderService(OrderMapper orderMapper, DishMapper dishMapper) {
        this.orderMapper = orderMapper;
        this.dishMapper = dishMapper;
    }

    public Integer addOrder(OrderDto orderDto) {
        for (int i = 0; i <orderDto.getOrder().size() ; i++) {
            Integer id=orderDto.getOrder().get(i).getId();
            if(id==null){
                String name=orderDto.getOrder().get(i).getName();
                Integer group=orderDto.getOrder().get(i).getGroup().getId();
                Integer newId=dishMapper.getIdDishByNameAndByGroupName(name,group);
                orderDto.getOrder().get(i).setId(newId);
            }

        }
        Integer id = orderMapper.insertNewOrder(
                orderDto.getOrder(),
                orderDto.getNumberOfDish(),
                orderDto.getTypeOfDelivery(),
                orderDto.getPoint(),
                orderDto.getPhone());
        return id;
    }

    public List<OrdersDto> getLastOrderByIDCustomer(String phone){
        ArrayList<OrdersDto> orders=orderMapper.findLastOrderByCustomersPhone(phone);

        return orders;
    }
}
