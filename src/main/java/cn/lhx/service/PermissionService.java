package cn.lhx.service;

import cn.lhx.entity.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionService {

    List<Permission> listAll();

    //PageInfo<Permission> query(QueryObject qo);

    Set<String> queryAllExpression();

    Set<String> queryExpressionByEmployeeId(Long id);
}
