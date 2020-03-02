package cn.lhx.service.impl;

import cn.lhx.dao.RoleDao;
import cn.lhx.entity.Permission;
import cn.lhx.entity.Role;
import cn.lhx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;


//    @Override
//    public PageInfo<Role> query(QueryObject qo) {
//
//        PageHelper.startPage(qo.getCurrentPage(),qo.getPagesize());
//
//        List<Role> roles = roleDao.listAll();
//        PageInfo<Role> pageInfo = new PageInfo<>(roles);
//        return pageInfo;
//    }

    @Override
    public List<Role> listAll() {
        return roleDao.listAll();
    }

    @Override
    public Role selectById(Long id) {
        return roleDao.selectById(id);
    }

    @Override
    public Set<String> querySnByEmployeeId(Long id) {
        return roleDao.querySnByEmployeeId(id);
    }

    @Override
    public void deleteById(Integer id) {
        roleDao.deleteById(id);
    }

    @Override
    public void update(Role role, Long[] ids) {
        roleDao.deleteRelation(role.getId());
        roleDao.updateByPrimaryKey(role);
        if (ids != null){
            for (Long id : ids){
                roleDao.insertRelation(role.getId(),id);
            }
        }
    }

    @Override
    public void save(Role role, Long[] ids) {
        roleDao.insert(role);
        if (ids != null){
            for (Long permissionId : ids){
            roleDao.insertRelation(role.getId(),permissionId);
            }
        }
    }

    @Override
    public List<Permission> selectPermissionById(Long id) {
        return roleDao.selectPermissionByid(id);
    }


}
