package com.museum.common.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.domain.Account;
import com.museum.domain.Permission;
import com.museum.domain.Role;
import com.museum.service.IAccountService;
import com.museum.service.IPermissionService;
import com.museum.service.IRoleService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MyRealm extends AuthorizingRealm {
    @Resource
    private IAccountService accountService;

    @Resource
    private IRoleService roleService;

    @Resource
    private IPermissionService permissionService;

    //根据token判断此Authenticator是否使用该realm
    //必须重写不然shiro会报错
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如@RequiresRoles,@RequiresPermissions之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权~~~~~");
        String token=principals.toString();
        String username=JWTUtil.getUsername(token);
        //查询用户名称
        QueryWrapper qw = new QueryWrapper();
        qw.eq("userName", username);
        Account acc = accountService.getOne(qw);

        //查询用户角色
        QueryWrapper qw1 = new QueryWrapper();
        qw.eq("userId", acc.getId());
        List<Role> ro = roleService.list(qw1);

        //查询用户权限
        QueryWrapper qw2 = new QueryWrapper();
        qw.eq("userId", acc.getId());
        List<Permission> pr = permissionService.list(qw1);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : ro) {
            simpleAuthorizationInfo.addRole(role.getName());
        }
        //权限
        for (Permission permissions : pr) {
            simpleAuthorizationInfo.addStringPermission(permissions.getName());
        }
        return simpleAuthorizationInfo;
    }


    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可，在需要用户认证和鉴权的时候才会调用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String jwt= (String) token.getCredentials();
        String username= null;
        //decode时候出错，可能是token的长度和规定好的不一样了
        try {
            username= JWTUtil.getUsername(jwt);
        }catch (Exception e){
            throw new AuthenticationException("token非法，不是规范的token，可能被篡改了，或者过期了");
        }
        if (!JWTUtil.verify(jwt)||username==null){
            throw new AuthenticationException("token认证失效，token错误或者过期，重新登陆");
        }
        //查询用户名称
        QueryWrapper qw = new QueryWrapper();
        qw.eq("userName", username);
        Account acc = accountService.getOne(qw);
        if (acc==null){
            throw new AuthenticationException("该用户不存在");
        }

        return new SimpleAuthenticationInfo(jwt,jwt,"MyRealm");
    }
}
