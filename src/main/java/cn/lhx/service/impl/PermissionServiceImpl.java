package cn.lhx.service.impl;

import cn.lhx.dao.PermissionDao;
import cn.lhx.entity.Permission;
import cn.lhx.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    PermissionDao permissionDao;

    @Override
    public List<Permission> listAll() {
        return permissionDao.listAll();
    }

//    @Override
//    public PageInfo<Permission> query(QueryObject qo) {
//        PageHelper.startPage(qo.getCurrentPage(), qo.getPagesize());
//        List<Permission> pms = permissionDao.listAll();
//        PageInfo<Permission> pageInfo = new PageInfo<>(pms);
//        return pageInfo;
//    }

    @Override
    public Set<String> queryAllExpression() {
        List<Permission> pms = permissionDao.listAll();
        Set<String> set = new HashSet<>();
        for (Permission permission :pms){
            set.add(permission.getExpression());
        }
        //pms.forEach(pm -> set.add(pm.getExpression()));
        return set;

    }

    @Override
    public Set<String> queryExpressionByEmployeeId(Long id) {
        return permissionDao.selectByEmployeeId(id);
    }
}
