package cn.lhx.dao;

import cn.lhx.entity.Permission;
import cn.lhx.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    List<Role> listAll();

    List<Role> selectByEmployeeId(Long id);

    Role selectById(Long id);


    Set<String> querySnByEmployeeId(Long id);

    void deleteById(Integer id);

    void deleteRelation(Long id);

    void insert(Role role);

    void insertRelation(@Param("roleId") Long roleId,
                        @Param("permissionId") Long permissionId);

    List<Permission> selectPermissionByid(Long id);

    void updateByPrimaryKey(Role role);
}
