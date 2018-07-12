package com.baizhi.cmfz.realm;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.service.PermissionService;
import com.baizhi.cmfz.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-12 14:19:45
 **/
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        String username = (String) principal.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Role> roles = roleService.queryRoleByMgrName(username);
        for (Role role : roles) {
            info.addRole(role.getRoleTag());
        }
        List<Permission> permissions = permissionService.queryPermissionByMgrName(username);
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getPermissionTag());
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) token;
        String username=usernamePasswordToken.getUsername();
        Manager manager = managerService.queryManagerByName(username);
        if(manager!=null){
            return new SimpleAuthenticationInfo(
                    manager.getMgrName(),
                    manager.getMgrPwd(),
                    ByteSource.Util.bytes(manager.getMgrSalt()),
                    UUID.randomUUID().toString());
        }
        return null;
    }
}
