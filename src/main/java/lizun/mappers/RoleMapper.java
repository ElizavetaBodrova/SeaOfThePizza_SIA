package lizun.mappers;

import lizun.model.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    Role getRoleIdByName(@Param("name") String name);
}
