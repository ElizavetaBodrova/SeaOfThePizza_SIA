package lizun.service;

import lizun.dto.OrderDto;
import lizun.mappers.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderMapper orderMapper;

    public OrderService() {
        orderMapper=null;
    }

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public Integer addOrder(OrderDto orderDto) {
        Integer id = orderMapper.insertNewOrder(
                orderDto.getOrder(),
                orderDto.getNumberOfDish(),
                orderDto.getTypeOfDelivery(),
                orderDto.getPoint(),
                orderDto.getPhone());
        return id;
    }
}
