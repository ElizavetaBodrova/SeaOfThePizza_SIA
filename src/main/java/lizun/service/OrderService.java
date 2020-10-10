package lizun.service;

import lizun.dto.OrderDto;
import lizun.mappers.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper){
        this.orderMapper=orderMapper;
    }

    public boolean addOrder(OrderDto orderDto){
        return orderMapper.insertNewOrder(orderDto);
    }
}
