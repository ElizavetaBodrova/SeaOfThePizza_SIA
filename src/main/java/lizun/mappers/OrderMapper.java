package lizun.mappers;

import lizun.dto.OrdersDto;
import lizun.model.Dish;
import lizun.model.Order;
import lizun.model.Point;
import lizun.model.TypeOfDelivery;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface OrderMapper {

    Order isOrderExist(@Param("id") Integer id, @Param("id_customer") Integer id_customer);

    Integer insertNewOrder(@Param("order") List<Dish> order, @Param("count") List<Integer> numberOfDish,
                           @Param("type") TypeOfDelivery typeOfDelivery, @Param("point") Point point,
                           @Param("customerId")Integer customerId);
    ArrayList<OrdersDto> findLastOrderByCustomersPhone(@Param("phone")String phone);
}
