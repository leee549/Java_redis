package cn.lhx.security.shiro.realm;

import cn.hutool.core.util.ObjectUtil;
import cn.lhx.entity.User;
import cn.lhx.service.PermissionService;
import cn.lhx.service.RoleService;
import cn.lhx.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lee549
 * @date 2020/2/12 19:45
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;

    /**
     * 授权 分配角色
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获得username
        User user = (User) principals.getPrimaryPrincipal();
        //判断是否管理员 1 是 0 否；
        Boolean isAdmin = user.getAdmin();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        System.out.println(isAdmin);
        //设置权限
        if (isAdmin) {
            info.setStringPermissions(permissionService.queryAllExpression());
        } else {
            info.setStringPermissions(permissionService.queryExpressionByEmployeeId(user.getId()));
        }
        //设置角色
        info.setRoles(roleService.querySnByEmployeeId(user.getId()));
        return info;
    }

    /**
     * @param token 用户的身份信息 ：用户名 、密码
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        //获取用户输入的用户名
        System.out.println("1");
        String username = (String) token.getPrincipal();
        //查询数据库用户名
        System.out.println("2");
        User user = userService.queryByUserName(username);
        System.out.println("------------"+user);
        if (ObjectUtil.isEmpty(user)) {

            throw new UnknownAccountException("用户:" + username + "不存在");
        }

        // 定义盐(你这顺序不能乱放)
       // String salt = employee.getId().toString();

        return new SimpleAuthenticationInfo(user,
                user.getPassword(),
                //ByteSource.Util.bytes(salt),
                getName());

    }
}
