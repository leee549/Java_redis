package cn.lhx.dao;

import cn.lhx.entity.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionDao {

    List<Permission> listAll();

    Set<String> queryAllExpression();

    Set<String> selectByEmployeeId(Long id);

    List<Permission> selectByRoleId(Long id);
}
