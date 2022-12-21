package lizun.mappers;

import lizun.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User setUser(@Param("user") User user);
}
