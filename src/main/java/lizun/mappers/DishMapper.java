package lizun.mappers;

import lizun.model.Dish;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface DishMapper {
//    @Select("SELECT * " +
//            "FROM DISH " +
//            "JOIN GROUPS_DISH GD ON GD.ID = DISH.ID_GROUP " +
//            "WHERE GD.NAME = #{groupName}")
    List<Dish> getDishByGroupName(@Param("groupName") String groupName);
}
