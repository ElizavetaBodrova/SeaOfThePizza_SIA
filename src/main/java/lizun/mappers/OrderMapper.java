package lizun.mappers;

import lizun.dto.OrderDto;
import lizun.model.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    Order isOrderExist(@Param("id") Integer id, @Param("phone") String phone);

    boolean insertNewOrder(@Param("order") OrderDto orderDto);
}
