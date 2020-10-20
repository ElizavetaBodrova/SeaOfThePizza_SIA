package lizun.service;

import lizun.dto.OrderDto;
import lizun.mappers.DishMapper;
import lizun.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final DishMapper dishMapper;


    @Autowired
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
}
