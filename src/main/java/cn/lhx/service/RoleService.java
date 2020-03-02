package cn.lhx.service;

import cn.lhx.entity.Permission;
import cn.lhx.entity.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {


    //PageInfo<Role> query(QueryObject qo);

    List<Role> listAll();

    Role selectById(Long id);


    Set<String> querySnByEmployeeId(Long id);

    void deleteById(Integer id);

    void update(Role role, Long[] ids);

    void save(Role role, Long[] ids);

    List<Permission> selectPermissionById(Long id);
}
