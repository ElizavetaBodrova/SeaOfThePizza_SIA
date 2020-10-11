package lizun.mappers;

import lizun.model.Dish;
import org.apache.ibatis.annotations.Param;


import java.util.List;


public interface DishMapper {

    List<Dish> getDishByGroupName(@Param("groupName") String groupName);


}
